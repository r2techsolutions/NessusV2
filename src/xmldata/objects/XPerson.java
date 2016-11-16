/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Student")
public class XPerson {
    @XStreamAlias("FullName")
    private String name;

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String toString() {
            return getName();
    }
}
