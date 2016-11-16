/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class PolicyNameDataModel {
    private final SimpleStringProperty policyName = new SimpleStringProperty("");
    
    public PolicyNameDataModel() {
        this("");
    }
    
    public PolicyNameDataModel(String policyName) {
        setPolicyName(policyName);      
    }
    
    public String getPolicyName() {
        return policyName.get();
    }
 
    public void setPolicyName(String policyName) {
        this.policyName.set(policyName);
    }
    
}
