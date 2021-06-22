/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import DAOs.AnimalDAO;
import DAOs.CategoryDAO;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Category;

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
    private TextArea CategoryNameDescriptionTF;
    @FXML
    private Button CategoryAddBtn;

    private CategoryDAO categoryDAO = new CategoryDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        System.out.println("S"+new CategoryDAO().getAll().size());
//        System.out.println("S"+ new AnimalDAO().getAll().size());
    }    

    @FXML
    private void AddCategoryBtnClick(ActionEvent event) {
        
           final String name = CategoryNameAddTF.getText();
        final String desc = CategoryNameDescriptionTF.getText();
        
         if(name.isEmpty()||desc.isEmpty()){
            DialogUtil.getInstance().show("Category name and description are required", "Error");
                   return; 
        }
final boolean isDone=                          categoryDAO.add(new Category(name,desc));

if(isDone){
    DialogUtil.getInstance().show("Done", "");
    CategoryNameAddTF.clear();
    CategoryNameDescriptionTF.clear();
}
    }

    @FXML
    private void BackBtnClick(ActionEvent event) throws IOException {
        
               NavigationHelper.getInstance(). goHome(CategoryNameAddTF);

    }
    
}
