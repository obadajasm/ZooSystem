/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class HomeController implements Initializable {
    
    @FXML  private MenuBar  MenuBar;
    @FXML
    private Menu ExitMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                        
                        ExitMenu.setOnAction(e->{
                        
                        System.exit(0)
                                
                                ;});

    }    

    @FXML
    private void CategoryMenuItemOnClick(ActionEvent event) throws IOException {
        
                Stage stage = (Stage) MenuBar.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddCategoryFXML.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Add Category");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void AnimalMenuItemOnClick(ActionEvent event) throws IOException {
           Stage stage = (Stage) MenuBar.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddAnimalFXML.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Add Animal");
            stage.setScene(scene);
            stage.show();
    }
    
    
    
    
}
