/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author justin
 */

public class UserAccounts 
{
    private Database db;
   
    static class User
    {
        static String username;
        static String position;
        static String access_level;
    }
    
    
    
    private boolean userAuthentication(String username, String password) throws SQLException
    {
        
        ResultSet acceptable_username = null;
        String acceptable_username_query = "SELECT users FROM users";
        try
        {
            acceptable_username = db.getGenericResultSet(acceptable_username_query);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(UserAccounts.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        boolean found = false;
        boolean user_authenticated = false;
        
        while(acceptable_username.next())
        {
            if(username == acceptable_username.getString("users"))
            {
                found = true;
                break;
            }
        }
        
        if(found)
        {
            ResultSet acceptable_password = null;
            acceptable_password = db.getGenericResultSet("SELECT pass FROM Passwords WHERE users = '"+username+"'");
            if(password == acceptable_password.getString("passwords"))
            {
                 user_authenticated = true;
            }
        } 
        return user_authenticated;
    }
}
