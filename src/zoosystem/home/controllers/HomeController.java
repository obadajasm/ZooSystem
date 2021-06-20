/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import Utils.NavigationHelper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class HomeController implements Initializable {
    
    @FXML  private MenuBar  MenuBar;
    @FXML
    private Menu moreMenu;
    @FXML
    private MenuItem exiteMenuItem;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                        exiteMenuItem.setOnAction(e->{
                                                System.exit(0)
                                
                                ;});

    }    

    @FXML
    private void CategoryMenuItemOnClick(ActionEvent event) throws IOException {
       
 NavigationHelper.getInstance().navigateTo(MenuBar,"home/view/AddCategoryFXML.fxml","Add Category");
    }

    @FXML
    private void AnimalMenuItemOnClick(ActionEvent event) throws IOException {
       NavigationHelper.getInstance().navigateTo(MenuBar,"home/view/AddAnimalFXML.fxml","Add Animal");
    }
    
    
    
    
}
