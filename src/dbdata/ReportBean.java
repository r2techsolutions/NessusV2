/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata;

import entity.HostProperties;
import entity.ReportItem;
import entity.ReportItemAttribute;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ReportBean {
    private HostProperties hostProperties;
    private List<ReportItemAttribute> reportItemAttributeList;
    private List<ReportItem> reportItemList;

    public HostProperties getHostProperties() {
        return hostProperties;
    }

    public void setHostProperties(HostProperties hostProperties) {
        this.hostProperties = hostProperties;
    }

    public List<ReportItemAttribute> getReportItemAttribute() {
        return reportItemAttributeList;
    }

    public void setReportItemAttribute(List<ReportItemAttribute> reportItemAttribute) {
        this.reportItemAttributeList = reportItemAttribute;
    }

    public List<ReportItem> getReportItemList() {
        return reportItemList;
    }

    public void setReportItemList(List<ReportItem> reportItemList) {
        this.reportItemList = reportItemList;
    }
    
    
}
