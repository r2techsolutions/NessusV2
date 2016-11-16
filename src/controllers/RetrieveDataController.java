/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import admin.UserSingleton;
import dbdata.DataBean;
import dbdata.ReportBean;
import dbdata.Retriever;
import dbdata.datamodel.FamilySelectionDataModel;
import dbdata.datamodel.HostPropertyDataModel;
import dbdata.datamodel.IndividualPluginSelectionDataModel;
import dbdata.datamodel.PluginsPreferenceDataModel;
import dbdata.datamodel.PolicyNameDataModel;
import dbdata.datamodel.ReportHostNameDataModel;
import dbdata.datamodel.ReportItemAttributeDataModel;
import dbdata.datamodel.ReportItemDataModel;
import dbdata.datamodel.ReportNameDataModel;
import dbdata.datamodel.ServerPreferencesDataModel;
import entity.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.ConstantValues;
import util.TreeViewHelper;

public class RetrieveDataController implements Initializable {
    @FXML
    private Button exitButton;
    @FXML
    private Label userNameLabel;
    @FXML
    private ComboBox loadCycleComboBox;
    @FXML
    private TreeView nessusTreeView;
    
    private DataBean dataBean;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeForm();
    }    
    
    @FXML
    private void loadCycleAction(ActionEvent event) {
        String loadCycle = loadCycleComboBox.getSelectionModel().getSelectedItem().toString();
        String loadCycleId = loadCycle.substring(0, loadCycle.indexOf("."));
        Retriever retriever = new Retriever();
        try {
            dataBean = retriever.getAllData(new Integer(loadCycleId));           
            loadNessusTreeStructure();

        } catch (Exception ex) {
            Logger.getLogger(RetrieveDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    private void initializeForm() {
        UserSingleton userSingleton = UserSingleton.getUserSingleton();
        Users user = userSingleton.getUser();
        userNameLabel.setText(user.getFirstName() + " " + user.getLastName() + " " + user.getRole());    
        
        Retriever retriever = new Retriever();
        try {
            List<LoadCycle> loadCycleList = retriever.getLoadCycle();
            for (LoadCycle loadCycle : loadCycleList) {
                loadCycleComboBox.getItems().add(loadCycle.getLoadCycleId()+ ". " + loadCycle.getOrgId() + " " + loadCycle.getLoadTime());                
            }
        } catch (Exception ex) {
            Logger.getLogger(LoadDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setDispayControlsVisible(false);
    }

    public void loadTreeItems(String... rootItems) {
        TreeItem<String> root = new TreeItem<String>("Nessus Client Data v2");
        root.setExpanded(true);
        for (String itemString: rootItems) {
          root.getChildren().add(new TreeItem<String>(itemString));
        }

        nessusTreeView.setRoot(root);
    }
    
    public void loadNessusTreeStructure() throws Exception {
        TreeViewHelper treeViewHelper = new TreeViewHelper();
        String parentName = "";
        List<String> childrenNameList = treeViewHelper.getChildren(parentName);
        TreeItem<String> root =  new TreeItem<String>(childrenNameList.get(0)); 
        
        Retriever retriever = new Retriever();
        int reportHostCount = retriever.getReportHostCount();
        treeViewHelper.setReportHostCount(reportHostCount);
        
        parentName = "root";
        treeViewHelper.addTreeViewItem(root, parentName);
        
        nessusTreeView.getSelectionModel().selectedItemProperty().addListener((value, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    String treeItemValue = (((TreeItem)newValue).getValue()).toString();
                    int number = 0;
                    int pos = treeItemValue.indexOf(":");
                    if (pos >  0) {
                            try {
                            number = Integer.parseInt(treeItemValue.substring(0, pos));
                        }
                        catch (Exception ex) {};
                    
                        treeItemValue = treeItemValue.substring(pos + 1).trim();
                    }
                    int idx = retriever.getNessusStructureIndex(treeItemValue);
                    switch (idx) {
                        case 3: {
                            displayPolicyNameTableView();
                            break;
                        }
                        case 6: {
                            displayServerPreferencesTableView();
                            break;
                        }
                        case 8: {
                            displayPluginsPreferencesTableView();
                            break;
                        }
                        case 10: {
                            displayFamilySelectionTableView();
                            break;
                        }  
                        case 12: {
                            displayIndividualPluginSelectionTableView();
                            break;
                        }
                        case 13: {
                            displayReportNameTableView();
                            break;
                        }
                        case 14: {
                            displayReportHostTableView(number);
                            break;
                        }
                        case 15: {
                            displayHostPropertyTableView(number);
                            break;
                        }
                        case 16: {
                            displayReportItemAttributeTableView(number);
                            break;
                        }
                        case 17: {
                            displayReportItemTableView(number);
                            break;
                        }
                    }
                }
                catch (Exception ex) {
                    Logger.getLogger(LoadDataController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }          
        });
        
        root.setExpanded(true);
        nessusTreeView.setRoot(root);
    }

    @FXML
    private TableView policyNameTableView;
    @FXML
    TableColumn policyNameCol;
    private void displayPolicyNameTableView() {
        policyNameCol.setCellValueFactory(new PropertyValueFactory<PolicyNameDataModel, String>("policyName"));
        ObservableList<PolicyNameDataModel> data = FXCollections.observableArrayList();
        policyNameTableView.setItems(data);
        
        Policy policy = dataBean.getPolicyList().get(0);
        PolicyNameDataModel policyNameDataModel = new PolicyNameDataModel();
        policyNameDataModel.setPolicyName(policy.getPolicyName());
        data.add(policyNameDataModel);
        
        setDispayControlsVisible(false);
        policyNameTableView.visibleProperty().set(true);
    }
    
    @FXML
    private TableView serverPreferencesTableView;
    @FXML
    TableColumn nameCol;
    @FXML
    TableColumn valueCol;
    private void displayServerPreferencesTableView() throws Exception {   
        nameCol.setCellValueFactory(new PropertyValueFactory<ServerPreferencesDataModel, String>("name"));
        valueCol.setCellValueFactory(new PropertyValueFactory<ServerPreferencesDataModel, String>("value"));
        ObservableList<ServerPreferencesDataModel> data = FXCollections.observableArrayList();
        serverPreferencesTableView.setItems(data);

        List<ServerPreference> serverPreferenceList = dataBean.getServerPreferenceList();
        for (ServerPreference serverPreference : serverPreferenceList) {
            ServerPreferencesDataModel serverPreferencesDataModel = new ServerPreferencesDataModel();
            serverPreferencesDataModel.setName(serverPreference.getName());
            serverPreferencesDataModel.setValue(serverPreference.getValue());
            data.add(serverPreferencesDataModel);
        }   
        
        setDispayControlsVisible(false);
        serverPreferencesTableView.visibleProperty().set(true);
    }

    @FXML
    private TableView familySelectionTableView;
    @FXML
    TableColumn familyNameCol;
    @FXML
    TableColumn statusCol;
    private void displayFamilySelectionTableView() throws Exception {   
        familyNameCol.setCellValueFactory(new PropertyValueFactory<FamilySelectionDataModel, String>("familyName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<FamilySelectionDataModel, String>("status"));
        ObservableList<FamilySelectionDataModel> data = FXCollections.observableArrayList();
        familySelectionTableView.setItems(data);

        List<FamilySelection> familySelectionList = dataBean.getFamilySelectionList();
        for (FamilySelection familySelection : familySelectionList) {
            FamilySelectionDataModel familySelectionDataModel = new FamilySelectionDataModel();
            familySelectionDataModel.setFamilyName(familySelection.getFamilyName());
            familySelectionDataModel.setStatus(familySelection.getStatus());
            data.add(familySelectionDataModel);
        }   
        
        setDispayControlsVisible(false);
        familySelectionTableView.visibleProperty().set(true);
    }
    
    @FXML
    TableView pluginsPreferencesTableView;
    @FXML
    TableColumn pluginNameCol;
    @FXML
    TableColumn pluginIdCol;
    @FXML
    TableColumn fullNameCol;
    @FXML
    TableColumn preferenceNameCol;
    @FXML
    TableColumn preferenceTypeCol;
    @FXML
    TableColumn PreferenceValuesCol;
    @FXML
    TableColumn SelectedValueCol;
    private void displayPluginsPreferencesTableView() {
        pluginNameCol.setCellValueFactory(new PropertyValueFactory<PluginsPreferenceDataModel, String>("pluginName"));
        pluginIdCol.setCellValueFactory(new PropertyValueFactory<PluginsPreferenceDataModel, String>("pluginId"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<PluginsPreferenceDataModel, String>("fullName"));
        preferenceNameCol.setCellValueFactory(new PropertyValueFactory<PluginsPreferenceDataModel, String>("preferenceName"));
        preferenceTypeCol.setCellValueFactory(new PropertyValueFactory<PluginsPreferenceDataModel, String>("preferenceType"));
        PreferenceValuesCol.setCellValueFactory(new PropertyValueFactory<PluginsPreferenceDataModel, String>("PreferenceValues"));
        SelectedValueCol.setCellValueFactory(new PropertyValueFactory<PluginsPreferenceDataModel, String>("SelectedValue"));
        ObservableList<PluginsPreferenceDataModel> data = FXCollections.observableArrayList();
        pluginsPreferencesTableView.setItems(data);

        List<PluginsPreference> pluginsPreferenceList = dataBean.getPluginsPreferenceList();
        for (PluginsPreference pluginsPreference : pluginsPreferenceList) {
            PluginsPreferenceDataModel pluginsPreferenceDataModel = new PluginsPreferenceDataModel();
            pluginsPreferenceDataModel.setPluginName(pluginsPreference.getPluginName());
            pluginsPreferenceDataModel.setPluginId(pluginsPreference.getPluginId());
            pluginsPreferenceDataModel.setFullName(pluginsPreference.getFullName());
            pluginsPreferenceDataModel.setPreferenceName(pluginsPreference.getPreferenceName());
            pluginsPreferenceDataModel.setPreferenceType(pluginsPreference.getPreferenceType());
            pluginsPreferenceDataModel.setSelectedValue(pluginsPreference.getPreferenceValue());
            pluginsPreferenceDataModel.setPreferenceValues(pluginsPreference.getPreferenceId().toString());
            data.add(pluginsPreferenceDataModel);
        }   
        
        setDispayControlsVisible(false);
        pluginsPreferencesTableView.visibleProperty().set(true);
    }

    @FXML
    private TableView individualPluginSelectionTableView;
    @FXML
    TableColumn indvPluginIdCol;
    @FXML
    TableColumn indvPluginNameCol;
    @FXML
    TableColumn indvFamilyCol;
    @FXML
    TableColumn indvStatusCol;
    private void displayIndividualPluginSelectionTableView() throws Exception {   
        indvPluginIdCol.setCellValueFactory(new PropertyValueFactory<IndividualPluginSelectionDataModel, String>("pluginId"));
        indvPluginNameCol.setCellValueFactory(new PropertyValueFactory<IndividualPluginSelectionDataModel, String>("pluginName"));
        indvFamilyCol.setCellValueFactory(new PropertyValueFactory<IndividualPluginSelectionDataModel, String>("family"));
        indvStatusCol.setCellValueFactory(new PropertyValueFactory<IndividualPluginSelectionDataModel, String>("status"));
        ObservableList<IndividualPluginSelectionDataModel> data = FXCollections.observableArrayList();
        individualPluginSelectionTableView.setItems(data);

        List<IndividualPluginSelection> individualPluginSelectionList = dataBean.getIndividualPluginSelection();
        for (IndividualPluginSelection individualPluginSelection : individualPluginSelectionList) {
            IndividualPluginSelectionDataModel individualPluginSelectionDataModel = new IndividualPluginSelectionDataModel();
            individualPluginSelectionDataModel.setPluginId(String.valueOf(individualPluginSelection.getPluginId()));
            individualPluginSelectionDataModel.setPluginName(individualPluginSelection.getPluginName());
            individualPluginSelectionDataModel.setFamily(individualPluginSelection.getFamily());
            individualPluginSelectionDataModel.setStatus(individualPluginSelection.getStatus());
            data.add(individualPluginSelectionDataModel);
        }   
        
        setDispayControlsVisible(false);
        individualPluginSelectionTableView.visibleProperty().set(true);
    }
  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    private TableView reportNameTableView;
    @FXML
    TableColumn reportNameCol;
    @FXML
    TableColumn xmlnsCmCol;
    private void displayReportNameTableView() {
        reportNameCol.setCellValueFactory(new PropertyValueFactory<ReportNameDataModel, String>("reportName"));
        xmlnsCmCol.setCellValueFactory(new PropertyValueFactory<ReportNameDataModel, String>("xmlnsCm"));
        ObservableList<ReportNameDataModel> data = FXCollections.observableArrayList();
        reportNameTableView.setItems(data);
        
        Report report = dataBean.getReportList().get(0);
        ReportNameDataModel reportNameDataModel = new ReportNameDataModel();
        reportNameDataModel.setReportName(report.getReportName());
        reportNameDataModel.setXmlnsCm(report.getXmlnsCm());
        data.add(reportNameDataModel);
        
        setDispayControlsVisible(false);
        reportNameTableView.visibleProperty().set(true);
    }
    
    @FXML
    private TableView reportHostNameTableView;
    @FXML
    TableColumn rptHostNameCol;
    private void displayReportHostTableView(int number) {
        rptHostNameCol.setCellValueFactory(new PropertyValueFactory<ReportHostNameDataModel, String>("reportHostName"));
        ObservableList<ReportHostNameDataModel> data = FXCollections.observableArrayList();
        reportHostNameTableView.setItems(data);
        
        Integer reportHostId = getReportHostId(number);
        List<ReportHost> reportHostList = dataBean.getReportHostList();
        for (ReportHost reportHost : reportHostList) {
            if (reportHostId == reportHost.getReportHostId()) {
                ReportHostNameDataModel reportHostNameDataModel = new ReportHostNameDataModel();
                reportHostNameDataModel.setReportHostName(reportHost.getReportHostName());
                data.add(reportHostNameDataModel);
            }
        }
        
        setDispayControlsVisible(false);
        reportHostNameTableView.visibleProperty().set(true);
    }
    
    @FXML
    private TableView reportItemTableView;
    @FXML
    TableColumn rptHostIdCol;
    @FXML
    TableColumn rptItemNameCol;
    @FXML
    TableColumn rptItemValueCol;
    private void displayReportItemTableView(int number) throws Exception {   
        rptHostIdCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("hostId"));
        rptItemNameCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("name"));
        rptItemValueCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("value"));
        ObservableList<ReportItemDataModel> data = FXCollections.observableArrayList();
        reportItemTableView.setItems(data);

        Integer reportHostId = getReportHostId(number);
        Map<Integer, ReportBean> reportDataMap = dataBean.getReportData();
        ReportBean reportBean = reportDataMap.get(reportHostId);
        List<ReportItem> reportItemList = reportBean.getReportItemList();
        for (ReportItem reportItem : reportItemList) {
            if (reportHostId == reportItem.getReportHostId()) {
                ReportItemDataModel reportItemDataModel = new ReportItemDataModel();
                reportItemDataModel.setHostId(reportItem.getReportHostId().toString());
                reportItemDataModel.setName(reportItem.getName());
                reportItemDataModel.setValue(reportItem.getValue());
                data.add(reportItemDataModel);
            }
        }   
        
        setDispayControlsVisible(false);
        reportItemTableView.visibleProperty().set(true);
    }

    @FXML
    private TableView reportItemAttributeTableView;
    @FXML
    TableColumn rptAttrPortCol;
    @FXML
    TableColumn rptAttrSvcNameCol;
    @FXML
    TableColumn rptAttrProtocolCol;
    @FXML
    TableColumn rptAttrSeverityCol;
    @FXML
    TableColumn rptAttrPluginIdCol;
    @FXML
    TableColumn rptAttrPluginNameCol;
    private void displayReportItemAttributeTableView(int number) throws Exception {   
        rptAttrPortCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("port"));
        rptAttrSvcNameCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("svcName"));
        rptAttrProtocolCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("protocol"));
        rptAttrSeverityCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("severity"));
        rptAttrPluginIdCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("pluginId"));
        rptAttrPluginNameCol.setCellValueFactory(new PropertyValueFactory<ReportItemDataModel, String>("pluginNam"));
        ObservableList<ReportItemAttributeDataModel> data = FXCollections.observableArrayList();
        reportItemAttributeTableView.setItems(data);

        Integer reportHostId = getReportHostId(number);
        Map<Integer, ReportBean> reportDataMap = dataBean.getReportData();
        ReportBean reportBean = reportDataMap.get(reportHostId);
        List<ReportItemAttribute> reportItemAttributeList = reportBean.getReportItemAttribute();
        for (ReportItemAttribute reportItemAttribute : reportItemAttributeList) {
            ReportItemAttributeDataModel reportItemAttributeDataModel = new ReportItemAttributeDataModel();
            reportItemAttributeDataModel.setPort(reportItemAttribute.getPort().toString());
            reportItemAttributeDataModel.setSvcName(reportItemAttribute.getSvcName());
            reportItemAttributeDataModel.setSeverity(reportItemAttribute.getSeverity().toString());
            reportItemAttributeDataModel.setProtocol(reportItemAttribute.getProtocol());
            reportItemAttributeDataModel.setPluginId(reportItemAttribute.getPluginId().toString());
            reportItemAttributeDataModel.setPluginFamily(reportItemAttribute.getPluginFamily());
            data.add(reportItemAttributeDataModel);
        }
        
        setDispayControlsVisible(false);
        reportItemAttributeTableView.visibleProperty().set(true);
    }
    
    @FXML
    private TableView hostPropertyTableView;
    @FXML
    TableColumn propHostIdCol;
    @FXML
    TableColumn propLastUnauthenticatedResultsCol;
    @FXML
    TableColumn propCredentialedScanCol;
    @FXML
    TableColumn propPolicyUsedCol;
    @FXML
    TableColumn propPatchSummaryTotalCvesCol;
    @FXML
    TableColumn propOsCol;
    @FXML
    TableColumn propCpeCol;
    @FXML
    TableColumn propCpe1Col;
    @FXML
    TableColumn propCpe0Col;
    @FXML
    TableColumn propSystemTypeCol;
    @FXML
    TableColumn propOperatingSystemCol;
    @FXML
    TableColumn propTracerouteHop10Col;
    @FXML
    TableColumn propTracerouteHop9Col;
    @FXML
    TableColumn propTracerouteHop8Col;
    @FXML
    TableColumn propTracerouteHop7Col;
    @FXML
    TableColumn propTracerouteHop6Col;
    @FXML
    TableColumn propTracerouteHop5Col;
    @FXML
    TableColumn propTracerouteHop4Col;
    @FXML
    TableColumn propTracerouteHop3Col;
    @FXML
    TableColumn propTracerouteHop2Col;
    @FXML
    TableColumn propTracerouteHop1Col;
    @FXML
    TableColumn propTracerouteHop0Col;
    @FXML
    TableColumn propHostEndCol;
    @FXML
    TableColumn propHostIpCol;
    @FXML
    TableColumn propHostStartCol;
    private void displayHostPropertyTableView(int number) {
        propHostIdCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("reportHostId"));
        propLastUnauthenticatedResultsCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("lastUnauthenticatedResults"));
        propCredentialedScanCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("credentialedScan"));
        propPolicyUsedCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("policyUsed"));
        propPatchSummaryTotalCvesCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("patchSummaryTotalCves"));
        propOsCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("os"));
        propCpeCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("cpe"));
        propCpe1Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("cpe1"));
        propCpe0Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("cpe0"));
        propSystemTypeCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("systemType"));
        propOperatingSystemCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tperatingSystem"));
        propTracerouteHop10Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop10"));
        propTracerouteHop9Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop9"));
        propTracerouteHop8Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop8"));
        propTracerouteHop7Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop7"));
        propTracerouteHop6Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop6"));
        propTracerouteHop5Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop5"));
        propTracerouteHop4Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop4"));
        propTracerouteHop3Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop3"));
        propTracerouteHop2Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop2"));
        propTracerouteHop1Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop1"));
        propTracerouteHop0Col.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("tracerouteHop0"));
        propHostEndCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("hostEnd"));
        propHostIpCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("hostIp"));
        propHostStartCol.setCellValueFactory(new PropertyValueFactory<HostPropertyDataModel, String>("hostStart"));
        ObservableList<HostPropertyDataModel> data = FXCollections.observableArrayList();
        hostPropertyTableView.setItems(data);

        Integer reportHostId = getReportHostId(number);
        Map<Integer, ReportBean> reportDataMap = dataBean.getReportData();
        ReportBean reportBean = reportDataMap.get(reportHostId);
        HostProperties hostProperties = reportBean.getHostProperties();
        HostPropertyDataModel hostPropertyDataModel = new HostPropertyDataModel();
        hostPropertyDataModel.setReportHostId(hostProperties.getReportHostId().toString());
        hostPropertyDataModel.setLastUnauthenticatedResults(hostProperties.getLastUnauthenticatedResults().toString());
        hostPropertyDataModel.setCredentialedScan(hostProperties.getCredentialedScan());
        hostPropertyDataModel.setPolicyUsed(hostProperties.getPolicyUsed());
        hostPropertyDataModel.setPatchSummaryTotalCves(hostProperties.getPatchSummaryTotalCves().toString());
        hostPropertyDataModel.setCpe(hostProperties.getCpe());
        hostPropertyDataModel.setOs(hostProperties.getOs());
        hostPropertyDataModel.setCpe1(hostProperties.getCpe1());
        hostPropertyDataModel.setCpe0(hostProperties.getCpe0());
        hostPropertyDataModel.setSystemType(hostProperties.getSystemType());
        hostPropertyDataModel.setOperatingSystem(hostProperties.getOperatingSystem());
        hostPropertyDataModel.setTracerouteHop10(hostProperties.getTracerouteHop10());
        hostPropertyDataModel.setTracerouteHop9(hostProperties.getTracerouteHop9());
        hostPropertyDataModel.setTracerouteHop8(hostProperties.getTracerouteHop8());
        hostPropertyDataModel.setTracerouteHop7(hostProperties.getTracerouteHop7());
        hostPropertyDataModel.setTracerouteHop6(hostProperties.getTracerouteHop6());
        hostPropertyDataModel.setTracerouteHop5(hostProperties.getTracerouteHop5());
        hostPropertyDataModel.setTracerouteHop4(hostProperties.getTracerouteHop4());
        hostPropertyDataModel.setTracerouteHop3(hostProperties.getTracerouteHop3());
        hostPropertyDataModel.setTracerouteHop2(hostProperties.getTracerouteHop2());
        hostPropertyDataModel.setTracerouteHop1(hostProperties.getTracerouteHop1());
        hostPropertyDataModel.setTracerouteHop0(hostProperties.getTracerouteHop0());
        hostPropertyDataModel.setHostEnd(hostProperties.getHostEnd());
        hostPropertyDataModel.setHostIp(hostProperties.getHostIp());
        hostPropertyDataModel.setHostStart(hostProperties.getHostStart());

        data.add(hostPropertyDataModel);

        setDispayControlsVisible(false);
        hostPropertyTableView.visibleProperty().set(true);
    }
    
    private void setDispayControlsVisible(boolean b) {
        policyNameTableView.visibleProperty().set(b);
        serverPreferencesTableView.visibleProperty().set(b);
        pluginsPreferencesTableView.visibleProperty().set(b);
        familySelectionTableView.visibleProperty().set(b);
        individualPluginSelectionTableView.visibleProperty().set(b);
        
        reportNameTableView.visibleProperty().set(b);
        reportHostNameTableView.visibleProperty().set(b);
        reportItemTableView.visibleProperty().set(b);
        hostPropertyTableView.visibleProperty().set(b);
        reportItemAttributeTableView.visibleProperty().set(b);
    }

    private Integer getReportHostId(int number) {
        ReportHost reportHost = dataBean.getReportHostList().get(number - 1);
        Integer reportHostId = reportHost.getReportHostId();
      
        return reportHostId;
    }
}
