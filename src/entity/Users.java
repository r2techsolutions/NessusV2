package entity;
// Generated Sep 12, 2016 10:48:21 PM by Hibernate Tools 4.3.1



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private String userId;
     private String password;
     private String firstName;
     private String middleName;
     private String lastName;
     private String email;
     private String phone;
     private String role;

    public Users() {
    }

	
    public Users(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    public Users(String userId, String password, String firstName, String middleName, String lastName, String email, String phone, String role) {
       this.userId = userId;
       this.password = password;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.email = email;
       this.phone = phone;
       this.role = role;
    }
   
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }




}


