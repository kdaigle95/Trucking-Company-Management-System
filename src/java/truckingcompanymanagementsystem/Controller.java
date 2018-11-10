/*
 * 
 */
package truckingcompanymanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 * @author Andrea
 */
public final class Controller {
    
    private Database db;
  
    //create the arraylist
    private ArrayList<Personnel> m_DataResultsArray = new ArrayList<>();
    private ArrayList<IncomingShipping> m_IncomingShippingDataArray = new ArrayList<>();
    private ArrayList<OutgoingShipping> m_OutgoingShippingDataArray = new ArrayList<>();
    private ArrayList<Vehicle> m_VehicleDataArray = new ArrayList<>();
    private ArrayList<Maintenance> m_MaintenanceDataArray = new ArrayList<>();
  
    private UserAccounts ua;
    private ResourceAllocation ra;
   

    
    private Controller ()
    {  
        this.getDatabase();
        this.startDatabase();
        //use a logging library in future
        System.out.println("Controller Created - Connection established");

    }
    
    public static Controller getInstance(){
        return ControllerHolder.INSTANCE;
    }
    
    //class to hold the instance of the controller so it can be retrieved
    private static class ControllerHolder{
        private static final Controller INSTANCE = new Controller();
        
    }
    
    public void getDatabase()
    {
        this.db = Database.getInstance();
        System.out.println("got the db");
    }
    
    public void startDatabase()
    {
        db.startConnection();
        System.out.println("started connection");

    }
    
     public void getResourceAllocation()
    {
        this.ra = ResourceAllocation.getInstance();
        System.out.println("got the ra");
    }
    
    public UserAccounts getUserAccounts()
    {
        this.ua = UserAccounts.getInstance();
        System.out.println("got the ua");
        return ua;
    }
    
    
    /////////////////////////////////////
    // Data Queries
    ////////////////////////////////////
    
