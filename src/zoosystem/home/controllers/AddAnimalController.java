/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import Utils.DialogUtil;
import Utils.NavigationHelper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class AddAnimalController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private TextField AnimalNameAddTF;
    @FXML
    private TextField AnimalNameDescriptionTF;
    @FXML
    private Button AnimalAddBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddAnimalBtnClick(ActionEvent event) throws IOException {
        final String name = AnimalNameAddTF.getText();
        final String desc = AnimalNameDescriptionTF.getText();
        
         if(name.isEmpty()||desc.isEmpty()){
            DialogUtil.getInstance().show("Animal name and description are required", "Error");
                   return; 
        }
        
       
    }

    @FXML
    private void BackBtnClick(ActionEvent event) throws IOException {
        NavigationHelper.getInstance().navigateTo(backBtn,"home/view/HomeFXML.fxml");

    }
    
}
