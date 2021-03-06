package truckingcompanymanagementsystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle edits Andrea 11/11-17/2018
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

    protected void updateRow(String tableName, long primaryKey, String columnName, String newData) {
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

    protected String updateIncoming(int id, String source, String address,
            String city, String state, int zip, int truckID, String departureDate,
            String estArrival, String arrivalConf, int driverID, String paymentConf) {
        sql = "UPDATE incoming_shipping "
                + "SET " + "source_company = " + "'" + source + "', "
                + "address = " + "'" + address + "', "
                + "city = " + "'" + city + "', "
                + "state = " + "'" + state + "', "
                + "zip = " + "'" + zip + "', "
                + "truck_id = " + "'" + truckID + "', "
                + "departure_date_time = " + "'" + departureDate + "', "
                + "estimated_arrival = " + "'" + estArrival + "', "
                + "arrival_confirmation = " + "'" + arrivalConf + "', "
                + "driver_id = " + "'" + driverID + "', "
                + "payment_confirmation = " + "'" + paymentConf + "'"
                + " WHERE order_id = " + id + ";";
        return sql;
    }

    protected String updateOutgoing(int id, String desCompany, String address,
            String city, String state, int zip, int truckID,
            String date, String estimate_arrival, String arrivalConf,
            int driver_id, String payment_confirmation) {
        sql = "UPDATE outgoing_shipping "
                + "SET " + "destination_company = " + "'" + desCompany + "', "
                + "address = " + "'" + address + "', "
                + "city = " + "'" + city + "', "
                + "state = " + "'" + state + "', "
                + "zip = " + "'" + zip + "', "
                + "truck_id = " + "'" + truckID + "', "
                + "departure_date_time = " + "'" + date + "', "
                + "estimated_arrival = " + "'" + estimate_arrival + "', "
                + "arrival_confirmation = " + "'" + arrivalConf + "', "
                + "driver_id = " + "'" + driver_id + "', "
                + "payment_confirmation = " + "'" + payment_confirmation + "'"
                + " WHERE order_id = " + id + ";";
        return sql;
    }

    protected String updateVehicle(int id, String vin, String make, int year,
            String model, int driverID, int availability) {
        sql = "UPDATE vehicle_data "
                + "SET vin = " + "'" + vin + "', "
                + "truck_brand = " + "'" + make + "', "
                + "truck_year = " + "'" + year + "', "
                + "truck_model = " + "'" + model + "', "
                + "driver_id = " + "'" + driverID + "', "
                + "availability = " + "'" + availability + "'"
                + " WHERE truck_id = " + id + ";";
        return sql;
    }

    protected String updateMaintenance(int id, int truckID, String truckVin,
            int maintenanceID, String date, String jobType, String parts,
            String cost, String reportDetails) {
        sql = "UPDATE maintenance_data "
                + "SET " + "truck_id = " + "'" + truckID + "', "
                + "truck_vin = " + "'" + truckVin + "', "
                + "maintenance_id = " + "'" + maintenanceID + "', "
                + "date = " + "'" + date + "', "
                + "job_done = " + "'" + jobType + "', "
                + "parts = " + "'" + parts + "', "
                + "cost = " + "'" + cost + "', "
                + "detailed_report = " + "'" + reportDetails + "'"
                + " WHERE work_order = " + id + ";";
        return sql;
    }

    protected String updatePersonnel(int id, String first, String middle,
            String last, String streetAddr, String city, String state, int zip,
            String homeNum, String cellNum, int years, String position,
            int salary, int payrate, int assignment) {
        sql = "UPDATE Personnel_Data "
                + "SET " + "first_name = " + "'" + first + "', "
                + "middle_name = " + "'" + middle + "', "
                + "last_name = " + "'" + last + "', "
                + "street_address = " + "'" + streetAddr + "', "
                + "city = " + "'" + city + "', "
                + "state = " + "'" + state + "', "
                + "zip = " + "'" + zip + "', "
                + "home_phone_number = " + "'" + homeNum + "', "
                + "cell_phone_number = " + "'" + cellNum + "', "
                + "years_with_company = " + "'" + years + "', "
                + "position = " + "'" + position + "', "
                + "salary = " + "'" + salary + "', "
                + "monthly_pay_rate = " + "'" + payrate + "', "
                + "assignment = " + "'" + assignment + "'"
                + " WHERE employee_id_number = " + id + ";";
        return sql;
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
            int salary, int payrate, int assignment) {
        int access = 0;
        switch (position.toLowerCase()) {
            case "office":
                access = 1;
                break;

            case "shipping":
                access = 2;
                break;
            case "driver":
                access = 3;
                break;
            case "maintenance":
                access = 4;
                break;

        }
        String username = first.charAt(0) + last;
        username = username.toLowerCase();

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
                + "'" + payrate + "', "
                + "'" + assignment + "', "
                + "'" + username + "', "
                + "'pass', "
                + access
                + ");";

        return sql;

    }

    protected String addTruck(String vin, String make, int year,
            String model, int truckID, int driverID, int availability) {
        sql = "INSERT INTO vehicle_data "
                + "VALUES ('" + vin + "', "
                + "'" + make + "', "
                + "'" + year + "', "
                + "'" + model + "', "
                + "'" + truckID + "', "
                + "'" + driverID + "', "
                + "'" + availability + "'"
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
            String state, int zip, int truckID, String departure, String arrival,
            String arrivalConf, int driverID, String paymentConf) {
        arrivalConf = arrivalConf.toLowerCase();
        paymentConf = paymentConf.toLowerCase();
        sql = "INSERT INTO outgoing_shipping "
                + "VALUES (" + orderID + ", '"
                + dest + "', '"
                + addr + "', '"
                + city + "', '"
                + state + "', "
                + zip + ", "
                + truckID + ", '"
                + departure + "', '"
                + arrival + "', '"
                + arrivalConf + "', "
                + driverID + ", '"
                + paymentConf + "');";
        return sql;
    }

    //Andrea 11/11/2018 - had to change parameters to match variables and +"'"+ was missing between variables
    protected String addIncoming(int orderID, String source, String addr, String city,
            String state, int zip, int truck_id, String departure, String arrival, String arrivalConf,
            int driverID, String paymentConf) {
        arrivalConf = arrivalConf.toLowerCase();
        paymentConf = paymentConf.toLowerCase();
        sql = "INSERT INTO incoming_shipping "
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
        return sql;
    }

    protected String incomingArrived(int orderID) {
        sql = "UPDATE incoming_shipping "
                + "SET arrival_confirmation = 'true' "
                + "WHERE order_id = 1139;";
        return sql;

    }

    protected String outgoingArrived(int orderID) {
        sql = "UPDATE outgoing_shipping "
                + "SET arrival_confirmation = 'true' "
                + "WHERE order_id = 1139;";
        return sql;
    }

    protected String addDriverAssignment(int orderID) {
        sql = "UPDATE Personnel_Data "
                + "SET assignment = "
                + orderID
                + " WHERE position = 'Driver' AND assignment = 0 "
                + "ORDER BY assignment ASC LIMIT 1;";
        return sql;
    }

    protected String addVehicleAssignment(int orderID) {
        sql = "UPDATE vehicle_data "
                + "SET `availability` = "
                + orderID
                + " WHERE `availability` = 0 ORDER BY `availability` ASC LIMIT 1; ";
        return sql;
    }

    protected String addDriverToVehicle(int orderID) {
        int driver = 0;
        try {

            ResultSet result = db.getGenericResultSet("SELECT employee_id_number FROM Personnel_Data WHERE assignment = "
                    + orderID + ";");
            while (result.next()) {
                driver = result.getInt("employee_id_number");
            }
            sql = "UPDATE vehicle_data "
                    + "SET `driver_id` = " + driver
                    + " WHERE availability = "
                    + orderID + ";";

            return sql;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    protected String addDriverAndVehicleOutgoing(int orderID) {
        int driver = 0;
        int truck = 0;
        try {
            ResultSet result = db.getGenericResultSet("SELECT driver_id, truck_id FROM vehicle_data WHERE availability = "
                    + orderID + ";");
            while (result.next()) {
                driver = result.getInt("driver_id");
                truck = result.getInt("truck_id");
            }
            sql = "UPDATE outgoing_shipping "
                    + "SET driver_id = " + driver + ", "
                    + "truck_id = " + truck
                    + " WHERE order_id = "
                    + orderID + ";";
            return sql;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    protected String addDriverAndVehicleIncoming(int orderID) {
        int driver = 0;
        int truck = 0;
        try {
            ResultSet result = db.getGenericResultSet("SELECT driver_id, truck_id FROM vehicle_data WHERE availability = "
                    + orderID + ";");
            while (result.next()) {
                driver = result.getInt("driver_id");
                truck = result.getInt("truck_id");
            }

            sql = "UPDATE incoming_shipping "
                    + "SET driver_id = " + driver + ", "
                    + "truck_id = " + truck
                    + " WHERE order_id = "
                    + orderID + ";";
            return sql;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    protected String unassignDriver(int orderID) {
        sql = "UPDATE Personnel_Data "
                + "SET assignment = 0 "
                + "WHERE assignment = "
                + "'" + orderID + "'" + ";";
        return sql;
    }

    protected String unassignTruck(int orderID) {
        sql = "UPDATE vehicle_data "
                + "SET availability = 0, driver_id = 0 "
                + "WHERE availability = "
                + "'" + orderID + "'" + "; ";
        return sql;
    }

}
