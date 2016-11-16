/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import admin.UserSingleton;
import dbdata.Loader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import xmldata.Extractor;
import dbdata.Retriever;
import entity.Organization;
import entity.Users;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import nessus.Main;
import static org.omg.CORBA.ORB.init;
import xmldata.objects.XNessusClientData;

public class LoadDataController implements Initializable {

    @FXML
    private TextField fileNameTextField;
    @FXML
    private ComboBox orgComboBox;
    @FXML
    private Button loadDataButton;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private Button retrieveDataButton;
            
    private String userId;
    List<Organization> orgList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialData();
        initializeForm();
    }    
    
    @FXML
    private void browseAction(ActionEvent event) {
        Stage loadDataStage = (Stage)fileNameTextField.getScene().getWindow();
        
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(loadDataStage);
        String fileName = file.getAbsolutePath();
        fileNameTextField.setText(fileName);
        
        String orgName = orgComboBox.getSelectionModel().getSelectedItem().toString();
        if (fileName.length() > 0 && orgName.length() > 0) {
            loadDataButton.setVisible(true);
        }
        
    }
    
    @FXML
    private void retrieveDataAction(ActionEvent event) throws IOException {
        Parent loadData = FXMLLoader.load(getClass().getResource("/forms/RetrieveData.fxml"));
        Scene sceneNew = new Scene(loadData, 800, 600);

        Stage stage = new Stage();
        stage.setTitle("Retrieve Data");;
        sceneNew.getStylesheets().add(LoadDataController.class.getResource("/css/Application.css").toExternalForm());
        stage.setScene(sceneNew);
        stage.setMaximized(true);
        stage.show();

        Stage stageLogin = (Stage)retrieveDataButton.getScene().getWindow();
        stageLogin.close();
    }
    
    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }
   
    @FXML
    private void loadDataAction(ActionEvent event) {    
        String message = "";
        String fileName = fileNameTextField.getText();
        if (fileName.length() > 0) {
            try {
                String orgNameComboBox = orgComboBox.getSelectionModel().getSelectedItem().toString();
                if (orgNameComboBox.length() > 0) {
                    for (Organization org : orgList) {
                        String orgId = String.valueOf(org.getOrgId());
                        if (orgId.equals(orgNameComboBox.subSequence(0, orgNameComboBox.indexOf(".")))) {
                            loadData(userId, orgId, fileName);  
                            break;
                        }
                    }
                }
                else {
                    message = "Please select an organization. ";
                }
            }
            catch (Exception ex) {
                Logger.getLogger(LoadDataController.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        else {
            message = "Please select an XML file. ";
        }
    }

    private void loadData(String userId, String orgId, String fileName) {
        String message = "";
        
        try {
            loadDataButton.getScene().setCursor(Cursor.WAIT); 
            Extractor extractor = new Extractor();
            Loader loader = new Loader();
            Retriever retriever = new Retriever();
            
            XNessusClientData nessusClientData = extractor.extractXmlData(fileName);
            Integer loadCycleId = loader.loadData(userId, Integer.SIZE, nessusClientData);
            if (loadCycleId > 0) {
                message = "Data has been loaded into database successfully.";
            }
            else {
                message = fileName + " Data loading failed.";
            }
            messageLabel.setText(message);
            loadDataButton.getScene().setCursor(Cursor.DEFAULT); 
        } catch (SAXException ex) {
            Logger.getLogger(LoadDataController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoadDataController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LoadDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Integer processData(String userId, Integer orgId, String fileName) throws Exception {
        Loader loader = new Loader();
        Extractor extractor = new Extractor();
        XNessusClientData nessusClientData = extractor.extractXmlData(fileName);
        
        Integer loadCycleId = loader.loadData(userId, orgId, nessusClientData);          
       
        return loadCycleId;
    }
    
    private static void initialData() {
        
    }
    
    private static void retrive() {
        try {
            Retriever retriever = new Retriever();
            Integer loadCycleId = Integer.parseInt("8");
            retriever.getAllData(loadCycleId);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    private void initializeForm() {
        loadDataButton.setVisible(false);
        
        UserSingleton userSingleton = UserSingleton.getUserSingleton();
        Users user = userSingleton.getUser();
        userNameLabel.setText("Welcom " + user.getFirstName() + " " + user.getLastName());    
        userId = user.getUserId();       
        
        Retriever retriever = new Retriever();
        try {
            orgList = retriever.getOrg();
            for (Organization org : orgList) {
                orgComboBox.getItems().add(org.getOrgId() + ". " + org.getOrgName() + " - " + org.getDescription());                
            }
        } catch (Exception ex) {
            Logger.getLogger(LoadDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
