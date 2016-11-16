/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateFactory;
import xmldata.objects.XNessusClientData;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;
import util.ConstantValues;
import xmldata.objects.XFamilyItem;
import xmldata.objects.XItem;
import xmldata.objects.XPluginItem;
import xmldata.objects.XReportHost;
import xmldata.objects.XReportItem;
import entity.*;
import util.DateConverter;
import xmldata.objects.XTag;
import xmldata.objects.XHostProperties;

public class Loader {
    Session session = null;
    Transaction transaction= null;
    XNessusClientData nessusClientData = null;
    
    public String addUser() {
        String message = "";
        
        Users user = new Users();
        user.setUserId("Ron");
        user.setPassword("12345");
        user.setMiddleName("");
        user.setFirstName("Ron");
        user.setLastName("Ingram");
        user.setEmail("IngramRon@gmail.com");
        user.setPhone("2025960493");
        user.setRole("admin");
        
        try {
            session = HibernateFactory.openSession();
            transaction = session.beginTransaction();
                  
            session.save(user);
           
            session.flush();
            transaction.commit();
            
            message = "User " + user.getUserId() + " has been added successfully.";
           
        } catch (Exception ex) {
            transaction.rollback();
            message = "Adding user " + user.getUserId() + " failed.";
        } finally{
            if(session != null) {
                session.close();
            }
        }
        
        return message;
    }

