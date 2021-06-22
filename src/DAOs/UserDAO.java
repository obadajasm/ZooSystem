/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Utils.BasicDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.User;

/**
 *
 * @author obadaJasm
 */
public class UserDAO {
 
    /**
     * Inserts a new record to the database based on the entered book data from
     * the GUI.
     *
     * @param user
     * @param book
     */
    public Boolean add(User user) {
        // Clear the previous data
        // Form the query
        String query = "insert into users (email, password, name) values( '"
                + user.getEmail() + "','" + user.getPassword() + "','" + user.getName() +"')";
        
        System.out.println(query);
        // Execute the query
        int rows = BasicDB.manipulate(query);
        // Add the new book record to the list
        return rows==1;
    }

    

    /**
     * Deletes a record from the table based on the book name(title).
     *
     * @param name
     */
    public void delete(String name) {
        //Form the delete query
        String query = "delete from users where name= '" + name + "'";
        //Execute query
        int rows = BasicDB.manipulate(query);
    }

    /**
     * Retrieves all the stored records in the "books" table.
     *
     * @return
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> res = new ArrayList<>();
        // Form the Select * query
        String query = "Select * from users";
        // Execute the query
        ResultSet result = BasicDB.retrieve(query);
        // Copy the returned result set into the array list
        try {
            while (result.next()) {
                // Form the BookModel object for each returned row
                // The first index of the columns is 1 not 0
               
                // Add the record to the list
                res.add(new User(result.getString(3),result.getString(4),result.getString(2),result.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
}
