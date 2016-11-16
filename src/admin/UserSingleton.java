/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import entity.Users;

public class UserSingleton {
    private static UserSingleton instance;
    private Users user;
    
    private UserSingleton(){}
    
    public static UserSingleton getUserSingleton(){
        if(instance == null){
            instance = new UserSingleton();
        }
        return instance;
    }
 
    public Users getUser() {
        return user;
    }
    
    public void setUser(Users user) {
        this.user = user;
    }
}
