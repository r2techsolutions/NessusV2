/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.thoughtworks.xstream.XStream;
import xmldata.objects.XHostProperties;
import xmldata.objects.XNessusClientData;
import xmldata.objects.XPluginsPreferences;
import xmldata.objects.XPolicy;
import xmldata.objects.XPreferences;
import xmldata.objects.XReport;
import xmldata.objects.XServerPreferences;
import xmldata.objects.XTag;
import xmldata.objects.XReportHost;
import xmldata.objects.XReportItem;

public class XStreamCreator {
    public static XStream createXStream() {
        XStream xStream = new XStream(); 
        
        xStream.processAnnotations(XNessusClientData.class);
        xStream.processAnnotations(XPolicy.class);
        xStream.processAnnotations(XPreferences.class);
        xStream.processAnnotations(XServerPreferences.class);
        xStream.processAnnotations(XPluginsPreferences.class);
        
        xStream.processAnnotations(XReport.class);
        xStream.aliasAttribute(XReport.class, "attributeName", "name");
        xStream.aliasAttribute(XReport.class, "attributeXmlns_cm", "xmlns:cm");
         
        xStream.processAnnotations(XReportHost.class);
        xStream.aliasAttribute(XReportHost.class, "attributeName", "name");
        
        xStream.processAnnotations(XHostProperties.class);
        
        xStream.processAnnotations(XTag.class);
        xStream.aliasAttribute(XTag.class, "attributeName", "name");
         
        xStream.processAnnotations(XReportItem.class);        
        xStream.aliasAttribute(XReportItem.class, "attributePort", "port");
        xStream.aliasAttribute(XReportItem.class, "attributeSvc_name", "svc_name");
        xStream.aliasAttribute(XReportItem.class, "attributeProtocol", "protocol");
        xStream.aliasAttribute(XReportItem.class, "attributeSeverity", "severity");
        xStream.aliasAttribute(XReportItem.class, "attributePluginID", "pluginID");
        xStream.aliasAttribute(XReportItem.class, "attributePluginName", "pluginName");
        xStream.aliasAttribute(XReportItem.class, "attributePluginFamily", "pluginFamily");
        
        return xStream;
    }
}
