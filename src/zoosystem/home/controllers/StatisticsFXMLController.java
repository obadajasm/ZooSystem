/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import DAOs.AnimalDAO;
import DAOs.CategoryDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Animal;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class StatisticsFXMLController implements Initializable {

    @FXML
    private Label catNumbers;
    @FXML
    private Label animalNumbers;
    @FXML
    private Label animalSickNumbers;

    private final CategoryDAO categoryDAO = new CategoryDAO();
    private final AnimalDAO animalDAO = new AnimalDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final ArrayList<Animal> animals = animalDAO.getAll();
        
//        animalNumbers.setText(animalNumbers.getText()+" "+animalDAO.size() );
//        animalSickNumbers.setText(animalNumbers.getText()+" "+animalDAO.getsSickAnimalsNumber());
    }    
    
}
