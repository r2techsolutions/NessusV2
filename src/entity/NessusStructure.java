package entity;
// Generated Sep 12, 2016 10:48:21 PM by Hibernate Tools 4.3.1



/**
 * NessusStructure generated by hbm2java
 */
public class NessusStructure  implements java.io.Serializable {


     private int id = 0;
     private String parentName;
     private String name;

    public NessusStructure() {
    }

	
    public NessusStructure(int id, String parentName) {
        this.id = id;
        this.parentName = parentName;
    }
    public NessusStructure(int id, String parentName, String name) {
       this.id = id;
       this.parentName = parentName;
       this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}