    public Integer addOrgnization(String orgName, String description) throws Exception {
        Integer id = -1;
        
        Organization org;
        org = new Organization();
        org.setOrgName(orgName);
        org.setDescription(description);   

        try {
            session = HibernateFactory.openSession();
            transaction = session.beginTransaction();
                   
            id = (Integer)session.save(org);
           
            session.flush();
            transaction.commit();
           
        } catch (Exception ex) {
            transaction.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
        return id;
    }
  
    public Integer loadData(String userId, Integer orgId, XNessusClientData nessusClientData) {
        int loadDataStatus = ConstantValues.LOAD_DATA_FAILED;
        this.nessusClientData = nessusClientData;
        
        try {
            session = HibernateFactory.openSession();
            transaction = session.beginTransaction();
            
            LoadCycle loadCycle = getLoadCycle(userId, orgId);          
            Integer loadCycleId = (Integer)session.save(loadCycle);
            
////////////////////////////////////////////////////////////////////////////////                        
            Policy policy = getPolicy(loadCycleId);
            Integer policyId = (Integer)session.save(policy);
            
            Preference preference = new Preference();
            preference.setPolicyId(policyId);
            Integer preferenceId = (Integer)session.save(preference);
            
            List<ServerPreference> serverPreferenceList = getServerPreferences(preferenceId);
            for (ServerPreference serverPreference : serverPreferenceList) {
                Integer serverPreferenceId = (Integer)session.save(serverPreference);
            }
            
            List<PluginsPreference> pluginsPreferenceList = getPluginsPreferences(preferenceId);
            for (PluginsPreference pluginsPreference : pluginsPreferenceList) {
                Integer pluginsPreferenceId = (Integer)session.save(pluginsPreference);
            }
            
            List<FamilySelection> familySelectionList = getFamilySelections(policyId);
            for (FamilySelection familySelection : familySelectionList) {
                Integer familySelectionId = (Integer)session.save(familySelection);
            }
            
            List<IndividualPluginSelection> individualPluginSelectionList = getIndividualPluginSelections(policyId);
            for (IndividualPluginSelection individualPluginSelection : individualPluginSelectionList) {
                Integer individualPluginSelectionId = (Integer)session.save(individualPluginSelection);
            }
            
////////////////////////////////////////////////////////////////////////////////            
            Report report = getReport(loadCycleId);
            Integer reportId = (Integer)session.save(report);
            int hostCount = 0;
            
            List<xmldata.objects.XReportHost> reportHostXmlList = nessusClientData.getReport().getReportHost();       
            for (xmldata.objects.XReportHost reportHostXml : reportHostXmlList) {
                ReportHost reportHost = new ReportHost();
                hostCount++;
                System.out.println("Host: " + hostCount + " of " + reportHostXmlList.size());
                
                reportHost.setReportHostName(reportHostXml.getAttributeName());
                reportHost.setReportId(reportId);
                Integer reportHostId = (Integer)session.save(reportHost);
                
                List<XReportItem> xReportItemList = reportHostXml.getReportItem();
                for (XReportItem xReportItem : xReportItemList) {
                    ReportItemAttribute reportItemAttribute = getReportItemAttribute(reportHostId, xReportItem);   
                    Integer reportItemArtributeId = (Integer)session.save(reportItemAttribute);
                    
                    List<String> reportItemNameList = ConstantValues.getReportItemNames();
                    for (String reportItemName : reportItemNameList) {
                        List<ReportItem> reportItemList = getReportItem(reportItemName, reportHostId, xReportItem);  
                        for (ReportItem reportItem : reportItemList) {
                            Integer reportItemId = (Integer)session.save(reportItem);
                        }
                    }                           
                }
                
                HostProperties hostProperties = getHostProperties(reportHostId, reportHostXml);
                Integer hostPropertiesId = (Integer)session.save(hostProperties);
                
            }

            loadDataStatus = loadCycleId;
            
            session.flush();
            transaction.commit();
            
       } catch (Exception ex) {
             transaction.rollback();
             loadDataStatus = ConstantValues.LOAD_DATA_FAILED;
             System.err.println(ex.getMessage());
        } finally{
            if(session != null) {
                session.close();
            }
        }
       
        return loadDataStatus;
    }

    private LoadCycle getLoadCycle(String userId, Integer orgId) {
        LoadCycle loadCycle = new LoadCycle();
        Date date = new Date();
        String dateString = DateConverter.getDateString(date);
        loadCycle.setLoadTime(dateString);
        loadCycle.setOrgId(orgId);
        loadCycle.setLoadBy(userId);
        
        return loadCycle;
    }

    private Policy getPolicy(Integer loadCycleId) {
        Policy policy = new Policy();
        policy.setPolicyName(nessusClientData.getPolicy().getPolicyName());
        policy.setLoadCycleId(loadCycleId);
        
        return policy;        
    }

    private List<FamilySelection> getFamilySelections(Integer policyId) {
        List<FamilySelection> familySelectionList = new ArrayList<FamilySelection>();
        List<XFamilyItem> familyItemList = nessusClientData.getPolicy().getFamilySelection().getFamilyItem();
        
        for (XFamilyItem familyItem : familyItemList) {
            FamilySelection familySelection = new FamilySelection();
        
            familySelection.setFamilyName(familyItem.getFamilyName());
            familySelection.setStatus(familyItem.getStatus());
            familySelection.setPolicyId(policyId);
            
            familySelectionList.add(familySelection);
        }
        return familySelectionList;
    }

    private List<IndividualPluginSelection> getIndividualPluginSelections(Integer policyId) {
        List<IndividualPluginSelection> individualPluginSelectionList = new ArrayList<IndividualPluginSelection>();
        List<XPluginItem> pluginItemList = nessusClientData.getPolicy().getIndividualPluginSelection().getPluginItem();
        
        for (XPluginItem pluginItem : pluginItemList) {
            IndividualPluginSelection individualPluginSelection = new IndividualPluginSelection();
        
            individualPluginSelection.setPluginIdData(pluginItem.getPluginId());
            individualPluginSelection.setPluginName(pluginItem.getPluginName());
            individualPluginSelection.setFamily(pluginItem.getFamily());
            individualPluginSelection.setStatus(pluginItem.getStatus());
            individualPluginSelection.setPolicyId(policyId);
            
            individualPluginSelectionList.add(individualPluginSelection);
        }
        return individualPluginSelectionList;
    }

    private List<ServerPreference> getServerPreferences(Integer preferenceId) {
        List<ServerPreference> ServerPreferenceList = new ArrayList<ServerPreference>();
        List<xmldata.objects.XPreference> PreferenceList = nessusClientData.getPolicy().getPreferences().getServerPreferences().getPreference();
        
        for (xmldata.objects.XPreference preference : PreferenceList) {
            ServerPreference serverPreference = new ServerPreference();
        
            serverPreference.setName(preference.getName());
            serverPreference.setValue(preference.getValue());
            serverPreference.setPreferenceId(preferenceId);
            
            ServerPreferenceList.add(serverPreference);
        }
        return ServerPreferenceList;
    }

    private List<PluginsPreference> getPluginsPreferences(Integer preferenceId) {
        List<PluginsPreference> pluginsPreferenceList = new ArrayList<PluginsPreference>();
        List<XItem> itemList = nessusClientData.getPolicy().getPreferences().getPluginsPreferences().getItem();
        
        for (XItem item : itemList) {
            PluginsPreference pluginsPreference = new PluginsPreference();
        
            pluginsPreference.setPluginId(item.getPluginId());
            pluginsPreference.setPluginName(item.getPluginName());
            pluginsPreference.setPreferenceName(item.getPreferenceName());
            pluginsPreference.setPreferenceType(item.getPreferenceType());
            pluginsPreference.setFullName(item.getFullName());
            pluginsPreference.setSelectedValue(item.getSelectedValue());
            pluginsPreference.setPreferenceId(preferenceId);
            
            pluginsPreferenceList.add(pluginsPreference);
        }
        return pluginsPreferenceList;
    }

    private List<ReportHost> getReportHosts(Integer reportId) {
        List<ReportHost> reportHostList = new ArrayList<ReportHost>();
        List<xmldata.objects.XReportHost> reportHostXmlList = nessusClientData.getReport().getReportHost();
        
        for (xmldata.objects.XReportHost reportHostXml : reportHostXmlList) {
            ReportHost reportHost = new ReportHost();
        
            reportHost.setReportHostName(reportHostXml.getAttributeName());
            reportHost.setReportId(reportId);
            
            reportHostList.add(reportHost);
        }
        return reportHostList;
    }
    private Report getReport(Integer loadCycleId) {
        xmldata.objects.XReport reportXml =  nessusClientData.getReport();
        Report report = new Report();
        report.setLoadCycleId(loadCycleId);
        report.setReportName(reportXml.getAttributeName());
        report.setXmlnsCm(reportXml.getAttributeXmlns_cm());
        
        return report;
    }

    private List<ReportItem> getReportItem(String reportItemName, Integer reportHostId, XReportItem xReportItem) throws Exception {
        List<ReportItem> reportItemList = new ArrayList<ReportItem>();
        List<String> reportItemNameList = ConstantValues.getReportItemNames();
        int idx = reportItemNameList.indexOf(reportItemName);
        String xValue = "";
        String xText = "";
        List<String> xList = new ArrayList<String>();
        
        try {
            switch (idx) {
                case 0: {
                    xValue = xReportItem.getAgent();
                    break;
                }
                case 1: {
                    xValue = xReportItem.getDescription();
                    break;
                }
                case 2: {
                    xValue = xReportItem.getFname();
                    break;
                }
                case 3: {
                    xValue = xReportItem.getPlugin_modification_date();
                    break;
                }
                case 4: {
                    xValue = xReportItem.getPlugin_name();
                    break;
                }
                case 5: {
                    xValue = xReportItem.getPlugin_publication_date();
                    break;
                }
                case 6: {
                    xValue = xReportItem.getPlugin_type();
                    break;
                }
                case 7: {
                    xValue = xReportItem.getRisk_factor();
                    break;
                }
                case 8: {
                    xValue = xReportItem.getScript_version();
                    break;
                }
                case 9: {
                    xValue = xReportItem.getSee_also();
                    break;
                }
                case 10: {
                    xValue = xReportItem.getSolution();
                    break;
                }
                case 11: {
                    xValue = xReportItem.getSynopsis();
                    break;
                }
                case 12: {
                    xText = xReportItem.getPlugin_output();
                    break;
                }
                case 13: {
                    xValue = xReportItem.getCpe();
                    break;
                }

                case 14: {
                    xList = xReportItem.getBid();
                    break;
                }
                case 15: {
                    xList = xReportItem.getCve();
                    break;
                }
                case 16: {
                    xList = xReportItem.getCvss_base_score();
                    break;
                }
                case 17: {
                    xList = xReportItem.getCvss_temporal_score();
                    break;
                }
                case 18: {
                    xList = xReportItem.getCvss_temporal_vector();
                    break;
                }
                case 19: {
                    xList = xReportItem.getCvss_vector();
                    break;
                }
                case 20: {
                    xList = xReportItem.getExploit_available();
                    break;
                }
                case 21: {
                    xList = xReportItem.getExploitability_ease();
                    break;
                }
                case 22: {
                    xList = xReportItem.getIn_the_news();
                    break;
                }
                case 23: {
                    xList = xReportItem.getOsvdb();
                    break;
                }
                case 24: {
                    xList = xReportItem.getVuln_publication_date();
                    break;
                }
                case 25: {
                    xList = xReportItem.getXref();
                    break;
                }
                case 26: {
                    xList = xReportItem.getCert();
                    break;
                }
                case 27: {
                    xList = xReportItem.getExploited_by_nessus();
                    break;
                }
                case 28: {
                    xList = xReportItem.getPatch_publication_date();
                    break;
                }
                case 29: {
                    xList = xReportItem.getUnsupported_by_vendor();
                    break;
                }
                case 30: {
                    xList = xReportItem.getEdb_id();
                    break;
                }
                case 31: {
                    xList = xReportItem.getExploit_framework_core();
                    break;
                }
                case 32: {
                    xList = xReportItem.getExploit_framework_metasploit();
                    break;
                }
                case 33: {
                    xList = xReportItem.getMetasploit_name();
                    break;
                }
                case 34: {
                    xList = xReportItem.getCisco_bug_id();
                    break;
                }
                case 35: {
                    xList = xReportItem.getCisco_sa();
                    break;
                }
                case 36: {
                    xList = xReportItem.getIava();
                    break;
                }
                case 37: {
                    xList = xReportItem.getStig_severity();
                    break;
                }
                case 38: {
                    xList = xReportItem.getCert_cc();
                    break;
                }
                default:{
                    xValue = "";
                    break;
                }
            }

            if (xText != null && xText.length() > 0) {
                ReportItem reportItem = new ReportItem();
                reportItem.setName(reportItemName);
                reportItem.setReportHostId(reportHostId);
                reportItem.setText(xText);
                reportItemList.add(reportItem);
            }
            else if (xValue != null && xValue.length() > 0) {
                ReportItem reportItem = new ReportItem();
                reportItem.setName(reportItemName);
                reportItem.setReportHostId(reportHostId);
                reportItem.setValue(xValue);
                reportItemList.add(reportItem);
            }
            else if (xList != null && xList.size() > 0) { 
                for (String xString : xList) {
                    ReportItem reportItem = new ReportItem();
                    reportItem.setName(reportItemName);
                   reportItem.setReportHostId(reportHostId);
                    reportItem.setValue(xString);
                    reportItemList.add(reportItem);
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
        return reportItemList;
    }

    private ReportItemAttribute getReportItemAttribute(Integer reportHostId, XReportItem xReportItem) {
        ReportItemAttribute reportItemAttribute = new ReportItemAttribute();
        
        reportItemAttribute.setPluginId(new Integer(xReportItem.getAttributePluginID()));
        reportItemAttribute.setPluginName(xReportItem.getAttributePluginName());
        reportItemAttribute.setPluginFamily(xReportItem.getAttributePluginFamily());
        reportItemAttribute.setPort(new Integer(xReportItem.getAttributePort()));
        reportItemAttribute.setProtocol(xReportItem.getAttributeProtocol());
        reportItemAttribute.setSeverity(new Integer(xReportItem.getAttributeSeverity()));
        reportItemAttribute.setSvcName(xReportItem.getAttributeSvc_name());
        reportItemAttribute.setReportHostId(reportHostId);

        return reportItemAttribute;
    }

    private HostProperties getHostProperties(Integer reportHostId, XReportHost reportHostXml) {       
        XHostProperties hostPropertiesXml = reportHostXml.getHostProperties();
        List<XTag> tagList = hostPropertiesXml.getTag();

        List<String> reportPropertyNameList = ConstantValues.getReportPropertyNames();
        HostProperties hostProperties = new HostProperties();
        for (XTag tag : tagList) {
            String name = tag.getAttributeName();
            if (name != null) {
                name = name.toLowerCase();
            }
            String value = tag.getValue();
            
            int idx = reportPropertyNameList.indexOf(name);
            switch (idx) {
                case 0: {
                    hostProperties.setLastUnauthenticatedResults(new Integer(value));
                    break;
                }
                case 1: {
                    hostProperties.setCredentialedScan(value);
                    break;
                }   
                case 2: {
                    hostProperties.setPolicyUsed(value);
                    break;
                }  
                case 3: {
                    hostProperties.setPatchSummaryTotalCves(new Integer(value));
                    break;
                } 
                case 4: {
                    hostProperties.setCpe(value);
                    break;
                } 
                case 5: {
                    hostProperties.setOs(value);
                    break;
                } 
                case 6: {
                    hostProperties.setCpe1(value);
                    break;
                } 
                case 7: {
                    hostProperties.setCpe0(value);
                    break;
                } 
                case 8: {
                    hostProperties.setSystemType(value);
                    break;
                } 
                case 9: {
                    hostProperties.setOperatingSystem(value);
                    break;
                } 
                case 10: {
                    hostProperties.setTracerouteHop10(value);
                    break;
                } 
                case 11: {
                    hostProperties.setTracerouteHop9(value);
                    break;
                } 
                case 12: {
                    hostProperties.setTracerouteHop8(value);
                    break;
                } 
                case 13: {
                    hostProperties.setTracerouteHop7(value);
                    break;
                } 
                case 14: {
                    hostProperties.setTracerouteHop6(value);
                    break;
                } 
                case 15: {
                    hostProperties.setTracerouteHop5(value);
                    break;
                } 
                case 16: {
                    hostProperties.setTracerouteHop4(value);
                    break;
                } 
                case 17: {
                    hostProperties.setTracerouteHop3(value);
                    break;
                } 
                case 18: {
                    hostProperties.setTracerouteHop2(value);
                    break;
                } 
                case 19: {
                    hostProperties.setTracerouteHop1(value);
                    break;
                } 
                case 20: {
                    hostProperties.setTracerouteHop0(value);
                    break;
                } 
                case 21: {
                    hostProperties.setHostEnd(value);
                    break;
                } 
                case 22: {
                    hostProperties.setHostIp(value);
                    break;
                } 
                case 23: {
                    hostProperties.setHostStart(value);
                    break;
                } 
                default: {
                    break;
                }
            }
        }
            
        hostProperties.setReportHostId(reportHostId);
        
        return hostProperties;
    }
}
