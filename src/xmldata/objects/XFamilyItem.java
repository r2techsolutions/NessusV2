/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class XFamilyItem {
    @XStreamAlias("FamilyName")
    private String familyName;
    @XStreamAlias("Status")
    private String status;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String FamilyName) {
        this.familyName = FamilyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }
}
