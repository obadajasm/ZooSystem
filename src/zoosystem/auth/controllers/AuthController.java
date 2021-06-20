/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.auth.controllers;

import Utils.DialogUtil;
import Utils.NavigationHelper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class AuthController implements Initializable {
  public Button loginBtn;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField emailTF;

    @FXML
    private void loginBtnClck(ActionEvent event) throws IOException,InvocationTargetException  {
        final String  password= passwordTF.getText();
        final String  email= emailTF.getText();
//        if(password.isEmpty()||email.isEmpty()){
//            DialogUtil.getInstance().show("Passowrd and Email are required", "Error");
//                   return; 
//        }
        ///
        try{
           NavigationHelper.getInstance().navigateTo(loginBtn,"home/view/HomeFXML.fxml");
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
