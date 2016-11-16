package nessus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       
        Parent main = FXMLLoader.load(getClass().getResource("/forms/Login.fxml"));       
        Scene scene = new Scene(main, 800, 600);

        stage.setTitle("Nessus Login");;
        stage.setScene(scene);
        stage.resizableProperty().set(false);
        scene.getStylesheets().add(Main.class.getResource("/css/login.css").toExternalForm());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

