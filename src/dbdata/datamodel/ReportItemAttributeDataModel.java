/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class ReportItemAttributeDataModel {
    private final SimpleStringProperty port = new SimpleStringProperty("");
    private final SimpleStringProperty svcName = new SimpleStringProperty("");
    private final SimpleStringProperty protocol = new SimpleStringProperty("");
    private final SimpleStringProperty severity = new SimpleStringProperty("");
    private final SimpleStringProperty pluginId = new SimpleStringProperty("");
    private final SimpleStringProperty pluginName = new SimpleStringProperty("");
    private final SimpleStringProperty pluginFamily = new SimpleStringProperty("");
    
    public ReportItemAttributeDataModel() {
        this("", "", "", "", "", "", "");
    }
    
    public ReportItemAttributeDataModel(String port, String svcName, String protocol, String severity, String pluginId, String pluginName, String pluginFamily) {
        setPort(port);
        setSvcName(svcName);
        setProtocol(protocol);
        setSeverity(severity);
        setPluginId(pluginId);
        setPluginName(pluginName);
    }
    
    public String getPort() {
        return port.get();
    }
 
    public void setPort(String port) {
        this.port.set(port);
    }
    
    public String getSvcName() {
        return svcName.get();
    }
 
    public void setSvcName(String svcName) {
        this.svcName.set(svcName);
    }
    
    public String getProtocol() {
        return protocol.get();
    }
 
    public void setProtocol(String protocol) {
        this.protocol.set(protocol);
    }
    
    public String getSeverity() {
        return severity.get();
    }
 
    public void setSeverity(String severity) {
        this.severity.set(severity);
    }
    
    public String getPluginId() {
        return pluginId.get();
    }
 
    public void setPluginId(String pluginId) {
        this.pluginId.set(pluginId);
    }
    
    public String getPluginName() {
        return pluginName.get();
    }
 
    public void setPluginName(String pluginNam) {
        this.pluginName.set(pluginNam);
    }
    
    public String getPluginFamily() {
        return pluginFamily.get();
    }
 
    public void setPluginFamily(String pluginFamily) {
        this.pluginFamily.set(pluginFamily);
    }
}
