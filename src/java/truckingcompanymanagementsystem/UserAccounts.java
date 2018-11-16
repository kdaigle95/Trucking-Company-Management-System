/*
 * 
 */
package truckingcompanymanagementsystem;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justin
 */

public class UserAccounts 
{
    
    private UserAccounts()
    {
        //constructor
    }
    
    public static UserAccounts getInstance() 
    {
        return UserAccountsHolder.INSTANCE;
    }
    
    
     private static class UserAccountsHolder 
    { 
        private static final UserAccounts INSTANCE = new UserAccounts();
    }
     

    Database connection = Database.getInstance();
    

    static String stored_username;
    static String position;
    static String access_level;
    static boolean has_logged_in = false;
        
    public boolean gethas_logged_in()
    {
        return this.has_logged_in;
    }
        
    
    
    
    
    public boolean userAuthentication(String username, String password)
    {
        //User CurrentUser = new User();
        ResultSet acceptable_username = null;
        String acceptable_username_query = "SELECT users FROM users";
        try
        {
            connection.startConnection();
            acceptable_username = connection.getGenericResultSet(acceptable_username_query);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(UserAccounts.class.getName()).log(Level.SEVERE,null,ex);
        }

        boolean found = false;
        boolean user_authenticated = false;
        
        try
        {
        while(acceptable_username.next())
        {
            String database_username = acceptable_username.getString("users");            
            
            if(username.equals(database_username))
            {
                found = true;
                break;
            }
        }
        
        if(found)
        {
            
            ResultSet acceptable_password = null;   
            acceptable_password = connection.getGenericResultSet("SELECT passwords FROM users WHERE users = '"+username+"'");
            while(acceptable_password.next())
            {
                String database_password = acceptable_password.getString("passwords");
                if(password.equals(database_password))
                {
                    user_authenticated = true;
                    has_logged_in = true;
                    stored_username = username;
                    switch(stored_username)
                    {
                        case "masterTest":
                            
                            access_level = "full";
                            break;
                            
                        case "shippingTest":
                            access_level = "shipping";
                            break;
                            
                        case "maintTest":
                            access_level = "maint";
                            break;
                            
                        case "truckTest":
                            access_level = "driver";
                            break;
                    }
                }
            }
          
        } 
        
        }
        catch(SQLException ex)
        {
            Logger.getLogger(UserAccounts.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return user_authenticated;
    }
    
    
    
    
}
