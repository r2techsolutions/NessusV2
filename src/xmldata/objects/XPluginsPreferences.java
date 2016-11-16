/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

public class XPluginsPreferences {
    @XStreamImplicit(itemFieldName = "item")
    private List<XItem> item = new ArrayList<>();

    public List<XItem> getItem() {
        return item;
    }

    public void setItem(List<XItem> item) {
        this.item = item;
    }
}
