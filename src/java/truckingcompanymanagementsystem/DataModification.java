/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;
import java.sql.*;

/**
 *
 * @author Kyle
 */
public class DataModification {
    
    private static Database db;
    private static String sql;
    
    protected DataModification() 
    {
        db = db.getInstance();
    }
    
    protected void updateRowString(String tableName, long primaryKey, String columnName, String newData)
    {
        switch(tableName)
        {
            case "Personnel_Data":
                sql = "UPDATE Personnel_Data "
                        + "SET " + columnName + " = \"" + newData + "\" "
                        + "WHERE employee_id_number = " + primaryKey + ";";
                break;
            case "vehicle_data":
                sql = "UPDATE vehicle_data "
                        + "SET " + columnName + " = \"" + newData + "\" "
                        + "WHERE truck_id = " + primaryKey + ";";
                break;
            case "maintenance_data":
                sql = "UPDATE maintenance_data "
                        + "SET " + columnName + " = \"" + newData + "\" "
                        + "WHERE work_order = " + primaryKey + ";";
                break;
            case "incoming_shipping":
                sql = "UPDATE incoming_shipping "
                        + "SET " + columnName + " = \"" + newData + "\" "
                        + "WHERE order_number = " + primaryKey + ";";
                break;
            case "outgoing_shipping":
                sql = "UPDATE outgoing_shipping "
                        + "SET " + columnName + " = \"" + newData + "\" "
                        + "WHERE order_number = " + primaryKey + ";";
                break;                       
               
        }
    }
    
    protected void updateRowVal(String tableName, long primaryKey, String columnName, long newData)
    {
        switch(tableName)
        {
            case "Personnel_Data":
                sql = "UPDATE Personnel_Data "
                        + "SET " + columnName + " = " + newData  
                        + " WHERE employee_id_number = " + primaryKey + ";";
                break;
            case "vehicle_data":
                sql = "UPDATE vehicle_data "
                        + "SET " + columnName + " = " + newData 
                        + " WHERE truck_id = " + primaryKey + ";";
                break;
            case "maintenance_data":
                sql = "UPDATE maintenance_data "
                        + "SET " + columnName + " = " + newData 
                        + " WHERE work_order = " + primaryKey + ";";
                break;
            case "incoming_shipping":
                sql = "UPDATE incoming_shipping "
                        + "SET " + columnName + " = " + newData 
                        + " WHERE order_number = " + primaryKey + ";";
                break;
            case "outgoing_shipping":
                sql = "UPDATE outgoing_shipping "
                        + "SET " + columnName + " = " + newData 
                        + " WHERE order_number = " + primaryKey + ";";
                break;                       
               
        }
    }
    
    protected String deleteRow(String tableName, long primaryKey)
    {
        switch(tableName)
        {
            case "Personnel_Data":
                sql = "DELETE FROM Personnel_Data WHERE employee_id_number = " + primaryKey + ";";
                break;
            case "vehicle_data":
                sql = "DELETE FROM vehicle_data WHERE truck_id = " + primaryKey + ";";
                break;
            case "maintenance_data":
                sql = "DELETE FROM maintenance_data WHERE work_order = " + primaryKey + ";";
                break;
            case "incoming_shipping":
                sql = "DELTE FROM incoming_shipping WHERE order_id = " + primaryKey + ";";
                break;
            case "outgoing_shipping":
                sql = "DELETE FROM outgoing_shipping WHERE order_id = " + primaryKey + ";";
                break;                       
        }
        return sql;
    }
    
    protected String addPersonnel(int id, String first, String middle, 
            String last, String streetAddr, String city, String state, int zip, 
            String homeNum, String cellNum, int years, String position, 
            int salary, String assignment)
    {
        sql = "INSERT INTO Personnel_Data "
                + "VALUES ('" + id + "', "
                + "'" + first + "', "
                + "'" + middle + "', "
                + "'" + last + "', "
                + "'" + streetAddr + "', "
                + "'" + city + "', "
                + "'" + state + "', "
                + "'" + zip + "', "
                + "'" + homeNum + "', "
                + "'" + cellNum + "', "
                + "'" + years + "', "
                + "'" + position + "', "
                + "'" + salary + "', "
                + "'" + salary / 12 + "', "
                + "'" + assignment + "', "
                + ");";
        
        return sql;
                
    }
    
    protected String addTruck(String vin, String make, String year, 
            String model, String truckID, String driverID)
    {
        sql = "INSERT INTO Personnel_Data "
                + "VALUES ('" + vin + "', "
                + "'" + make + "', "
                + "'" + year + "', "
                + "'" + model + "', "
                + "'" + truckID + "', "
                + "'" + driverID + "', "
                + ");";
        
        return sql;
                
    }
    
}
