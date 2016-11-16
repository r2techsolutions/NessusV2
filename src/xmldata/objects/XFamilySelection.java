/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

public class XFamilySelection {
    @XStreamImplicit(itemFieldName = "FamilyItem")
    private List<XFamilyItem> familyItem = new ArrayList<>();

    public List<XFamilyItem> getFamilyItem() {
        return familyItem;
    }

    public void setFamilyItem(List<XFamilyItem> familyItem) {
        this.familyItem = familyItem;
    }
}
