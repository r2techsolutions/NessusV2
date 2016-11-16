/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class ReportNameDataModel {
    private final SimpleStringProperty reportName = new SimpleStringProperty("");
    private final SimpleStringProperty xmlnsCm = new SimpleStringProperty("");
    
    public ReportNameDataModel() {
        this("","");
    }
    
    public ReportNameDataModel(String reportName, String xmlnsCm) {
        setReportName(reportName);   
        setReportName(xmlnsCm);   
    }
    
    public String getReportName() {
        return reportName.get();
    }
 
    public void setReportName(String reportName) {
        this.reportName.set(reportName);
    }
    
    public String getXmlnsCm() {
        return xmlnsCm.get();
    }
 
    public void setXmlnsCm(String xmlnsCm) {
        this.xmlnsCm.set(xmlnsCm);
    }
}
