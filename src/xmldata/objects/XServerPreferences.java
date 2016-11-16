/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import xmldata.objects.XPreference;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;
import java.util.ArrayList;

public class XServerPreferences {
    @XStreamImplicit(itemFieldName = "preference")
    private List<XPreference> preference = new ArrayList<>();

    public List<XPreference> getPreference() {
        return preference;
    }

    public void setPreference(List<XPreference> preference) {
        this.preference = preference;
    }
}
