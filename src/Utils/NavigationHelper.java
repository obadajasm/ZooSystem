/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author obadaJasm
 */
public class NavigationHelper {
    
    public  void navigateTo(Node node,String path,String title) throws IOException{
        
        try{
           Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/zoosystem/"+path));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();}catch(Exception e ){
            System.out.println("Error in navigate to:"+e.getMessage());
            }
    }
    
      public  void navigateTo(Node node,String path) throws IOException{
        
        try{
        navigateTo(node,path,"Zoo Sysytem");
        }catch(IOException e ){
            System.out.println("Error in navigate to:"+e.getMessage());
            }
    }
    
}
