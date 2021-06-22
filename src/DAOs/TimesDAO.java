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
import models.Times;

/**
 *
 * @author obadaJasm
 */
public class TimesDAO {
    
      public Times get() {
        // Form the Select * query
        String query = "Select * from times";
          System.out.println(query);
        // Execute the query
        ResultSet result = BasicDB.retrieve(query);
                  System.out.println("ss"+result);

        try {
            while (result.next()) {
                final Times times = new Times(
            result.getString(2),
            result.getString(3)
                );
                return times;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
   public Boolean add(Times time) {
        // Clear the previous data
        // Form the query
        String query = "update times set open_time ="+ "'"+ time.getOpenTime()+"',"+"close_time="+"'"+ time.getCloseTime()+ "'"+"where id=1" ;
        
        System.out.println(query);
        // Execute the query
        int rows = BasicDB.manipulate(query);
        // Add the new book record to the list
        return rows==1;
    }

      
    
}
