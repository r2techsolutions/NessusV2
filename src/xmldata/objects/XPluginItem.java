/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class XPluginItem {
    @XStreamAlias("PluginId")
    private String pluginId;
    @XStreamAlias("PluginName")
    private String pluginName;
    @XStreamAlias("Family")
    private String family;
     @XStreamAlias("Status")
    private String status;

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String PluginId) {
        this.pluginId = PluginId;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String PluginName) {
        this.pluginName = PluginName;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String Family) {
        this.family = Family;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }
}
