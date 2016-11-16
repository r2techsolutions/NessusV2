/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

public class XReport {
    private String attributeName;  
    private String attributeXmlns_cm;
    
    @XStreamImplicit(itemFieldName = "ReportHost")
    private List<XReportHost> reportHost = new ArrayList<>();

    public List<XReportHost> getReportHost() {
        return reportHost;
    }

    public void setReportHost(List<XReportHost> reportHost) {
        this.reportHost = reportHost;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeXmlns_cm() {
        return attributeXmlns_cm;
    }

    public void setAttributeXmlns_cm(String attributeXmlns_cm) {
        this.attributeXmlns_cm = attributeXmlns_cm;
    }
}
