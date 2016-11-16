/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

/**
 *
 * @author Dell
 */
public class XReportItemAttributes {
    private String port;
    private String svc_name;
    private String protocol;
    private String severity;
    private String pluginID;
    private String pluginName;
    private String pluginFamily;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSvc_name() {
        return svc_name;
    }

    public void setSvc_name(String svc_name) {
        this.svc_name = svc_name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getPluginID() {
        return pluginID;
    }

    public void setPluginID(String pluginID) {
        this.pluginID = pluginID;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getPluginFamily() {
        return pluginFamily;
    }

    public void setPluginFamily(String pluginFamily) {
        this.pluginFamily = pluginFamily;
    }
}
