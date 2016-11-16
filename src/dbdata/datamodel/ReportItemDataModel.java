/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dell
 */
public class ReportItemDataModel {
    private final SimpleStringProperty hostId = new SimpleStringProperty("");
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty value = new SimpleStringProperty("");
    
    public ReportItemDataModel() {
        this("", "","");
    }
    
    public ReportItemDataModel(String hostId, String name, String value) {
        setHostId(hostId);
        setName(name);
        setValue(value);
    }
    
    public String getHostId() {
        return hostId.get();
    }
 
    public void setHostId(String hostId) {
        this.hostId.set(hostId);
    }
    
    public String getName() {
        return name.get();
    }
 
    public void setName(String name) {
        this.name.set(name);
    }
    
    public String getValue() {
        return value.get();
    }
    
    public void setValue(String value) {
        this.value.set(value);
    }
}
