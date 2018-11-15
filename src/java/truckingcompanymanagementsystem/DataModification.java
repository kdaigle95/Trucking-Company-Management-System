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

    protected DataModification() {
        db = db.getInstance();
    }

    protected void updateRowString(String tableName, long primaryKey, String columnName, String newData) {
        switch (tableName) {
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

    protected void updateRowVal(String tableName, int primaryKey, String columnName, int newData) {
        switch (tableName) {
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

    protected String deleteRow(String tableName, long primaryKey) {
        switch (tableName) {
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
            int salary, String assignment) {
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
                + "'" + assignment
                + ");";

        return sql;

    }

    protected String addTruck(String vin, String make, String year,
            String model, String truckID, String driverID, String partsList) {
        sql = "INSERT INTO vehicle_data "
                + "VALUES ('" + vin + "', "
                + "'" + make + "', "
                + "'" + year + "', "
                + "'" + model + "', "
                + "'" + truckID + "', "
                + "'" + driverID + "', "
                + "'" + partsList
                + ");";

        return sql;

    }

    protected String addMaintenance(int workOrder, int truckID, String truckVin,
            int maintID, String date, String job, String parts, String cost, String desc) {
        sql = "INSERT INTO maintenance_data "
                + "VALUES (" + workOrder + ", "
                + truckID + ", '"
                + truckVin + "', "
                + maintID + ", '"
                + date + "', '"
                + job + "', '"
                + parts + "', '"
                + cost + "', '"
                + desc + ");";
        return sql;
    }

    protected String addOutgoing(int orderID, String dest, String addr, String city,
            String state, int zip, String departure, String arrival, String arrivalConf,
            String paymentConf) {
        arrivalConf = arrivalConf.toLowerCase();
        paymentConf = paymentConf.toLowerCase();
        sql = "INSERT INTO outgoing_shipping (order_id, destination_company, "
                + "address, city, state, zip, departure_date_time, estimated_arrival,"
                + "arrival_confirmation, payment_confirmation) "
                + "VALUES (" + orderID + ", '"
                + dest + "', '"
                + addr + "', '"
                + state + "', "
                + zip + ", '"
                + departure + "', '"
                + arrival + "', '"
                + arrivalConf + "', '"
                + paymentConf + "');";
        return sql;
    }

    protected String addIncoming(int orderID, String dest, String addr, String city,
            String state, int zip, String departure, String arrival, String arrivalConf,
            String paymentConf) {
        arrivalConf = arrivalConf.toLowerCase();
        paymentConf = paymentConf.toLowerCase();
        sql = "INSERT INTO incoming_shipping (order_id, source_company, "
                + "address, city, state, zip, departure_date_time, estimated_arrival, "
                + "arrival_confirmation, payment_confirmation) "
                + "VALUES (" + orderID + ", '"
                + dest + "', '"
                + addr + "', '"
                + state + "', "
                + zip + ", '"
                + departure + "', '"
                + arrival + "', '"
                + arrivalConf + "', '"
                + paymentConf + "'); ";
        return sql;
    }

    protected String incomingArrived(int orderID) {
        sql = "UPDATE incoming_shipping "
                + "SET arrival_confirmation = 'true' "
                + "WHERE order_id = 1139;"
                + "\n"
                + "UPDATE vehicle_data "
                + "SET availability = 0, driver_id = 0 "
                + "WHERE availability = 1139; "
                + "\n"
                + "UPDATE Personnel_Data "
                + "SET assignment = 0 "
                + "WHERE assignment = "
                + orderID + ";";
        return sql;

    }
    
    protected String outgoingArrived(int orderID)
    {
        sql = "UPDATE outgoing_shipping "
                + "SET arrival_confirmation = 'true' "
                + "WHERE order_id = 1139;"
                + "\n"
                + "UPDATE vehicle_data "
                + "SET availability = 0, driver_id = 0 "
                + "WHERE availability = 1139; "
                + "\n"
                + "UPDATE Personnel_Data "
                + "SET assignment = 0 "
                + "WHERE assignment = "
                + orderID + ";";
        return sql;
    }
    
    protected String addDriverAssignment(int orderID)
    {
        sql = "UPDATE Personnel_Data"
                + "SET assignment = "
                + orderID
                + " WHERE position = 'Driver' AND assignment = 0 "
                + "ORDER BY assignment ASC LIMIT 1;";
                return sql;
    }
    
    protected String addVehicleAssignment(int orderID)
    {
        sql = "UPDATE vehicle_data "
                + "SET `availability` = "
                + orderID
                + "WHERE `availability` = 0 ORDER BY `availability` ASC LIMIT 1; ";
        return sql;
    }
    
    protected String addDriverToVehicle(int orderID)
    {
        sql = "UPDATE vehicle_data "
                + "SET `driver_id` = (SELECT employee_id_number FROM Personnel_Data WHERE assignment = "
                + orderID
                + "WHERE EXISTS (SELECT assignment FROM Personnel_Data WHERE assignment = "
                + orderID + ") AND availability = "
                + orderID + ";";
        return sql;
    }
    
    protected String addDriverAndVehicleOutgoing(int orderID)
    {
        sql = "UPDATE outgoing_shipping"
                + "SET driver_id = (SELECT driver_id FROM vehicle_data WHERE availability = "
                + orderID + "), "
                + "truck_id = (SELECT truck_id FROM vehicle_data WHERE availability = "
                + orderID + ")"
                + "WHERE order_id = "
                + orderID + ";";
        return sql;
    }
    
    protected String addDriverAndVehicleIncoming(int orderID)
    {
        sql = "UPDATE incoming_shipping "
                + "SET driver_id = (SELECT driver_id FROM vehicle_data WHERE availability = "
                + orderID + "), "
                + "truck_id = (SELECT truck_id FROM vehicle_data WHERE availability = "
                + orderID + ")"
                + "WHERE order_id = "
                + orderID + ";";
        return sql;
    }

}
