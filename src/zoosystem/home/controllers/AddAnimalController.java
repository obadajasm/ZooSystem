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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Animal;
import models.Category;
import models.User;

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
    private Button AnimalAddBtn;
    @FXML
    private HBox hBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField weightTG;
    @FXML
    private TextArea animalDescTA;
    private ToggleGroup toggleGroup;
    @FXML
    private ComboBox<String> categoryDropDownMenu;

    private CategoryDAO categoryDAO = new CategoryDAO();
    private AnimalDAO animalDAO = new AnimalDAO();
    private ArrayList<Category> cats;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        backBtn.requestFocus();
        RadioButton radioButton1 = new RadioButton("male");
        RadioButton radioButton2 = new RadioButton("female");
        radioButton1.setUserData("male");
        radioButton2.setUserData("female");
        toggleGroup = new ToggleGroup();
        hBox.getChildren().addAll(radioButton1, radioButton2);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        radioButton2.setPadding(new Insets(8));
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

//     layoutX="236.0" layoutY="102.0"
//        datePicker.setPromptText(LocalDate.now().toString());
        datePicker.setValue(LocalDate.now());

        radioButton1.setSelected(true);
        cats = categoryDAO.getAll();

        final ArrayList<String> catNames = new ArrayList();
        for (Category cat : cats) {
            catNames.add(cat.getName());
        }
        ObservableList<String> list = FXCollections.observableArrayList(catNames);

        categoryDropDownMenu.setItems(list);
        
        weightTG.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                weightTG.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

    }

    @FXML
    private void AddAnimalBtnClick(ActionEvent event) throws IOException {
        final String name = AnimalNameAddTF.getText();
        final String desc = animalDescTA.getText();
        final LocalDate date = datePicker.getValue();
        final String gendre = toggleGroup.getSelectedToggle().getUserData().toString();
        final String weight = weightTG.getText().trim();

        final String catName = categoryDropDownMenu.getValue();
        int categoryId = -1;
        for (Category cat : cats) {
            if (cat.getName().equals(catName)) {
                categoryId = cat.getID();
                break;
            }
        }
        if (name.isEmpty() || desc.isEmpty() ||date==null || categoryId==-1 ||weight.isEmpty() ) {
            DialogUtil.getInstance().show("All fileds are required", "Error");
            return;
        }
        final Animal animal = new Animal(name, gendre, date, categoryId, Integer.parseInt(weight));
        animalDAO.add(animal);
        AnimalNameAddTF.clear();
        animalDescTA.clear();
        weightTG.clear();

    }

    @FXML
    private void BackBtnClick(ActionEvent event) throws IOException {
        NavigationHelper.getInstance().navigateTo(backBtn, "home/view/HomeFXML.fxml");

    }

    @FXML
    private void datePickerClick(ActionEvent event) {
    }

}
