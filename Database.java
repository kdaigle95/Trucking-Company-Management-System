/*
 *import java.sql.Statement;
 */
package truckingcompanymanagementsystem;

import java.util.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */

//final keyword makes it act like singleton
//which means it won't inherit to other classes

public final class Database {
    
    static private Connection conn = null;
    
    private Database() {
        
       this.startConnection();
    }
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    //class to hold the instance of the database so it can be retrieved
    private static class DatabaseHolder {

        private static final Database INSTANCE = new Database();
    }
    
    //Initialize connection with JDBC
    public void startConnection()
    {
        //ATTENTION!
        //WE CANNOT USE THIS connectURL FOR PRODUCTION DEPLOYMENT!!!!!!!
        //connect to a local db for first implementation
        String connectURL = "jdbc:mysql://localhost:3306/tcms?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false";
        
        try
        {
            conn = DriverManager.getConnection(connectURL, "user", "pwd3");
            System.out.println("Connection Established");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Connection Failed");
        }
    }
    
    //Terminate connection wtih JDBC
    public void closeConnection()
    {
        //disconnect to a local db for first implementation
        //example disconnect from local db - the ? would be the db
        String connectURL = "jdbc:?://localhost:port/TCMS";
        
        try
        {
            System.out.println("Connection Closed");
            
        }
        //would put an SQL exception catcher here, but I'm not sure what we are doing with db
        catch(Exception e)
        {
            
        }
    
    }
    
    public ResultSet getPersonnel() throws SQLException
    {
        ResultSet personnelData = null;
        
        //create the query
        String employeeQuery = "SELECT * FROM personnel_data";
        
        //create the java statment
        Statement st = null;
        try {
            st = conn.createStatement();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //execute the query, and get the result set
            personnelData = st.executeQuery(employeeQuery);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        //iterate through the java resultset
//        while (personnelData.next())
//        {
//            int id = personnelData.getInt("id");
//            String firstName = personnelData.getString("fisrtName");
//            String middleName = personnelData.getString("middleName");
//            String lastName = personnelData.getString("lastName");
//        }
        
        return personnelData;
    }
}
