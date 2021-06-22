/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import DAOs.UserDAO;
import Utils.NavigationHelper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import models.User;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class UserShowFXMLController implements Initializable {

    @FXML
    private TableView<User> userTableView;
    @FXML
    private TextField searchTF;
   private ArrayList<User> users;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        users = new UserDAO().getUsers();

        TableColumn emailColumn = new TableColumn("email");
        emailColumn.setCellValueFactory(new PropertyValueFactory("email"));

        TableColumn userColumn = new TableColumn("name");
        userColumn.setCellValueFactory(new PropertyValueFactory("name"));

        emailColumn.setPrefWidth(200);
        userColumn.setPrefWidth(200);

        ObservableList<User> list = FXCollections.observableArrayList(users);
        
      
        userTableView.setItems(list);
        userTableView.getColumns().addAll(emailColumn, userColumn);
        
        backBtn.setOnAction(e->{
          try {
                NavigationHelper.getInstance().goHome(userTableView);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }

    @FXML
    private void searchTFKeyPressed(KeyEvent event) {
        System.out.println("ss"+searchTF.getText());
        ArrayList<User> temp = new ArrayList();
        final String seatchedText=searchTF.getText().toLowerCase().trim();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(seatchedText)
                    || user.getEmail().toLowerCase().contains(seatchedText)) {
                temp.add(user);
            }
        }
        userTableView.setItems(FXCollections.observableArrayList(temp));
    }

}
