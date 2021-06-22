/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.homevisitor.controllers;

import DAOs.AnimalDAO;
import DAOs.CategoryDAO;
import DAOs.TimesDAO;
import Utils.DialogUtil;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Animal;
import models.Category;
import models.Times;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class HomeVisitorFXMLController implements Initializable {

    @FXML
    private ComboBox<String> catComboBox;
    @FXML
    private Button checkBtn;
    private final CategoryDAO categoryDAO = new CategoryDAO();
    private final AnimalDAO animalDAO = new AnimalDAO();
    private final TimesDAO timesDAO = new TimesDAO();
    @FXML
    private AnchorPane animalShowList;
    @FXML
    private ScrollPane scrollPane;
    final ArrayList<Category> cats = categoryDAO.getAll();
    final ArrayList<Animal> animals = animalDAO.getAll();
    @FXML
    private HBox hBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final ArrayList<String> catNames = new ArrayList<>();

        for (Category cat : cats) {
            catNames.add(cat.getName());
        }
        catComboBox.setItems(FXCollections.observableArrayList(catNames));
    

    }

    @FXML
    private void catComboBoxonActon(ActionEvent event) {

        int catId = -1;

        for (Category cat : cats) {

            if (cat.getName().equals(catComboBox.getValue())) {
                catId = cat.getID();
                break;
            }
        }

        System.out.println("SS" + catId);
        final ArrayList<Animal> animals = animalDAO.getAllByCatID(catId);
        System.out.println("SS" + animals.size());

        VBox vbox = new VBox();
        int i = 1;
        for (Animal animal : animals) {
            Label label = new Label(animal.getName());
            label.setTranslateX(50);
            label.setTranslateY((i * 10) + 50);
            vbox.getChildren().add(label);
            i++;

        }

        scrollPane.setContent(vbox);
    }

    @FXML
    private void checkBtnnActon(ActionEvent event) {

        final Times time = timesDAO.get();

        Date date = new Date();

        final int currentHour = (date.getHours());
        final int currentMin = (date.getMinutes());
        Boolean isOpen;
        final int openHour = Integer.parseInt(time.getOpenTime().split(":")[0]);
        final int openMin = Integer.parseInt(time.getOpenTime().split(":")[1]);
        final int closeHour = Integer.parseInt(time.getCloseTime().split(":")[0]);
        final int closeMin = Integer.parseInt(time.getCloseTime().split(":")[1]);

        if ((currentHour > openHour) && (currentHour < closeHour)
                || (currentHour == openHour && currentMin >= openMin)
                || (currentHour == closeHour && currentMin <= closeHour)) {
            //open
            isOpen = true;
        } else {
            isOpen = false;

        }
        DialogUtil.getInstance().show(isOpen ? "OPEN" : "CLOSE", "Info");

    }

}