    //___________________________________________________
    //Personnel Data Query
    //___________________________________________________
    public void GetPersonnelData() throws SQLException{
        
        ResultSet personnelData = null;
        //create the query for the whole table (wildcard)
        String employeeQuery = "SELECT * FROM Personnel_Data";
       
        try {
            personnelData = db.getGenericResultSet(employeeQuery);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        //converting results set into an array list
        while(personnelData.next()){
            
            m_DataResultsArray.add(PersonnelFactory.getPersonnelFactory().createPersonnel(
                    
                    personnelData.getString("employee_id_number"),
                    personnelData.getString("first_name"),
                    personnelData.getString("middle_name"),
                    personnelData.getString("last_name"),
                    personnelData.getString("street_address"),
                    personnelData.getString("city"),
                    personnelData.getString("state"),
                    personnelData.getInt("zip"),
                    personnelData.getString("home_phone_number"),
                    personnelData.getString("cell_phone_number"),
                    personnelData.getInt("years_with_company"),
                    personnelData.getString("position"),
                    personnelData.getInt("salary"),
                    personnelData.getInt("monthly_pay_rate"),
                    personnelData.getString("assignment")
                  
            ));
            
        }
       
    }
    
    //method to get the arraylist out of controller
    public ArrayList<Personnel> getPersonnelList(){
        return m_DataResultsArray;
    }
    
   
    //___________________________________________________
    //IncomingShipping Data Query
    //___________________________________________________

    public void GetIncomingShippingData() throws SQLException{
        
        ResultSet incomingShippingData = null;
        //create the query for the whole table
        String incomingshippingQuery = "SELECT * FROM TCMS_Database.incoming_shipping";
        
        try{
            incomingShippingData = db.getGenericResultSet(incomingshippingQuery);
        }
        catch(SQLException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //while through all the rows
        while(incomingShippingData.next()){
        
            m_IncomingShippingDataArray.add(IncomingShippingFactory.getIncomingShippingFactory().createIncomingShipping(
                incomingShippingData.getInt("order_id"),
                incomingShippingData.getString("source_company"),
                incomingShippingData.getString("address"),
                incomingShippingData.getString("city"),
                incomingShippingData.getString("state"),
                incomingShippingData.getInt("zip"),
                incomingShippingData.getString("truck_id"),
                incomingShippingData.getString("departure_date_time"),
                incomingShippingData.getString("estimated_arrival"),
                incomingShippingData.getString("arrival_confirmation"),
                incomingShippingData.getInt("driver_id"),
                incomingShippingData.getString("payment_confirmation")
            ));
            
        }
    }
    
    //method to get the arraylist out of controller
    public ArrayList<IncomingShipping> getIncomingShippingList(){
        return m_IncomingShippingDataArray;
    }
    
    
   //___________________________________________________
    //OutgoingShipping Data Query
    //___________________________________________________
   public void GetOutgoingShippingData() throws SQLException{
        
        ResultSet outgoingShippingData = null;
        //create the query for the whole table (wildcard)
        String outgoingshippingQuery = "SELECT * FROM TCMS_Database.outgoing_shipping";
       
        try {
            outgoingShippingData = db.getGenericResultSet(outgoingshippingQuery);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     

        //converting results set into an array list
        while(outgoingShippingData.next()){
     
            m_OutgoingShippingDataArray.add(OutgoingShippingFactory.getOutgoingShippingFactory().createOutgoingShipping(  
                    outgoingShippingData.getInt("order_id"),
                    outgoingShippingData.getString("destination_company"),
                    outgoingShippingData.getString("address"),
                    outgoingShippingData.getString("city"),
                    outgoingShippingData.getString("state"),                    
                    outgoingShippingData.getInt("zip"),
                    outgoingShippingData.getString("truck_id"),
                    outgoingShippingData.getString("departure_date_time"),
                    outgoingShippingData.getString("estimated_arrival"),
                    outgoingShippingData.getString("arrival_confirmation"),
                    outgoingShippingData.getInt("driver_id"),
                    outgoingShippingData.getString("payment_confirmation")

            ));
            
        }
       
    }
    
    //method to get the arraylist out of controller
    public ArrayList<OutgoingShipping> getOutgoingShippingList(){
        return m_OutgoingShippingDataArray;
    }
    
    //___________________________________________________
    //Vehicle Data Query
    //___________________________________________________
    public void GetVehicleData() throws SQLException{
        
        ResultSet vehicleData = null;
        //create the query for the whole table (wildcard)
        String vehicleDataQuery = "SELECT * FROM TCMS_Database.vehicle_data;";
       
        try {
            vehicleData = db.getGenericResultSet(vehicleDataQuery);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     

        //converting results set into an array list
        while(vehicleData.next()){
            
       
        m_VehicleDataArray.add(VehicleFactory.getVehicleFactory().createVehicle(
                    vehicleData.getString("vin"),
                    vehicleData.getString("truck_brand"),
                    vehicleData.getInt("truck_year"),
                    vehicleData.getString("truck_model"),
                    vehicleData.getInt("truck_id"),
                    vehicleData.getInt("driver_id")

                ));

        }
    }

    public ArrayList<Vehicle> getVehicleDataList(){
        return m_VehicleDataArray;
    }
    
    //___________________________________________________
    //Maintenance Data Query
    //___________________________________________________
    public void GetMaintenanceData() throws SQLException{
        
        ResultSet maintenanceData = null;
        //create the query for the whole table (wildcard)
        String maintenanceDataQuery = "SELECT * FROM TCMS_Database.maintenance_data";
       
        try {
            maintenanceData = db.getGenericResultSet(maintenanceDataQuery);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     

        //converting results set into an array list
        while(maintenanceData.next()){
            
       
        m_MaintenanceDataArray.add(MaintenanceFactory.getMaintenanceFactory().createMaintenance(
                    maintenanceData.getInt("work_order"),
                    maintenanceData.getInt("truck_id"),
                    maintenanceData.getString("truck_vin"),
                    maintenanceData.getString("maintenance_id"),
                    maintenanceData.getString("date"),
                    maintenanceData.getString("job_done"),
                    maintenanceData.getString("parts"),
                    maintenanceData.getString("cost"),
                    maintenanceData.getString("detailed_report")
                
                ));

        }
    }

    public ArrayList<Maintenance> getMaintenanceDataList(){
        return m_MaintenanceDataArray;
    }
}
