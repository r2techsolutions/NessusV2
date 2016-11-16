/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata;

import entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateFactory;

public class Retriever {
    Session session;
    Transaction tx;
    Query query;
    List resultList;
    String hql;
            
    public Users getUser(String userId, String password) throws Exception {
        Users user = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getUser(userId, password);
            query = session.createQuery(hql);
            resultList = query.list();
            if (resultList.size() != 0) {
                user = (Users)resultList.get(0);

                session.flush();
                tx.commit();
            }           
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
        
        return user;
    }
    
    public List<Organization> getOrg() throws Exception {
        List<Organization> orgList = new ArrayList<Organization>();
        
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getOrganizations;
            query = session.createQuery(hql);
            resultList = query.list();
            for (Object obj : resultList) {
                Organization org = (Organization)obj;
                orgList.add(org);
            }
            session.flush();
            tx.commit();
             
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
        
        return orgList;
    }

    public List<LoadCycle> getLoadCycle() throws Exception {
        List<LoadCycle> loadCycleList = new ArrayList<LoadCycle>();
        
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getLoadCycle;
            query = session.createQuery(hql);
            resultList = query.list();
            for (Object obj : resultList) {
                LoadCycle loadCycle = (LoadCycle)obj;
                loadCycleList.add(loadCycle);
            }
            session.flush();
            tx.commit();
             
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
        
        return loadCycleList;
    }
    
    public Organization getOrg(String orgName) throws Exception {
        Organization org = null;
        
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getOrganizatoin(orgName);
            query = session.createQuery(hql);
            resultList = query.list();
            org = (Organization)resultList.get(0);
            session.flush();
            tx.commit();
             
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
        
        return org;
    }
    
