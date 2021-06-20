/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author obadaJasm
 */
public class DialogUtil {

    private static DialogUtil instance;

    private DialogUtil() {};
    
    public static DialogUtil getInstance() {
        if (instance == null) {
            instance = new DialogUtil();
        }
        return instance;
    }

    public  void show(Alert.AlertType type, String contentText,   String title,ButtonType... buttons) {
        Alert alert = new Alert(type, contentText, buttons);
        alert.setTitle(title);
        alert.show();
    }

    public  void show(String contentText,String title, ButtonType... buttons) {
     show( Alert.AlertType.NONE,contentText,title, buttons);
    }

    public  void show(String contentText,String title ) {
             show( Alert.AlertType.NONE,contentText,title,ButtonType.YES);

    }

}
