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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class AddCategoryController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private TextField CategoryNameAddTF;
    @FXML
    private TextField CategoryNameDescriptionTF;
    @FXML
    private Button CategoryAddBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddCategoryBtnClick(ActionEvent event) {
        
          
    }

    @FXML
    private void BackBtnClick(ActionEvent event) throws IOException {
        
            Stage stage = (Stage) backBtn.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/HomeFXML.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
    }
    
}