    public DataBean getAllData(Integer loadCycleId) throws Exception {
        DataBean dataBean = new DataBean();
            
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getPolicy(loadCycleId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<Policy> policyList = new ArrayList();
            for (Object obj : resultList) {
                Policy policy = (Policy)obj;
                policyList.add(policy);
            }
            Policy policy = (Policy)resultList.get(0);           
            Integer policyId = policy.getPolicyId();
            
            hql = Hql.getPreference(policyId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<Preference> preferenceList = new ArrayList();
            for (Object obj : resultList) {
                Preference preference = (Preference)obj;
                preferenceList.add(preference);
            }
            Preference preference = (Preference)resultList.get(0);           
            Integer preferenceId = preference.getPreferenceId();
            
            hql = Hql.getServerPreference(preferenceId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<ServerPreference> serverPreferenceList = new ArrayList();
            for (Object obj : resultList) {
                ServerPreference serverPreference = (ServerPreference)obj;
                serverPreferenceList.add(serverPreference);
            }
            ServerPreference serverPreference = (ServerPreference)resultList.get(0);           
            Integer serverPreferenceId = serverPreference.getServerPreferenceId();
            
            hql = Hql.getPluginsPreference(preferenceId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<PluginsPreference> pluginsPreferenceList = new ArrayList();
            for (Object obj : resultList) {
                PluginsPreference pluginsPreference = (PluginsPreference)obj;
                pluginsPreferenceList.add(pluginsPreference);
            }
            PluginsPreference pluginsPreference = (PluginsPreference)resultList.get(0);           
            Integer pluginsPreferenceId = pluginsPreference.getPluginsPreferenceId();
            
            hql = Hql.getFamilySelection(policyId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<FamilySelection> familySelectionList = new ArrayList();
            for (Object obj : resultList) {
                FamilySelection familySelection = (FamilySelection)obj;
                familySelectionList.add(familySelection);
            }
            FamilySelection familySelection = (FamilySelection)resultList.get(0);           
            Integer familySelectionId = familySelection.getFamilySelectionId();
            
            hql = Hql.getIndividualPluginSelection(policyId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<IndividualPluginSelection> individualPluginSelectionList = new ArrayList();
            for (Object obj : resultList) {
                IndividualPluginSelection individualPluginSelection = (IndividualPluginSelection)obj;
                individualPluginSelectionList.add(individualPluginSelection);
            }
            IndividualPluginSelection individualPluginSelection = (IndividualPluginSelection)resultList.get(0);           
            Integer individualPluginSelectionId = individualPluginSelection.getPluginId();
            
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            hql = Hql.getReport(loadCycleId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<Report> reportList = new ArrayList();
            for (Object obj : resultList) {
                Report report = (Report)obj;
                reportList.add(report);
            }
            Report report = (Report)resultList.get(0);           
            Integer reportId = report.getReportId();
            
            hql = Hql.getReportHost(reportId);
            query = session.createQuery(hql);
            resultList = query.list();
            List<Integer> reportHostIdList = new ArrayList();
            List<ReportHost> reportHostList = new ArrayList();
            for (Object obj : resultList) {
                ReportHost reportHost = (ReportHost)obj;
                reportHostList.add(reportHost);
                reportHostIdList.add(reportHost.getReportHostId());
            }
            
            Map<Integer, ReportBean> reportData = new HashMap();
            List<HostProperties> hostPropertiesList = new ArrayList();
                        
            for (Integer reportHostId : reportHostIdList) {
                ReportBean reportBean = new ReportBean();
                hql = Hql.getHostProperties(reportHostId);
                query = session.createQuery(hql);
                resultList = query.list();
                if (resultList != null && resultList.size() > 0) {
                    HostProperties hostProperties = (HostProperties)resultList.get(0);
                    reportBean.setHostProperties(hostProperties);
                }
                
                hql = Hql.getReportItemAttribute(reportHostId);
                query = session.createQuery(hql);
                resultList = query.list();
                List<ReportItemAttribute> reportItemAttributeList = new ArrayList();
                for (Object obj : resultList) {
                    ReportItemAttribute reportItemAttribute = (ReportItemAttribute)obj;
                    reportItemAttributeList.add(reportItemAttribute);
                }
                reportBean.setReportItemAttribute(reportItemAttributeList);
                
                hql = Hql.getReportItem(reportHostId);
                query = session.createQuery(hql);
                resultList = query.list();
                List<ReportItem> reportItemList = new ArrayList();
                for (Object obj : resultList) {
                    ReportItem reportItem = (ReportItem)obj;
                    reportItemList.add(reportItem);                   
                }
                reportBean.setReportItemList(reportItemList);
                
                reportData.put(reportHostId, reportBean);
            }
            
            dataBean.setPolicyList(policyList);
            dataBean.setPreferenceList(preferenceList);
            dataBean.setFamilySelectionList(familySelectionList);
            dataBean.setIndividualPluginSelection(individualPluginSelectionList);
            dataBean.setPluginsPreferenceList(pluginsPreferenceList);
            dataBean.setServerPreferenceList(serverPreferenceList);
            dataBean.setReportList(reportList);
            dataBean.setReportHostList(reportHostList);
            dataBean.setReportData(reportData);
             
            session.flush();            
            tx.commit();
             
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
        
        return dataBean;
    }

    public List<NessusStructure> getNessusStructureChildren(String parentName) {
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getNessusStructure(parentName);
            query = session.createQuery(hql);
            resultList = query.list();
            
            session.flush();
            tx.commit();
            
        } catch (Exception ex) {
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
        
        return resultList;
    }

    public int getNessusStructureIndex(String newValue) {
        int id = 0;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getNessusStructureId(newValue);
            query = session.createQuery(hql);
            resultList = query.list();
            if (resultList != null && resultList.size() > 0) {
                NessusStructure nessusStructure = (NessusStructure)resultList.get(0);
                id = nessusStructure.getId();
            }
            session.flush();
            tx.commit();
            
        } catch (Exception ex) {
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
        return id;
    }

    public int getReportHostCount() {
        int count = 0;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
             
            hql = Hql.getReportHost;
            query = session.createQuery(hql);
            resultList = query.list();
            count = resultList.size();
            session.flush();
            tx.commit();
            
        } catch (Exception ex) {
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
        return count;
    }
}
