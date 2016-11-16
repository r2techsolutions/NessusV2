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

@XStreamAlias("HostProperties")
public class XHostProperties {
   @XStreamImplicit(itemFieldName="tag")
    private List<XTag> tag;

    public List<XTag> getTag() {
        return tag;
    }

    public void setTag(List<XTag> tag) {
        this.tag = tag;
    }

}