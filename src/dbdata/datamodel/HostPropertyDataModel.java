/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class HostPropertyDataModel {
    private final SimpleStringProperty reportHostId = new SimpleStringProperty("");
    private final SimpleStringProperty lastUnauthenticatedResults = new SimpleStringProperty("");
    private final SimpleStringProperty credentialedScan = new SimpleStringProperty("");
    private final SimpleStringProperty policyUsed = new SimpleStringProperty("");
    private final SimpleStringProperty patchSummaryTotalCves = new SimpleStringProperty("");
    private final SimpleStringProperty cpe = new SimpleStringProperty("");
    private final SimpleStringProperty os = new SimpleStringProperty("");
    private final SimpleStringProperty cpe1 = new SimpleStringProperty("");
    private final SimpleStringProperty cpe0 = new SimpleStringProperty("");
    private final SimpleStringProperty systemType = new SimpleStringProperty("");
    private final SimpleStringProperty operatingSystem = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop10 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop9 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop8 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop7 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop6 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop5 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop4 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop3 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop2 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop1 = new SimpleStringProperty("");
    private final SimpleStringProperty tracerouteHop0 = new SimpleStringProperty("");
    private final SimpleStringProperty hostEnd = new SimpleStringProperty("");
    private final SimpleStringProperty hostIp = new SimpleStringProperty("");
    private final SimpleStringProperty hostStart = new SimpleStringProperty("");
            
    public HostPropertyDataModel() {
        this("","","","","","","","","","","","","","","","","","","","","","","","","");
    }

    public HostPropertyDataModel(String reportHostId, String lastUnauthenticatedResults, String credentialedScan, String policyUsed, String patchSummaryTotalCves,
        String cpe, String os, String cpe1, String cpe0, String systemType,
        String operatingSystem, String tracerouteHop10, String tracerouteHop9, String tracerouteHop8, String tracerouteHop7,
        String tracerouteHop6, String tracerouteHop5, String tracerouteHop4, String tracerouteHop3, String tracerouteHop2,
        String tracerouteHop1, String tracerouteHop0, String hostEnd, String hostIp, String hostStart) {
        setReportHostId(reportHostId);
        setLastUnauthenticatedResults(lastUnauthenticatedResults);
        setCredentialedScan(credentialedScan);
        setPolicyUsed(policyUsed);
        setPatchSummaryTotalCves(patchSummaryTotalCves);
        setCpe(cpe);
        setOs(os);
        setCpe1(cpe1);
        setCpe0(cpe0);
        setSystemType(systemType);
        setOperatingSystem(operatingSystem);
        setTracerouteHop10(tracerouteHop10);
        setTracerouteHop9(tracerouteHop9);
        setTracerouteHop8(tracerouteHop8);
        setTracerouteHop7(tracerouteHop7);
        setTracerouteHop6(tracerouteHop6);
        setTracerouteHop5(tracerouteHop5);
        setTracerouteHop4(tracerouteHop4);
        setTracerouteHop3(tracerouteHop3);
        setTracerouteHop2(tracerouteHop1);
        setTracerouteHop1(tracerouteHop1);
        setTracerouteHop0(tracerouteHop0);
        setHostEnd(hostEnd);
        setHostIp(hostIp);
        setHostStart(hostStart);
        
        
    }

    public String getReportHostId() {
        return reportHostId.get();
    }

    public void setReportHostId(String reportHostId) {
        this.reportHostId.set(reportHostId);
    }
    
    public String getLastUnauthenticatedResults() {
        return lastUnauthenticatedResults.get();
    }

    public void setLastUnauthenticatedResults(String lastUnauthenticatedResults) {
        this.lastUnauthenticatedResults.set(lastUnauthenticatedResults);
    }
    
    public String getCredentialedScan() {
        return credentialedScan.get();
    }

    public void setCredentialedScan(String credentialedScan) {
        this.credentialedScan.set(credentialedScan);
    }
    
    public String getPolicyUsed() {
        return policyUsed.get();
    }

    public void setPolicyUsed(String policyUsed) {
        this.policyUsed.set(policyUsed);
    }
    
    public String getPatchSummaryTotalCves() {
        return patchSummaryTotalCves.get();
    }
    
    public void setPatchSummaryTotalCves(String patchSummaryTotalCves) {
        this.patchSummaryTotalCves.set(patchSummaryTotalCves);
    }

    public String getCpe() {
        return cpe.get();
    }
    
    public void setCpe(String cpe) {
        this.cpe.set(cpe);
    }

    public String getOs() {
        return os.get();
    }
    
    public void setOs(String os) {
        this.os.set(os);
    }

    public String getCpe1() {
        return cpe1.get();
    }
    
    public void setCpe1(String cpe1) {
        this.cpe1.set(cpe1);
    }

    public String getCpe0() {
        return cpe0.get();
    }
    
    public void setCpe0(String cpe0) {
        this.cpe0.set(cpe0);
    }

    public String getSystemType() {
        return systemType.get();
    }
    
    public void setSystemType(String systemType) {
        this.systemType.set(systemType);
    }

    public String getOperatingSystem() {
        return operatingSystem.get();
    }
    
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem.set(operatingSystem);
    }

    public String getTracerouteHop10() {
        return tracerouteHop10.get();
    }
    
    public void setTracerouteHop10(String tracerouteHop10) {
        this.tracerouteHop10.set(tracerouteHop10);
    }

    public String getTracerouteHop9() {
        return tracerouteHop9.get();
    }

    public void setTracerouteHop9(String tracerouteHop9) {
        this.tracerouteHop9.set(tracerouteHop9);
    }
    
    public String getTracerouteHop8() {
        return tracerouteHop8.get();
    }
    
   public void setTracerouteHop8(String tracerouteHop8) {
        this.tracerouteHop8.set(tracerouteHop8);
    }

    public String getTracerouteHop7() {
        return tracerouteHop7.get();
    }
    
    public void setTracerouteHop7(String tracerouteHop7) {
        this.tracerouteHop7.set(tracerouteHop7);
    }

    public String getTracerouteHop6() {
        return tracerouteHop6.get();
    }
    
    public void setTracerouteHop6(String tracerouteHop6) {
        this.tracerouteHop6.set(tracerouteHop6);
    }

    public String getTracerouteHop5() {
        return tracerouteHop5.get();
    }
    
    public void setTracerouteHop5(String tracerouteHop5) {
        this.tracerouteHop5.set(tracerouteHop5);
    }

    public String getTracerouteHop4() {
        return tracerouteHop4.get();
    }
    
    public void setTracerouteHop4(String tracerouteHop4) {
        this.tracerouteHop4.set(tracerouteHop4);
    }

    public String getTracerouteHop3() {
        return tracerouteHop3.get();
    }

    public void setTracerouteHop3(String tracerouteHop3) {
        this.tracerouteHop3.set(tracerouteHop3);
    }
    
    public String getTracerouteHop2() {
        return tracerouteHop2.get();
    }

    public void setTracerouteHop2(String tracerouteHop2) {
        this.tracerouteHop2.set(tracerouteHop2);
    }
    
    public String getTracerouteHop1() {
        return tracerouteHop1.get();
    }

    public void setTracerouteHop1(String tracerouteHop1) {
        this.tracerouteHop1.set(tracerouteHop1);
    }
    
    public String getTracerouteHop0() {
        return tracerouteHop0.get();
    }

    public void setTracerouteHop0(String tracerouteHop0) {
        this.tracerouteHop0.set(tracerouteHop0);
    }
     
    public String getHostEnd() {
        return hostEnd.get();
    }

    public void setHostEnd(String hostEnd) {
        this.hostEnd.set(hostEnd);
    }
    
    public String getHostIp() {
        return hostIp.get();
    }
    
    public void setHostIp(String hostIp) {
        this.hostIp.set(hostIp);
    }

    public String getHostStart() {
        return hostStart.get();
    }

    public void setHostStart(String hostStart) {
        this.hostStart.set(hostStart);
    }
}
