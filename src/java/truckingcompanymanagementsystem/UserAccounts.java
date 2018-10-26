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
     
    private Database db;
    
    static class User
    {
        static String username;
        static String position;
        static String access_level;
    }
    
    
    
    public boolean userAuthentication(String username, String password)
    {
        
        ResultSet acceptable_username = null;
        String acceptable_username_query = "SELECT users FROM users";
        String url = "jdbc:mysql://tcms.cidg670ru4vm.us-east-1.rds.amazonaws.com:3306/TCMS_Database?useSSL=false";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String connectionusername = "masteruser";
        String connectionpassword = "thecakeisalie";
        Connection conn = null;
        try
        {
           
           
            Class.forName(driverName);
            conn = DriverManager.getConnection(url,connectionusername,connectionpassword);
            Statement st = conn.createStatement();
            acceptable_username = st.executeQuery(acceptable_username_query);


            //acceptable_username = db.getGenericResultSet(acceptable_username_query);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(UserAccounts.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch(ClassNotFoundException ex)
        {
            
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
            Statement st = conn.createStatement();
            acceptable_password = st.executeQuery("SELECT passwords FROM users WHERE users = '"+username+"'");   
            //acceptable_password = db.getGenericResultSet("SELECT pass FROM Passwords WHERE users = '"+username+"'");
            while(acceptable_password.next())
            {
                System.out.println(password);
                System.out.println();
                System.out.println(acceptable_password);
                String database_password = acceptable_password.getString("passwords");
                if(password.equals(database_password))
                {
                    user_authenticated = true;
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
