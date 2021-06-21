/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Utils.BasicDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Animal;
import models.User;

/**
 *
 * @author obadaJasm
 */
public class AnimalDAO {
    
      public Boolean add(Animal animal) {
        // Clear the previous data
        // Form the query
        String query = "insert into animals (name, gender, birthdate, category_id, weight) values( '"
                + animal.getName() + "','"
                + animal.getGender() +
                "','" + animal.getBirthdate().toString()+
                "','" + animal.getCategoryID()+ 
                "','" + animal.getWeight()+
                "')";
        
        System.out.println(query);
        // Execute the query
        int rows = BasicDB.manipulate(query);
        // Add the new book record to the list
        return rows==1;
    }
   
      
      
       public ArrayList<Animal> getAll() {
        ArrayList<Animal> res = new ArrayList<>();
        // Form the Select * query
        String query = "Select * from animals";
        // Execute the query
        ResultSet result = BasicDB.retrieve(query);
        // Copy the returned result set into the array list
        try {
            while (result.next()) {
                // Form the BookModel object for each returned row
                // The first index of the columns is 1 not 0
               
                // Add the record to the list
                final Animal animal = new Animal(
                        result.getInt(1),
                result.getString(2),
                result.getString(3),
               LocalDate.parse(result.getString(4)) ,
                result.getInt(5),
                result.getInt(6)
                );
                res.add(animal);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
}
