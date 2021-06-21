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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.User;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class HomeController implements Initializable {

    @FXML
    private MenuBar MenuBar;
    @FXML
    private Menu moreMenu;
    @FXML
    private MenuItem exiteMenuItem;
    @FXML
    private MenuItem usersMenuItem;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        exiteMenuItem.setOnAction(e -> {
            System.exit(0);
        });
  }

    @FXML
    private void CategoryMenuItemOnClick(ActionEvent event) throws IOException {

        NavigationHelper.getInstance().navigateTo(MenuBar, "home/view/AddCategoryFXML.fxml", "Add Category");
    }

    @FXML
    private void AnimalMenuItemOnClick(ActionEvent event) throws IOException {
        NavigationHelper.getInstance().navigateTo(MenuBar, "home/view/AddAnimalFXML.fxml", "Add Animal");
    }

    @FXML
    private void usersMenuItemOnCLick(ActionEvent event) {
        try {
                NavigationHelper.getInstance().navigateTo(MenuBar, "home/view/UserShowFXML.fxml", "Show users");
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
