/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class IndividualPluginSelectionDataModel {
    private final SimpleStringProperty pluginId = new SimpleStringProperty("");
    private final SimpleStringProperty pluginName = new SimpleStringProperty("");
    private final SimpleStringProperty family = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");

    public IndividualPluginSelectionDataModel() {
        this("","","","");
    }
    
    public IndividualPluginSelectionDataModel(String pluginId, String pluginName, String family, String status) {
        setPluginId(pluginId);
        setPluginName(pluginName);
        setFamily(family);
        setStatus(status);
    }
    
    public String getPluginId() {
        return family.get();
    }
 
    public void setPluginId(String pluginId) {
        this.pluginId.set(pluginId);
    }
    
    public String getPluginName() {
        return pluginName.get();
    }
    
    public void setPluginName(String pluginName) {
        this.pluginName.set(pluginName);
    }
    
    public String getFamily() {
        return family.get();
    }
 
    public void setFamily(String family) {
        this.family.set(family);
    }
    
    public String getStatus() {
        return status.get();
    }
    
    public void setStatus(String status) {
        this.status.set(status);
    }
}
