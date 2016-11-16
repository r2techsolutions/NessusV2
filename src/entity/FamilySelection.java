package entity;
// Generated Sep 12, 2016 10:48:21 PM by Hibernate Tools 4.3.1



/**
 * FamilySelection generated by hbm2java
 */
public class FamilySelection  implements java.io.Serializable {


     private Integer familySelectionId = 0;
     private String familyName;
     private String status;
     private Integer policyId;

    public FamilySelection() {
    }

	
    public FamilySelection(Integer familySelectionId) {
        this.familySelectionId = familySelectionId;
    }
    public FamilySelection(Integer familySelectionId, String familyName, String status, Integer policyId) {
       this.familySelectionId = familySelectionId;
       this.familyName = familyName;
       this.status = status;
       this.policyId = policyId;
    }
   
    public Integer getFamilySelectionId() {
        return this.familySelectionId;
    }
    
    public void setFamilySelectionId(Integer familySelectionId) {
        this.familySelectionId = familySelectionId;
    }
    public String getFamilyName() {
        return this.familyName;
    }
    
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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




}

