package truckingcompanymanagementsystem;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Andrea
 */
public final class Database {

    private static String url = "jdbc:mysql://tcms.cidg670ru4vm.us-east-1.rds.amazonaws.com:3306/TCMS_Database?useSSL=false";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "masteruser";
    private static String password = "thecakeisalie";
    private static Connection conn;
    private static DataModification dataMod;

    private Database() {
        //constructor
        dataMod = new DataModification();
    }

    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }

    //class to hold the instance of the database so it can be retrieved
    private static class DatabaseHolder {

        private static final Database INSTANCE = new Database();
    }

    //Initialize connection with JDBC
    public void startConnection() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Driver found");
            System.out.println("Connection Established");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection Failed");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Driver not found");
        }
    }

    //Terminate connection wtih JDBC
    public void closeConnection() {
        try {
            //rset.close();
            //stmt.close();
            conn.close();
            System.out.println("Connection Closed");
        } //would put an SQL exception catcher here, but I'm not sure what we are doing with db
        catch (Exception ex) {
            System.out.println("Connection not closed");
        }
    }

    public ResultSet getGenericResultSet(String dataQuery) throws SQLException, NullPointerException {
        ResultSet genericResultSet = null;

        try {
            Statement st = conn.createStatement();
            genericResultSet = st.executeQuery(dataQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return genericResultSet;
    }

    public boolean AddData(String dataQuery) throws SQLException, NullPointerException {
        boolean addDataQuery = false;

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(dataQuery);
            addDataQuery = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Check if you are trying to enter duplicate data.");
        }
        return addDataQuery;
    }

    public boolean DeleteData(String dataQuery) throws SQLException, NullPointerException {
        boolean deleteDataQuery = false;

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(dataQuery);
            deleteDataQuery = true;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deleteDataQuery;
    }

//    for future use
    public boolean EditData(String dataQuery)throws SQLException, NullPointerException
    {
        boolean updateDataQuery = false;

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(dataQuery);
            updateDataQuery = true;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateDataQuery;        
    }
    
    public boolean AllocateOrders(String orderType, int orderID) {
        orderType = orderType.toLowerCase();
        boolean allocated = false;
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(dataMod.addDriverAssignment(orderID));
            stmt.executeUpdate(dataMod.addVehicleAssignment(orderID));
            stmt.executeUpdate(dataMod.addDriverToVehicle(orderID));
            stmt.executeUpdate(dataMod.addDriverAndVehicleIncoming(orderID));
            if (orderType.toLowerCase() == "incoming") {
                stmt.executeUpdate(dataMod.addDriverAndVehicleIncoming(orderID));
            } else if (orderType.toLowerCase() == "outgoing") {
                stmt.executeUpdate(dataMod.addDriverAndVehicleOutgoing(orderID));

            }

            allocated = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allocated;
    }

    public boolean deallocateOrders(String orderType, int orderID) {
        orderType = orderType.toLowerCase();
        boolean deallocated = false;
        try {
            Statement stmt = conn.createStatement();
            if (orderType.equals("incoming_shipping")) {
                stmt.executeUpdate(dataMod.incomingArrived(orderID));
            } else if (orderType.equals("outgoing_shipping")) {
                stmt.executeUpdate(dataMod.outgoingArrived(orderID));
            }
            stmt.executeUpdate(dataMod.unassignDriver(orderID));           
            stmt.executeUpdate(dataMod.unassignTruck(orderID));           
            deallocated = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        }
        return deallocated;
    }

}
