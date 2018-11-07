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
    private ArrayList<OutgoingShipping> m_OutgoingShippingDataArray = new ArrayList<>();
    private ArrayList<VehicleData> m_VehicleDataArray = new ArrayList<>();
    
    //dynamic arraylist member variable to hold data for dynamic table population 
    private PersonnelFactory personFactory = PersonnelFactory.getPersonnelFactory();
    private OutgoingShippingFactory outgoingShippingFactory = OutgoingShippingFactory.getOutgoingShippingFactory();
    
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
   
    
    /////////////////////////////////////
    // Personnel Data Methods
    ////////////////////////////////////
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
                    personnelData.getString("state"),
                    personnelData.getString("city"),
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
    
    /*OutgoingShippingData*/
    
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
                    outgoingShippingData.getString("state"),
                    outgoingShippingData.getString("zip")
     
            ));
            
        }
       
    }
    
    //method to get the arraylist out of controller
    public ArrayList<OutgoingShipping> getOutgoingShippingList(){
        return m_OutgoingShippingDataArray;
    }
    
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
    
    
    public ArrayList<VehicleData> getVehicleDataList(){
        return m_VehicleDataArray;
    }
    
}
