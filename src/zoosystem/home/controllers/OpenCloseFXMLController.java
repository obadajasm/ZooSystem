/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoosystem.home.controllers;

import DAOs.TimesDAO;
import Utils.DialogUtil;
import Utils.NavigationHelper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Times;

/**
 * FXML Controller class
 *
 * @author obadaJasm
 */
public class OpenCloseFXMLController implements Initializable {

    @FXML
    private TextField openTimeTF;
    @FXML
    private TextField closeTimeTF;
    @FXML
    private Button addBtn;
    @FXML
    private Button backBtn;

    private TimesDAO timesDAO = new TimesDAO();

    private static String TIME24HOURS_PATTERN
            = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final Times time = timesDAO.get();
        openTimeTF.setText(time.getOpenTime());
        closeTimeTF.setText(time.getCloseTime());
    }

    @FXML
    private void backBtnClick(ActionEvent event) throws IOException {
        NavigationHelper.getInstance().goHome(closeTimeTF);
    }

    @FXML
    private void addBtnClick(ActionEvent event) {
        final String open = openTimeTF.getText().trim();
        final String close = closeTimeTF.getText().trim();

        Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);

        Matcher openTimeMatcher = pattern.matcher(open);
        Matcher closeTimeMatcher = pattern.matcher(close);

        if (!openTimeMatcher.matches() || !closeTimeMatcher.matches()) {
            DialogUtil.getInstance().show("Please ente a valid time ex: 12:53", "Error");
            return;
        }

        timesDAO.add(new Times(open, close));
        DialogUtil.getInstance().show("Done", "");

        openTimeTF.clear();
        closeTimeTF.clear();

    }

}
