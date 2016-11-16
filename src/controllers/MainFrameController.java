/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainFrameController implements Initializable {
//    @FXML
//    private StackPane loadDataView;
//    @FXML
//    private StackPane retrieveDataView;
    @FXML
    private StackPane contentView;
    
    @FXML
    private void loadDataAction(ActionEvent event) throws Exception {
        contentView.getChildren().clear();
        contentView.getChildren().add(FXMLLoader.load(getClass().getResource("/forms/LoadData.fxml")));
//        setAllWindowsVisible(false);
//        loadDataView.visibleProperty().set(true);
    }
    
    @FXML
    private void retrieveDataAction(ActionEvent event) throws Exception {
//        setAllWindowsVisible(false);
//        retrieveDataView.visibleProperty().set(true);
        
        contentView.getChildren().clear();
        contentView.getChildren().add(FXMLLoader.load(getClass().getResource("/forms/RetrieveData.fxml")));
    }
    
    @FXML
    private void exitAction(ActionEvent event) throws Exception {
     Platform.exit();
     System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        setAllWindowsVisible(false);
    }    

//    private void setAllWindowsVisible(boolean b) {
//        loadDataView.visibleProperty().set(b);
//        retrieveDataView.visibleProperty().set(b);
//    }
}
