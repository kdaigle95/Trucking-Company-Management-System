/*
 *import java.sql.Statement;
 */

package truckingcompanymanagementsystem;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

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
        //constructor
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
        try
        {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url,username,password);
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
    
    public ResultSet getGenericResultSet(String dataQuery) throws SQLException, NullPointerException
    {
        ResultSet genericResultSet = null;
        
        try {           
            Statement st = conn.createStatement();
            genericResultSet = st.executeQuery(dataQuery);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return genericResultSet;
    }
    
    public boolean AddData(String dataQuery) throws SQLException, NullPointerException
    {
        boolean addDataQuery = false;
        
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(dataQuery);
            addDataQuery = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Check if you are trying to enter duplicate data.");
        }
        return addDataQuery;
    }
    
    public boolean DeleteData(String dataQuery) throws SQLException, NullPointerException
    {
        boolean deleteDataQuery = false;
        
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(dataQuery);
            deleteDataQuery = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deleteDataQuery;
    }
}
