/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata;

import xmldata.objects.XServerPreferences;
import xmldata.objects.XPreferences;
import xmldata.objects.XReportItem;
import xmldata.objects.XReportHost;
import xmldata.objects.XReport;
import xmldata.objects.XPolicy;
import xmldata.objects.XNessusClientData;
import xmldata.objects.XPluginsPreferences;
import xmldata.objects.XHostProperties;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import util.XStreamCreator;
import xmldata.objects.XTag;

public class Extractor {
    
    public XNessusClientData extractXmlData(String fileName) throws SAXException, IOException, ParserConfigurationException {
        String xmlContent = readXml(fileName);
        XStream xStream = XStreamCreator.createXStream();         
        XNessusClientData nessusClientData = (XNessusClientData) xStream.fromXML(xmlContent);
        
        return nessusClientData;
    }

    public String readXml(String fileName) throws SAXException, IOException, ParserConfigurationException {
        StringBuilder contentStringBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((String line) -> {
               contentStringBuilder.append(line);
            }); 
        }
        
        String content = contentStringBuilder.toString();
        return content;
    }

    public void displayData(XNessusClientData data) {
        XPolicy policy = data.getPolicy();         
        XReport report = data.getReport();
        
        String reportName = report.getAttributeName();
        String reportXmlns = report.getAttributeXmlns_cm();
        System.out.println("Report Name: " + reportName + " xmlns:" + reportXmlns);
        List<XReportHost> reportHostList = report.getReportHost();
        for (XReportHost reportHost : reportHostList) {
            System.out.println(reportHost.getAttributeName());
            
            List<XReportItem> reportItemList = reportHost.getReportItem();
            for (XReportItem reportItem : reportItemList) {
                String pluginOutput = reportItem.getAttributePluginFamily();
                System.out.println(pluginOutput);
                System.out.println("===========================");
            }
        }   
    }
}
