/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class FamilySelectionDataModel {

    private final SimpleStringProperty familyName = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");

    public FamilySelectionDataModel() {
        this("", "");
    }
    
    public FamilySelectionDataModel(String familyName, String status) {
        setFamilyName(familyName);
        setStatus(status);
    }
    
    public String getFamilyName() {
        return familyName.get();
    }
 
    public void setFamilyName(String familyName) {
        this.familyName.set(familyName);
    }
    
    public String getStatus() {
        return status.get();
    }
    
    public void setStatus(String status) {
        this.status.set(status);
    }
}
