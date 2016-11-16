/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import xmldata.objects.XIndividualPluginSelection;
import xmldata.objects.XFamilySelection;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class XPolicy {
    private String policyName;
    @XStreamAlias("Preferences")
    private XPreferences preferences; 
    @XStreamAlias("FamilySelection")
    private XFamilySelection familySelection;
    @XStreamAlias("IndividualPluginSelection")
    private XIndividualPluginSelection individualPluginSelection;

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public XPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(XPreferences preferences) {
        this.preferences = preferences;
    }

    public XFamilySelection getFamilySelection() {
        return familySelection;
    }

    public void setFamilySelection(XFamilySelection familySelection) {
        this.familySelection = familySelection;
    }

    public XIndividualPluginSelection getIndividualPluginSelection() {
        return individualPluginSelection;
    }

    public void setIndividualPluginSelection(XIndividualPluginSelection individualPluginSelection) {
        this.individualPluginSelection = individualPluginSelection;
    }
}
