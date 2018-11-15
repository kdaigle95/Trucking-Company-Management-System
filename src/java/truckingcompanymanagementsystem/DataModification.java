package truckingcompanymanagementsystem;

import java.sql.*;

/**
 *
 * @author Kyle
 * edits Andrea 11/11-14/2018
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
                sql = "DELETE FROM incoming_shipping WHERE order_id = " + primaryKey + ";";
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
            int salary, int payrate, String assignment) {
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
//illegal expression - SQL is not turing complete language                
//+ "'" + salary / 12 + "', "
                + "'" + payrate +"', "
                + "'" + assignment +"'"
                + ");";

        return sql;

    }
  
    protected String addTruck(String vin, String make, int year,
            String model, int truckID, int driverID, int availability, String partsList) {
        sql = "INSERT INTO vehicle_data "
                + "VALUES ('" + vin + "', "
                + "'" + make + "', "
                + "'" + year + "', "
                + "'" + model + "', "
                + "'" + truckID + "', "
                + "'" + driverID + "', "
                + "'" + availability + "', "
                + "'" + partsList +"'"
                + ");";

        return sql;

    }

    protected String addMaintenance(int workOrder, int truckID, String truckVin,
            int maintID, String date, String job, String parts, String cost, String desc) {
        sql = "INSERT INTO maintenance_data "
                + "VALUES ('" + workOrder + "', "
                + "'" + truckID + "', "
                + "'" + truckVin + "', "
                + "'" + maintID + "', "
                + "'" + date + "', "
                + "'" + job + "', "
                + "'" + parts + "', "
                + "'" + cost + "', "
                + "'" + desc + "');";
        return sql;
    }

    protected String addOutgoing(int orderID, String dest, String addr, String city,
            String state, int zip, int truckID, String departure, String arrival, String arrivalConf,
            int driverID, String paymentConf) {
        sql = "INSERT INTO outgoing_shipping (order_id, destination_company, "
                + "address, city, state, zip, truck_id, departure_date_time, estimated_arrival,"
                + "arrival_confirmation, driver_id, payment_confirmation) "
                + "VALUES ('" + orderID + "', "
                + "'" + dest + "', "
                + "'" + addr + "', "
                + "'" + city + "', "
                + "'" + state + "', "
                + "'" + zip + "', "
                + "'" + truckID + "', "
                + "'" + departure + "', "
                + "'" + arrival + "', "
                + "'" + arrivalConf + "', "
                + "'" + driverID + "', "
                + "'" + paymentConf + "')";
//                + "\n"
//                + "UPDATE Personnel_Data"
//                + "SET assignment = "
//                + orderID
//                + "WHERE position = 'Driver' AND assignment = 0 "
//                + "ORDER BY assignment ASC LIMIT 1;"
//                + "\n"
//                + "UPDATE vehicle_data "
//                + "SET `availability` = "
//                + orderID
//                + "WHERE `availability` = 0 ORDER BY `availability` ASC LIMIT 1;"
//                + "\n"
//                + "UPDATE vehicle_data "
//                + "SET `driver_id` = (SELECT employee_id_number FROM Personnel_Data WHERE assignment = "
//                + orderID
//                + "WHERE EXISTS (SELECT assignment FROM Personnel_Data WHERE assignment = "
//                + orderID + ") AND availability = "
//                + orderID + ";"
//                + "\n"
//                + "UPDATE outgoing_shipping"
//                + "SET driver_id = (SELECT driver_id FROM vehicle_data WHERE availability = "
//                + orderID + "), "
//                + "truck_id = (SELECT truck_id FROM vehicle_data WHERE availability = "
//                + orderID + ")"
//                + "WHERE order_id = "
//                + orderID + ";";
        return sql;
    }

    //Andrea 11/11/2018 - had to change parameters to match variables and +"'"+ was missing between variables
    protected String addIncoming(int orderID, String source, String addr, String city,
            String state, int zip, int truck_id, String departure, String arrival, String arrivalConf, 
            int driverID, String paymentConf) {
        sql = "INSERT INTO incoming_shipping (order_id, source_company, "
                + "address, city, state, zip, truck_id, departure_date_time, estimated_arrival, "
                + "arrival_confirmation, driver_id, payment_confirmation) "
                + "VALUES ('" + orderID + "', "
                + "'" + source + "', "
                + "'" + addr + "', "
                + "'" + city + "', "
                + "'" + state + "', "
                + "'" + zip + "', "
                + "'" + truck_id + "', "
                + "'" + departure + "', "
                + "'" + arrival + "', "
                + "'" + arrivalConf + "', "
                + "'" + driverID + "', "
                + "'" + paymentConf + "')";      
//                 + "\n"
//                 + "UPDATE Personnel_Data"
//                 + "SET assignment = "
//                 + orderID
//                 + "WHERE position = 'Driver' AND assignment = 0 "
//                 + "ORDER BY assignment ASC LIMIT 1;"
//                 + "\n"
//                 + "UPDATE vehicle_data "
//                 + "SET `availability` = "
//                 + orderID
//                 + "WHERE `availability` = 0 ORDER BY `availability` ASC LIMIT 1;"
//                 + "\n"
//                 + "UPDATE vehicle_data "
//                 + "SET `driver_id` = (SELECT employee_id_number FROM Personnel_Data WHERE assignment = "
//                 + orderID
//                 + "WHERE EXISTS (SELECT assignment FROM Personnel_Data WHERE assignment = "
//                 + orderID + ") AND availability = "
//                 + orderID + ";"
//                 + "\n"
//                 + "UPDATE outgoing_shipping"
//                 + "SET driver_id = (SELECT driver_id FROM vehicle_data WHERE availability = "
//                 + orderID + "), "
//                 + "truck_id = (SELECT truck_id FROM vehicle_data WHERE availability = "
//                 + orderID + ")"
//                 + "WHERE order_id = "
//                 + orderID + ";";
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

}
