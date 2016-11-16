/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class ServerPreferencesDataModel {

    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty value = new SimpleStringProperty("");

    public ServerPreferencesDataModel() {
        this("", "");
    }
    
    public ServerPreferencesDataModel(String name, String value) {
        setName(name);
        setValue(value);
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
