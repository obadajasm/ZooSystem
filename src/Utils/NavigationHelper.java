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
    private static  NavigationHelper instance;
    private NavigationHelper(){};
    public static NavigationHelper getInstance(){
    if(instance==null){
        instance= new NavigationHelper();
    }
    return instance;
    } 
    public void navigateTo(Node node,String path,String title) throws IOException{
        
        try{
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/zoosystem/"+path));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e ){
            System.out.println("Error in navigate to:"+e.getMessage());
            }
    }
    ///overload the navigateTo to pass the last param
    //to make it optional
      public  void navigateTo(Node node,String path) throws IOException{
        
        try{
        navigateTo(node,path,"Zoo System");
        }catch(IOException e ){
            System.out.println("Error in navigate to:"+e.getMessage());
            }
    }
    
}
