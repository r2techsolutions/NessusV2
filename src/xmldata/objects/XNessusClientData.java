/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("NessusClientData_v2")
public class XNessusClientData {
    @XStreamAlias("Policy")
    private XPolicy policy;
    @XStreamAlias("Report")
    private XReport report;

    public XPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(XPolicy policy) {
        this.policy = policy;
    }

    public XReport getReport() {
        return report;
    }

    public void setReport(XReport report) {
        this.report = report;
    }
}
