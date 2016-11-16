/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import admin.UserSingleton;
import dbdata.Retriever;
import entity.Users;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML
    private TextField userNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button signIn;
    @FXML
    private Text actiontarget;
    
    @FXML
    private void signInAction(ActionEvent event) throws Exception {
        //            sceneCurrent.setCursor(Cursor.WAIT); 
        login();  
//        sceneCurrent.setCursor(Cursor.DEFAULT); 
                
     }
    
    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    private void login() {
        String userId = userNameField.getText();
        String password = passwordField.getText();
        Scene sceneCurrent = signIn.getScene();    
        try {
            Retriever retriever = new Retriever();
            Users user = retriever.getUser(userId, password);
            if (user != null) {
                UserSingleton userSingleton = UserSingleton.getUserSingleton();
                userSingleton.setUser(user);
                
//                Parent loadData = FXMLLoader.load(getClass().getResource("/forms/LoadData.fxml"));
                Parent mainWindow = FXMLLoader.load(getClass().getResource("/forms/MainFrame.fxml"));
                Scene sceneNew = new Scene(mainWindow);

                Stage stage = new Stage();
                stage.setTitle("Nessus");;
                sceneNew.getStylesheets().add(LoadDataController.class.getResource("/css/mainFrame.css").toExternalForm());
                stage.setScene(sceneNew);
                stage.setMaximized(true);
                stage.show();

                Stage stageLogin = (Stage)signIn.getScene().getWindow();
                stageLogin.close();

            }
            else {
                actiontarget.setText("Invalid user ID or password.");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
