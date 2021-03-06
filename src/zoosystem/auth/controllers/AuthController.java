/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.auth.controllers;

import DAOs.UserDAO;
import Utils.DialogUtil;
import Utils.NavigationHelper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import models.User;

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
    private TextField userNameTF;
    @FXML
    private Button signupBtn;

    private Boolean isLogin = true;
    private final UserDAO userDAO = new UserDAO();
                 final String regex = "^(.+)@(.+)$";
                        Pattern pattern = Pattern.compile(regex);



    @FXML
    private void loginBtnClck(ActionEvent event) throws IOException, InvocationTargetException {

        if (isLogin) {
            final ArrayList<User> users = userDAO.getUsers();

            final String password = passwordTF.getText().toLowerCase().trim();
            final String email = emailTF.getText().toLowerCase().trim();
            if (password.isEmpty() || email.isEmpty()) {
                DialogUtil.getInstance().show("Passowrd and Email are required", "Error");
                return;
            }

        
         
     
            
            
            for (User user : users) {
                if (email.equals(user.getEmail().toLowerCase()) && password.equals(user.getPassword().toLowerCase())) {
                    System.out.println(user.getRole());
                    if(user.getRole().equals("admin")){
                                          NavigationHelper.getInstance().navigateTo(loginBtn, "home/view/HomeFXML.fxml");

                    }else{
                            NavigationHelper.getInstance().navigateTo(loginBtn, "homevisitor/view/homeVisitorFXML.fxml");
                    }
                    return;
                }
            }
                
            ////show error msg
            DialogUtil.getInstance().show("Invalid Email or Passowrd", "Error");

        } else {
            ///toogle login/signup mode

            isLogin = !isLogin;
            signupBtn.setLayoutY(350.0);
            loginBtn.setLayoutY(300);
            loginBtn.setText("login");
            signupBtn.setText("Signup ?");
            signupBtn.setPrefWidth(100.0);
            loginBtn.setPrefWidth(150.0);

            userNameTF.setVisible(!isLogin);

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        
        
        userNameTF.setVisible(!isLogin);
        signupBtn.setPrefWidth(100.0);
        loginBtn.setPrefWidth(150.0);
          
        emailTF.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$\"")) {
//                emailTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

    }

    @FXML
    private void signupClck(ActionEvent event) throws IOException {

        if (isLogin) {
            ///toogle login/signup mode
            isLogin = !isLogin;
            userNameTF.setVisible(!isLogin);
            loginBtn.setLayoutY(350.0);
            loginBtn.setText("login ?");
            signupBtn.setText("Signup");
            signupBtn.setLayoutY(300);
            signupBtn.setPrefWidth(150.0);
            loginBtn.setPrefWidth(100.0);
        } else {
            final String password = passwordTF.getText();
            final String email = emailTF.getText();
            final String userName = userNameTF.getText();
            if (password.isEmpty() || email.isEmpty() || userName.isEmpty()) {
                DialogUtil.getInstance().show("Passowrd, Email, User Name are required", "Error");
                return;
            }
            
            final ArrayList<User> users = userDAO.getUsers();
            for (User user : users) {
                if (email.trim().equals(user.getEmail().toLowerCase())) {
                    DialogUtil.getInstance().show("Email Already taken", "Error");
                    return;
                }
            }
            
              //initialize the Pattern object
         Matcher matcher = pattern.matcher(email);
         if(!matcher.matches()){
           DialogUtil.getInstance().show("Please Enter a Valid Email", "Error");
                return;
         }
         
           if (password.length()<6) {
                    DialogUtil.getInstance().show("Please pick a longer password", "Error");
                    return;
                }
           
           
            final User user = new User(email, password, userName, "user");
            if (userDAO.add(user)) {
                NavigationHelper.getInstance().navigateTo(loginBtn, "home/view/HomeFXML.fxml");

            } else {
                DialogUtil.getInstance().show("Error", "Error");

            }
        }
    }
}
