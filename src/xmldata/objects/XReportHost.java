/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import xmldata.objects.XHostProperties;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

public class XReportHost {
    private String attributeName;
    
    @XStreamAlias("HostProperties")
    private XHostProperties hostProperties;
    @XStreamImplicit(itemFieldName = "ReportItem")
    private List<XReportItem> reportItem = new ArrayList<>();

    public XHostProperties getHostProperties() {
        return hostProperties;
    }

    public void setHostProperties(XHostProperties hostProperties) {
        this.hostProperties = hostProperties;
    }

    public List<XReportItem> getReportItem() {
        return reportItem;
    }

    public void setReportItem(List<XReportItem> reportItem) {
        this.reportItem = reportItem;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
