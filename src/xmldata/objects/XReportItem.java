/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

public class XReportItem {
    private String attributePort;
    private String attributeSvc_name;
    private String attributeProtocol;
    private String attributeSeverity;
    private String attributePluginID;
    private String attributePluginName;
    private String attributePluginFamily;
    
    private String agent;
    private String description;
    private String fname;
    private String plugin_modification_date;
    private String plugin_name;
    private String plugin_publication_date;
    private String plugin_type;
    private String risk_factor;
    private String script_version;
    private String see_also;
    private String solution;
    private String synopsis;
    private String plugin_output;
    private String cpe;
    @XStreamImplicit(itemFieldName = "bid")
    private List<String> bid = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cve")
    private List<String> cve = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cvss_base_score")
    private List<String> cvss_base_score = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cvss_temporal_score")
    private List<String> cvss_temporal_score = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cvss_temporal_vector")
    private List<String> cvss_temporal_vector = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cvss_vector")
    private List<String> cvss_vector = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "exploit_available")
    private List<String> exploit_available = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "exploitability_ease")
    private List<String> exploitability_ease = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "in_the_news")
    private List<String> in_the_news = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "osvdb")
    private List<String> osvdb = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "vuln_publication_date")
    private List<String> vuln_publication_date = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "xref")
    private List<String> xref = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cert")
    private List<String> cert = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cwe")
    private List<String> cwe = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "exploited_by_nessus")
    private List<String> exploited_by_nessus = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "patch_publication_date")
    private List<String> patch_publication_date = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "unsupported_by_vendor")
    private List<String> unsupported_by_vendor = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "edb-id")
    private List<String> edb_id = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "exploit_framework_core")
    private List<String> exploit_framework_core = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "exploit_framework_metasploit")
    private List<String> exploit_framework_metasploit = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "metasploit_name")
    private List<String> metasploit_name = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cisco-bug-id")
    private List<String> cisco_bug_id = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cisco-sa")
    private List<String> cisco_sa = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "iava")
    private List<String> iava = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "stig_severity")
    private List<String> stig_severity = new ArrayList<>();
    @XStreamImplicit(itemFieldName = "cert-cc")
    private List<String> cert_cc = new ArrayList<>();
    
    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPlugin_modification_date() {
        return plugin_modification_date;
    }

    public void setPlugin_modification_date(String plugin_modification_date) {
        this.plugin_modification_date = plugin_modification_date;
    }

    public String getPlugin_name() {
        return plugin_name;
    }

    public void setPlugin_name(String plugin_name) {
        this.plugin_name = plugin_name;
    }

    public String getPlugin_publication_date() {
        return plugin_publication_date;
    }

    public void setPlugin_publication_date(String plugin_publication_date) {
        this.plugin_publication_date = plugin_publication_date;
    }

    public String getPlugin_type() {
        return plugin_type;
    }

    public void setPlugin_type(String plugin_type) {
        this.plugin_type = plugin_type;
    }

    public String getRisk_factor() {
        return risk_factor;
    }

    public void setRisk_factor(String risk_factor) {
        this.risk_factor = risk_factor;
    }

    public String getScript_version() {
        return script_version;
    }

    public void setScript_version(String script_version) {
        this.script_version = script_version;
    }

    public String getSee_also() {
        return see_also;
    }

    public void setSee_also(String see_also) {
        this.see_also = see_also;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPlugin_output() {
        return plugin_output;
    }

    public void setPlugin_output(String plugin_output) {
        this.plugin_output = plugin_output;
    }

    public String getCpe() {
        return cpe;
    }

    public void setCpe(String cpe) {
        this.cpe = cpe;
    }

    public List<String> getBid() {
        return bid;
    }

    public void setBid(List<String> bid) {
        this.bid = bid;
    }

    public List<String> getCve() {
        return cve;
    }

    public void setCve(List<String> cve) {
        this.cve = cve;
    }

    public List<String> getCvss_base_score() {
        return cvss_base_score;
    }

    public void setCvss_base_score(List<String> cvss_base_score) {
        this.cvss_base_score = cvss_base_score;
    }

    public List<String> getCvss_temporal_score() {
        return cvss_temporal_score;
    }

    public void setCvss_temporal_score(List<String> cvss_temporal_score) {
        this.cvss_temporal_score = cvss_temporal_score;
    }

    public List<String> getCvss_temporal_vector() {
        return cvss_temporal_vector;
    }

    public void setCvss_temporal_vector(List<String> cvss_temporal_vector) {
        this.cvss_temporal_vector = cvss_temporal_vector;
    }

    public List<String> getCvss_vector() {
        return cvss_vector;
    }

    public void setCvss_vector(List<String> cvss_vector) {
        this.cvss_vector = cvss_vector;
    }

    public List<String> getExploit_available() {
        return exploit_available;
    }

    public void setExploit_available(List<String> exploit_available) {
        this.exploit_available = exploit_available;
    }

    public List<String> getExploitability_ease() {
        return exploitability_ease;
    }

    public void setExploitability_ease(List<String> exploitability_ease) {
        this.exploitability_ease = exploitability_ease;
    }

    public List<String> getIn_the_news() {
        return in_the_news;
    }

    public void setIn_the_news(List<String> in_the_news) {
        this.in_the_news = in_the_news;
    }

    public List<String> getOsvdb() {
        return osvdb;
    }

    public void setOsvdb(List<String> osvdb) {
        this.osvdb = osvdb;
    }

    public List<String> getVuln_publication_date() {
        return vuln_publication_date;
    }

    public void setVuln_publication_date(List<String> vuln_publication_date) {
        this.vuln_publication_date = vuln_publication_date;
    }

    public List<String> getXref() {
        return xref;
    }

    public void setXref(List<String> xref) {
        this.xref = xref;
    }

    public List<String> getCert() {
        return cert;
    }

    public void setCert(List<String> cert) {
        this.cert = cert;
    }

    public List<String> getCwe() {
        return cwe;
    }

    public void setCwe(List<String> cwe) {
        this.cwe = cwe;
    }

    public List<String> getExploited_by_nessus() {
        return exploited_by_nessus;
    }

    public void setExploited_by_nessus(List<String> exploited_by_nessus) {
        this.exploited_by_nessus = exploited_by_nessus;
    }

    public List<String> getPatch_publication_date() {
        return patch_publication_date;
    }

    public void setPatch_publication_date(List<String> patch_publication_date) {
        this.patch_publication_date = patch_publication_date;
    }

    public List<String> getUnsupported_by_vendor() {
        return unsupported_by_vendor;
    }

    public void setUnsupported_by_vendor(List<String> unsupported_by_vendor) {
        this.unsupported_by_vendor = unsupported_by_vendor;
    }

    public List<String> getEdb_id() {
        return edb_id;
    }

    public void setEdb_id(List<String> edb_id) {
        this.edb_id = edb_id;
    }

    public List<String> getExploit_framework_core() {
        return exploit_framework_core;
    }

    public void setExploit_framework_core(List<String> exploit_framework_core) {
        this.exploit_framework_core = exploit_framework_core;
    }

    public List<String> getExploit_framework_metasploit() {
        return exploit_framework_metasploit;
    }

    public void setExploit_framework_metasploit(List<String> exploit_framework_metasploit) {
        this.exploit_framework_metasploit = exploit_framework_metasploit;
    }

    public List<String> getMetasploit_name() {
        return metasploit_name;
    }

    public void setMetasploit_name(List<String> metasploit_name) {
        this.metasploit_name = metasploit_name;
    }

    public List<String> getCisco_bug_id() {
        return cisco_bug_id;
    }

    public void setCisco_bug_id(List<String> cisco_bug_id) {
        this.cisco_bug_id = cisco_bug_id;
    }

    public List<String> getCisco_sa() {
        return cisco_sa;
    }

    public void setCisco_sa(List<String> cisco_sa) {
        this.cisco_sa = cisco_sa;
    }

    public List<String> getIava() {
        return iava;
    }

    public void setIava(List<String> iava) {
        this.iava = iava;
    }

    public List<String> getStig_severity() {
        return stig_severity;
    }

    public void setStig_severity(List<String> stig_severity) {
        this.stig_severity = stig_severity;
    }

    public List<String> getCert_cc() {
        return cert_cc;
    }

    public void setCert_cc(List<String> cert_cc) {
        this.cert_cc = cert_cc;
    }

    public String getAttributePort() {
        return attributePort;
    }

    public void setAttributePort(String attributePort) {
        this.attributePort = attributePort;
    }

    public String getAttributeSvc_name() {
        return attributeSvc_name;
    }

    public void setAttributeSvc_name(String attributeSvc_name) {
        this.attributeSvc_name = attributeSvc_name;
    }

    public String getAttributeProtocol() {
        return attributeProtocol;
    }

    public void setAttributeProtocol(String attributeProtocol) {
        this.attributeProtocol = attributeProtocol;
    }

    public String getAttributeSeverity() {
        return attributeSeverity;
    }

    public void setAttributeSeverity(String attributeSeverity) {
        this.attributeSeverity = attributeSeverity;
    }

    public String getAttributePluginID() {
        return attributePluginID;
    }

    public void setAttributePluginID(String attributePluginID) {
        this.attributePluginID = attributePluginID;
    }

    public String getAttributePluginName() {
        return attributePluginName;
    }

    public void setAttributePluginName(String attributePluginName) {
        this.attributePluginName = attributePluginName;
    }

    public String getAttributePluginFamily() {
        return attributePluginFamily;
    }

    public void setAttributePluginFamily(String attributePluginFamily) {
        this.attributePluginFamily = attributePluginFamily;
    }

}
