/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import DAOs.UserDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    ArrayList<User> users;

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

        searchTF.setOnInputMethodTextChanged(e -> {
            System.out.println("sss" + searchTF.getText());

        });
    }

    @FXML
    private void searchTFKeyPressed(KeyEvent event) {
        System.out.println("ssfz" + searchTF.getText());
        ArrayList<User> temp = new ArrayList();

        for (User user : users) {

            if (user.getName().toLowerCase().contains(searchTF.getText().toLowerCase().trim())
                    || user.getEmail().toLowerCase().contains(searchTF.getText().toLowerCase().trim())) {
                temp.add(user);

            }
        }

        userTableView.setItems(FXCollections.observableArrayList(temp));

    }

}
