/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import xmldata.objects.XPluginsPreferences;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class XPreferences {
    @XStreamAlias("ServerPreferences")
    private XServerPreferences serverPreferences;
    @XStreamAlias("PluginsPreferences")
    private XPluginsPreferences pluginsPreferences;

    public XServerPreferences getServerPreferences() {
        return serverPreferences;
    }

    public void setServerPreferences(XServerPreferences serverPreferences) {
        this.serverPreferences = serverPreferences;
    }

    public XPluginsPreferences getPluginsPreferences() {
        return pluginsPreferences;
    }

    public void setPluginsPreferences(XPluginsPreferences pluginsPreferences) {
        this.pluginsPreferences = pluginsPreferences;
    }
}
