/*
 * 
 */
package truckingcompanymanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Andrea
 */
public final class Controller {
    
    private Database db;
    
    //temp member variables just to display
    private int m_employeeID;
    private String m_firstName;
    private String m_middleName;
    private String m_lastName;
   
    
    
    private Controller()
    {  
        //this.getDatabase();
        //use a logging library in future
        System.out.println("Controller Created");

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

       
        personnelData.first();
        m_employeeID = personnelData.getInt("employee_id_number");
        m_firstName = personnelData.getString("first_name");
        m_lastName = personnelData.getString("last_name");
        
    }
    
    //accessors
    //_______________________________
    public int getEmployeeID()
    {
        System.out.println("you have the employee ID number");
        return m_employeeID;
    }
    
    public String getEmployeeFirstName()
    {
        System.out.println("you have the employee first name");
        return m_firstName;
    }
    
    public String getEmployeeLastName()
    {
        System.out.println("you have the employee last name");
        return m_lastName;
    }
    
    //mutators
    //______________________________
//    public void empolyeeid()
//    {
//        m_empolyeeID = variableTo changeQery;
//    }
//    
}
