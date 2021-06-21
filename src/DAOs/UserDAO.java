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
    
    //data members
    protected ArrayList<User> data;

    //Constructor
    /**
     * Creates a new instance of the BookDAO class.
     */
    public UserDAO() {
        this.data = new ArrayList<>();
    }

    public ArrayList<User> getData() {
        return this.data;
    }

    //Functionality
    /**
     * Sends a "Select * " query to the DBMS for retrieving books from a certain
     * category/genre.
     *
     * @param category
     * @return
     */
    public boolean retrieve(String category) {
        //Clear the previous data
        this.data.clear();
        //Build the SQL query
        String query = "select * from books where category = '" + category + "'";
        //Execute the query via the BasicDB methods
        ResultSet result = BasicDB.retrieve(query);

        try {
            if (!result.next()) {
                return false;
            }
            do {
                //Copy the returned result set into the array list
                User temp = new User();
                //Form the BookModel object for each returned row
                /*
                temp.setName(result.getString(2)); // The first index of the columns is 1 not 0
                temp.setCategory(result.getString(3));
                temp.setNumOfCopies(result.getInt(4));
                */
                //Add the record to the list
                this.data.add(temp);
            } while (result.next());
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    /**
     * Inserts a new record to the database based on the entered book data from
     * the GUI.
     *
     * @param book
     */
    public Boolean add(User user) {
        // Clear the previous data
        this.data.clear();
        // Form the query
        String query = "insert into users (email, password, name) values( '"
                + user.getEmail() + "','" + user.getPassword() + "','" + user.getName() +"')";
        
        System.out.println(query);
        // Execute the query
        int rows = BasicDB.manipulate(query);
        // Add the new book record to the list
        this.data.add(user);
        return rows==1;
    }

    /**
     * Updates the number of copies of a certain book given its name.
     *
     * @param name
     * @param newCopies
     */
    public void update(String name, int newCopies) {
        //Form the query 
        String query = "update books set copies = " + newCopies + " where name= '" + name + "'";
        //Execute the query 
        int rows = BasicDB.manipulate(query);
    }

    /**
     * Deletes a record from the table based on the book name(title).
     *
     * @param name
     */
    public void delete(String name) {
        //Form the delete query
        String query = "delete from books where name= '" + name + "'";
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
        User temp = new User();
        try {
            while (result.next()) {
                // Form the BookModel object for each returned row
                temp.setEmail(result.getString(2)); // The first index of the columns is 1 not 0
                temp.setPassword(result.getString(3));
                temp.setName(result.getString(4));
                // Add the record to the list
                res.add(temp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
}
