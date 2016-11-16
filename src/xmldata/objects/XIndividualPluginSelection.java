/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

public class XIndividualPluginSelection {
    @XStreamImplicit(itemFieldName = "PluginItem")
    private List<XPluginItem> pluginItem = new ArrayList<>();

    public List<XPluginItem> getPluginItem() {
        return pluginItem;
    }

    public void setPluginItem(List<XPluginItem> pluginItem) {
        this.pluginItem = pluginItem;
    }
}
