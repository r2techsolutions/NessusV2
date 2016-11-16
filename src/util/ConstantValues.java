/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;

public class ConstantValues {

    public final static int LOAD_DATA_FAILED = -1;
    
    public final static String treeRoot = "NessusV2";
    public final static String treePolicy = "Policy";
    public final static String treeReport = "Report";
    public final static String treeReportHost = "ReportHost";
    public final static String treeHostProperties = "HostProperties";
    public final static String treeReportItem = "ReportItem";
    public final static String treeItem = "Item";
    
    public static List<String> getReportItemNames() {
        List<String> reportItemNameList = new ArrayList<String>();
        reportItemNameList.add("agent");
        reportItemNameList.add("description");
        reportItemNameList.add("fname");
        reportItemNameList.add("plugin_modification_date");
        reportItemNameList.add("plugin_name");
        reportItemNameList.add("plugin_publication_date");
        reportItemNameList.add("plugin_type");
        reportItemNameList.add("risk_factor");
        reportItemNameList.add("script_version");
        reportItemNameList.add("see_also");
        reportItemNameList.add("solution");
        reportItemNameList.add("synopsis");
        reportItemNameList.add("plugin_output");
        reportItemNameList.add("cpe");
        reportItemNameList.add("bid");
        reportItemNameList.add("cve");
        reportItemNameList.add("cvss_base_score");
        reportItemNameList.add("cvss_temporal_score");
        reportItemNameList.add("cvss_temporal_vector");
        reportItemNameList.add("cvss_vector");
        reportItemNameList.add("exploit_available");
        reportItemNameList.add("exploitability_ease");
        reportItemNameList.add("in_the_news");
        reportItemNameList.add("osvdb");
        reportItemNameList.add("vuln_publication_date");
        reportItemNameList.add("xref");
        reportItemNameList.add("cert");
        reportItemNameList.add("exploited_by_nessus");
        reportItemNameList.add("patch_publication_date");
        reportItemNameList.add("unsupported_by_vendor");
        reportItemNameList.add("edb-id");
        reportItemNameList.add("exploit_framework_core");
        reportItemNameList.add("exploit_framework_metasploit");
        reportItemNameList.add("metasploit_name");
        reportItemNameList.add("cisco-bug-id");
        reportItemNameList.add("cisco_sa");
        reportItemNameList.add("iava");
        reportItemNameList.add("stig_severity");
        reportItemNameList.add("cert_cc");
        
        return reportItemNameList;
    }
   
    public static List<String> getReportPropertyNames() {
        List<String> reportPropertyNameInputList = new ArrayList<>();
        reportPropertyNameInputList.add("LastUnauthenticatedResults");
        reportPropertyNameInputList.add("Credentialed_Scan");
        reportPropertyNameInputList.add("policy-used");
        reportPropertyNameInputList.add("patch-summary-total-cves");
        reportPropertyNameInputList.add("cpe");
        reportPropertyNameInputList.add("os");
        reportPropertyNameInputList.add("cpe-1");
        reportPropertyNameInputList.add("cpe-0");
        reportPropertyNameInputList.add("system-type");
        reportPropertyNameInputList.add("operating-system");
        reportPropertyNameInputList.add("traceroute-hop-10");
        reportPropertyNameInputList.add("traceroute-hop-9");
        reportPropertyNameInputList.add("traceroute-hop-8");
        reportPropertyNameInputList.add("traceroute-hop-7");
        reportPropertyNameInputList.add("traceroute-hop-6");
        reportPropertyNameInputList.add("traceroute-hop-5");
        reportPropertyNameInputList.add("traceroute-hop-4");
        reportPropertyNameInputList.add("traceroute-hop-3");
        reportPropertyNameInputList.add("traceroute-hop-2");
        reportPropertyNameInputList.add("traceroute-hop-1");
        reportPropertyNameInputList.add("traceroute-hop-0");
        reportPropertyNameInputList.add("HOST_END");
        reportPropertyNameInputList.add("host-ip");
        reportPropertyNameInputList.add("HOST_START");
        
         List<String> reportPropertyNameList = new ArrayList<>();
         for (String name : reportPropertyNameInputList) {
             reportPropertyNameList.add(name.toLowerCase());
         }
        return reportPropertyNameList;
    }
}
