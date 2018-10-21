/*
 *import java.sql.Statement;
 */

package truckingcompanymanagementsystem;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */

//final keyword makes it act like singleton
//which means it won't inherit to other classes

public final class Database 
{
    
    private static String url = "jdbc:mysql://tcms.cidg670ru4vm.us-east-1.rds.amazonaws.com:3306/TCMS_Database?useSSL=false";
    //private static String localUrl = "jdbc:mysql://localhost:3306/tcms?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "masteruser";
    private static String password = "thecakeisalie";
    private static Connection conn;
    
    
    private Database() 
    {    
       this.startConnection();
    }
    
    public static Database getInstance() 
    {
        return DatabaseHolder.INSTANCE;
    }
    
    //class to hold the instance of the database so it can be retrieved
    private static class DatabaseHolder 
    { 
        private static final Database INSTANCE = new Database();
    }
    
    //Initialize connection with JDBC
    public void startConnection()
    {
        //ATTENTION!
        //WE CANNOT USE THIS connectURL FOR PRODUCTION DEPLOYMENT!!!!!!!
        //connect to a local db for first implementation
        
        try
        {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Driver found");
            System.out.println("Connection Established");
        }
        
        catch(SQLException ex)
        {
            ex.printStackTrace();
            System.out.println("Connection Failed");
        }
        
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
            System.out.println("Driver not found");
        }
    }
    
    //Terminate connection wtih JDBC
    public void closeConnection()
    {
        
        try
        {
            //rset.close();
            //stmt.close();
            conn.close();
            System.out.println("Connection Closed");
            
        }
        //would put an SQL exception catcher here, but I'm not sure what we are doing with db
        catch(Exception ex)
        {
            System.out.println("Connection not closed");
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
