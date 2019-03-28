/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxu.bart.ftpclient.scenes.controllers;

import com.sxu.bart.ftpclient.ftp.FtpServer;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bartb
 */
public class MainSceneController {

    @FXML
    private Button tbbtnConnect;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    }    
    
    @FXML
    private void tbbtnConnect_Click(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/NewServerConnection.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Connection");
        stage.show();
        
//        String host = "speedtest.tele2.net";
//        int port = 21;
//        String user = "anonymous";
//        String password = "any";
//        
//        FtpServer server = new FtpServer();
//        server.setHost(host);
//        server.setPort(port);
//        server.setUser(user);
//        server.setPassword(password);
//        
//        try {
//            server.connect();
//            String[] fileNames = server.getFiles();
//            server.disconnect();
//            
//            Alert alert = new Alert(AlertType.INFORMATION);
//            StringBuilder buffer = new StringBuilder();
//            for(String file : fileNames) {
//                buffer.append(file);
//                buffer.append(System.getProperty("line.separator"));
//            }
//            alert.setContentText(buffer.toString());
//            alert.showAndWait();
//            
//        } catch (IOException ex) {
//            
//        }
    }
}
