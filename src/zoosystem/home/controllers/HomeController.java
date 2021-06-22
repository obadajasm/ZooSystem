/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import DAOs.AnimalDAO;
import DAOs.CategoryDAO;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Animal;
import models.Category;
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
    @FXML
    private TableView<Category> categoryTable;
    @FXML
    private TableView<Animal> animalTable;

    private final CategoryDAO categoryDAO = new CategoryDAO();
    private final AnimalDAO animalDAO = new AnimalDAO();
    @FXML
    private TextField animalSearchTF;
    @FXML
    private TextField catSearchTF;
    @FXML
    private MenuItem StatisticsMI;

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

        final ArrayList<Category> categories = categoryDAO.getAll();
        final ArrayList<Animal> animals = animalDAO.getAll();

        for (Animal animal : animals) {
            for (Category c : categories) {
                if (animal.getCategoryID() == c.getID()) {
                    animal.setCategoryName(c.getName());

                }
            }
        }

        addCategoriesTable(categories);
        addAnimalTable(animals);

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

    private void addCategoriesTable(ArrayList<Category> categories) {

        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn descColumn = new TableColumn("Description");
        descColumn.setCellValueFactory(new PropertyValueFactory("description"));

        nameColumn.setPrefWidth(300);
        descColumn.setPrefWidth(300);

        ObservableList<Category> list = FXCollections.observableArrayList(categories);

        categoryTable.setItems(list);
        categoryTable.getColumns().addAll(nameColumn, descColumn);

        catSearchTF.setOnKeyPressed(e -> {
            ArrayList<Category> temp = new ArrayList();
            final String seatchedText = catSearchTF.getText().toLowerCase().trim();
            for (Category cat : categories) {

                if (cat.getName().toLowerCase().contains(seatchedText)
                        || cat.getDescription().toLowerCase().contains(seatchedText)) {
                    temp.add(cat);
                }
            }
            categoryTable.setItems(FXCollections.observableArrayList(temp));

        });

    }

    private void addAnimalTable(ArrayList<Animal> animals) {

        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn genderColumn = new TableColumn("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory("gender"));

        TableColumn birthdateColumn = new TableColumn("Birthdate");
        birthdateColumn.setCellValueFactory(new PropertyValueFactory("birthdate"));

        TableColumn category_idColumn = new TableColumn("Category");
        category_idColumn.setCellValueFactory(new PropertyValueFactory("categoryName"));

        TableColumn weightColumn = new TableColumn("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory("weight"));
        
            TableColumn isSickColumn = new TableColumn("Is Sick?");
        isSickColumn.setCellValueFactory(new PropertyValueFactory("isSick"));

        nameColumn.setPrefWidth(200);
        genderColumn.setPrefWidth(80);
        birthdateColumn.setPrefWidth(100);
        category_idColumn.setPrefWidth(150);
        weightColumn.setPrefWidth(80);

        ObservableList<Animal> list = FXCollections.observableArrayList(animals);

        animalTable.setItems(list);
        animalTable.getColumns().addAll(nameColumn, genderColumn, birthdateColumn, category_idColumn, weightColumn,isSickColumn);

        animalSearchTF.setOnKeyPressed(e -> {
            ArrayList<Animal> temp = new ArrayList();
            final String seatchedText = animalSearchTF.getText().toLowerCase().trim();
            for (Animal animal : animals) {

                if (animal.getName().toLowerCase().contains(seatchedText)
                        || animal.getCategoryName().toLowerCase().contains(seatchedText)) {
                    temp.add(animal);
                }
            }
            animalTable.setItems(FXCollections.observableArrayList(temp));

        });

    }

    @FXML
    private void StatisticsMIClick(ActionEvent event) throws IOException {
                    NavigationHelper.getInstance().navigateTo(MenuBar, "home/view/StatisticsFXML.fxml", "Show users");

        
    }

    @FXML
    private void openCloseTimeOnClick(ActionEvent event) throws IOException {
         NavigationHelper.getInstance().navigateTo(MenuBar, "home/view/openCloseFXML.fxml", "Show users");

        
    }
}
