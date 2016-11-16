/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata;

import entity.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class DataBean {
    private List<Policy> policyList;
    private List<Preference> preferenceList;
    private List<ServerPreference> serverPreferenceList;
    private List<PluginsPreference> pluginsPreferenceList;
    private List<FamilySelection> familySelectionList;
    private List<IndividualPluginSelection> individualPluginSelection;
    private List<Report> reportList;
    private List<ReportHost> reportHostList;
    private Map<Integer, ReportBean> reportData;

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    public List<Preference> getPreferenceList() {
        return preferenceList;
    }

    public void setPreferenceList(List<Preference> preferenceList) {
        this.preferenceList = preferenceList;
    }

    public List<ServerPreference> getServerPreferenceList() {
        return serverPreferenceList;
    }

    public void setServerPreferenceList(List<ServerPreference> serverPreferenceList) {
        this.serverPreferenceList = serverPreferenceList;
    }

    public List<PluginsPreference> getPluginsPreferenceList() {
        return pluginsPreferenceList;
    }

    public void setPluginsPreferenceList(List<PluginsPreference> pluginsPreferenceList) {
        this.pluginsPreferenceList = pluginsPreferenceList;
    }

    public List<FamilySelection> getFamilySelectionList() {
        return familySelectionList;
    }

    public void setFamilySelectionList(List<FamilySelection> familySelectionList) {
        this.familySelectionList = familySelectionList;
    }

    public List<IndividualPluginSelection> getIndividualPluginSelection() {
        return individualPluginSelection;
    }

    public void setIndividualPluginSelection(List<IndividualPluginSelection> individualPluginSelection) {
        this.individualPluginSelection = individualPluginSelection;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public List<ReportHost> getReportHostList() {
        return reportHostList;
    }

    public void setReportHostList(List<ReportHost> reportHostList) {
        this.reportHostList = reportHostList;
    }

    public Map<Integer, ReportBean> getReportData() {
        return reportData;
    }

    public void setReportData(Map<Integer, ReportBean> reportData) {
        this.reportData = reportData;
    }

}
