/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author justin
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response); 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
/**
 * @author Andrea
 */
    private Database db;
    private UserAccounts ua;
    private ResourceAllocation ra;
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
    
    public void getUserAccounts()
    {
        this.ua = UserAccounts.getInstance();
        System.out.println("got the ua");
    }
    
     public void getResourceAllocation()
    {
        this.ra = ResourceAllocation.getInstance();
        System.out.println("got the ra");
    }
     
    public void userLogin()
    {
        //these strings are hard coded for testing purposes will be pulled from jsp later
        String username = "masterTest";
        String password = "pass";
        
        boolean authenticated = ua.userAuthentication(username, password);  
        if(authenticated == true)
        {
            System.out.println("User authenticated");
        }
        if(authenticated == false)
        {
            System.out.println("User unable to be authenticated");
        }
    }
   
   
    
    public void GetPersonnelData() throws SQLException{
        
        ResultSet personnelData = null;
        //create the query for the whole table (wildcard)
        String employeeQuery = "SELECT * FROM Personnel_Data ORDER BY salary DESC";
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

