/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class PluginsPreferenceDataModel {
     private final SimpleStringProperty pluginName = new SimpleStringProperty("");
     private final SimpleStringProperty pluginId = new SimpleStringProperty("");
     private final SimpleStringProperty fullName = new SimpleStringProperty("");
     private final SimpleStringProperty preferenceName = new SimpleStringProperty("");
     private final SimpleStringProperty preferenceType = new SimpleStringProperty("");
     private final SimpleStringProperty preferenceValues = new SimpleStringProperty("");
     private final SimpleStringProperty selectedValue = new SimpleStringProperty("");

    public PluginsPreferenceDataModel() {
        this("","","","","","","");
    }
     
    public PluginsPreferenceDataModel(String pluginName, String pluginId, String fullName, String preferenceName, String preferenceType, String PreferenceValues, String SelectedValue) {
        setPluginName(pluginName);
        setPluginId(pluginId);
        setFullName(fullName);
        setPreferenceName(preferenceName);
        setPreferenceType(preferenceType);
        setPreferenceValues(PreferenceValues);
        setSelectedValue(SelectedValue);
    }
    
    public String getPluginName() {
        return pluginName.get();
    }

    public void setPluginName(String pluginName) {
        this.pluginName.set(pluginName);
    }
    
    public String getPluginId() {
        return pluginId.get();
    }

    public void setPluginId(String pluginId) {
        this.pluginId.set(pluginId);
    }
    
    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }
    
    public String getPreferenceName() {
        return preferenceName.get();
    }

    public void setPreferenceName(String preferenceName) {
        this.preferenceName.set(preferenceName);
    }
    
    public String getPreferenceType() {
        return preferenceType.get();
    }

    public void setPreferenceType(String preferenceType) {
        this.preferenceType.set(preferenceType);
    }
    
    public String getPreferenceValues() {
        return preferenceValues.get();
    }

    public void setPreferenceValues(String PreferenceValues) {
        this.preferenceValues.set(PreferenceValues);
    }
    
    public String getSelectedValue() {
        return selectedValue.get();
    }
     
    public void setSelectedValue(String SelectedValue) {
        this.selectedValue.set(SelectedValue);
    }
    
}
