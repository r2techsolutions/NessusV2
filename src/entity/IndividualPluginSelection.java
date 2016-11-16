package entity;
// Generated Sep 12, 2016 10:48:21 PM by Hibernate Tools 4.3.1



/**
 * IndividualPluginSelection generated by hbm2java
 */
public class IndividualPluginSelection  implements java.io.Serializable {


     private Integer pluginId = 0;
     private String pluginName;
     private String family;
     private String status;
     private Integer policyId;
     private String pluginIdData;

    public IndividualPluginSelection() {
    }

	
    public IndividualPluginSelection(Integer pluginId) {
        this.pluginId = pluginId;
    }
    public IndividualPluginSelection(Integer pluginId, String pluginName, String family, String status, Integer policyId, String pluginIdData) {
       this.pluginId = pluginId;
       this.pluginName = pluginName;
       this.family = family;
       this.status = status;
       this.policyId = policyId;
       this.pluginIdData = pluginIdData;
    }
   
    public Integer getPluginId() {
        return this.pluginId;
    }
    
    public void setPluginId(Integer pluginId) {
        this.pluginId = pluginId;
    }
    public String getPluginName() {
        return this.pluginName;
    }
    
    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }
    public String getFamily() {
        return this.family;
    }
    
    public void setFamily(String family) {
        this.family = family;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getPolicyId() {
        return this.policyId;
    }
    
    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }
    public String getPluginIdData() {
        return this.pluginIdData;
    }
    
    public void setPluginIdData(String pluginIdData) {
        this.pluginIdData = pluginIdData;
    }




}


