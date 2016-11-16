/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class ReportHostNameDataModel {
    private final SimpleStringProperty reportHostName = new SimpleStringProperty("");
    
    public ReportHostNameDataModel() {
        this("");
    }
    
    public ReportHostNameDataModel(String reportHostName) {
        setReportHostName(reportHostName);      
    }
    
    public String getReportHostName() {
        return reportHostName.get();
    }
 
    public void setReportHostName(String reportHostName) {
        this.reportHostName.set(reportHostName);
    }
    
}
