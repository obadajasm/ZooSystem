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
import models.Category;
import models.User;

/**
 *
 * @author obadaJasm
 */
public class CategoryDAO {
    
      public Boolean add(Category category) {
        // Clear the previous data
        // Form the query
        String query = "insert into categories (name, description) values( '"
                + category.getName() + "','"
                + category.getDescription()+
                "')";
        
        // Execute the query
        int rows = BasicDB.manipulate(query);
        // Add the new book record to the list
        return rows==1;
    }
   
      
      
       public ArrayList<Category> getAll() {
        ArrayList<Category> res = new ArrayList<>();
        // Form the Select * query
        String query = "Select * from categories";
        // Execute the query
        ResultSet result = BasicDB.retrieve(query);
        // Copy the returned result set into the array list
        try {
            while (result.next()) {
                final Category category = new Category(
                                                result.getInt(1),

                result.getString(2),
                result.getString(5)
                );
                res.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
}

