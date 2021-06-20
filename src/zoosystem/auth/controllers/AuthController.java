/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.auth.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class AuthController implements Initializable {
  public Button loginBtn;

    @FXML
    private void loginBtnClck(ActionEvent event) throws IOException,InvocationTargetException  {
        try{
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../home/view/HomeFXML.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Hello World!");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
    System.out.println(e.getCause()
    );
}
               
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
   
    }

    @FXML
    private void signupClck(ActionEvent event) {
    }
   
}
