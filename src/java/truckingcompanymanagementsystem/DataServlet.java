/*
    Document   : DataServlet (created from PersonnelDataServlet, OutgoingDataServlet)
    Created on : Oct 18, 2018, 9:00:09 PM
    Author     : Andrea
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Andrea
 */
public class DataServlet extends HttpServlet {
    
    private DataServlet dataservlet;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Get updated version of data
        try {
            Controller.getInstance().GetPersonnelData();
            Controller.getInstance().GetVehicleData();
            Controller.getInstance().GetIncomingShippingData();
            Controller.getInstance().GetOutgoingShippingData();
            Controller.getInstance().GetMaintenanceData();
        } catch (SQLException ex) {
            //Logger.getLogger(PersonnelDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // This is where you put an if statement to figure out what information you want to display - Full Access, Maintenance, etc.
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        ArrayList<Personnel> personnelArray;
        personnelArray = Controller.getInstance().getPersonnelList();
        System.out.println(this);
        
        ArrayList<IncomingShipping> incomingShippingArray;
        incomingShippingArray = Controller.getInstance().getIncomingShippingList();
        System.out.println(this);
        
        ArrayList<OutgoingShipping> outgoingShippingArray;
        outgoingShippingArray = Controller.getInstance().getOutgoingShippingList();
        System.out.println(this);
        
        ArrayList<Vehicle> vehicleDataArray;
        vehicleDataArray = Controller.getInstance().getVehicleDataList();
        System.out.println(this);                     

        ArrayList<Maintenance> maintenanceDataArray;
        maintenanceDataArray = Controller.getInstance().getMaintenanceDataList();
        System.out.println(this);         
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // This is where you put an if statement to figure out which "view" you want to display - Full Access, Maintenance, etc.
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        if (true) {         // Full access -> if user == admin
            response.setContentType("text/html");
            request.setAttribute("personnelArray", personnelArray);
            request.setAttribute("vehicleDataArray", vehicleDataArray);
            request.setAttribute("incomingShippingArray", incomingShippingArray);
            request.setAttribute("outgoingShippingArray", outgoingShippingArray);
            request.setAttribute("maintenanceDataArray", maintenanceDataArray);

            RequestDispatcher view = request.getRequestDispatcher("FullAccess.jsp");
            view.forward(request, response);
        }
        else if (false) {   // Shipping access -> if user == shipping
            response.setContentType("text/html");       
            request.setAttribute("vehicleDataArray", vehicleDataArray);
            request.setAttribute("incomingShippingArray", incomingShippingArray);
            request.setAttribute("outgoingShippingArray", outgoingShippingArray);               
            request.setAttribute("maintenanceDataArray", maintenanceDataArray);
            
            RequestDispatcher view = request.getRequestDispatcher("ShippingAccess.jsp");
            view.forward(request, response);
        }
        else if (false) {      // Maintenance access -> if user == maintenance
            response.setContentType("text/html");       
            request.setAttribute("vehicleDataArray", vehicleDataArray);
            request.setAttribute("maintenanceDataArray", maintenanceDataArray);

            RequestDispatcher view = request.getRequestDispatcher("MaintenanceAccess.jsp");
            view.forward(request, response);
        }
        else if (false) {       // Driver access -> if user == driver
            response.setContentType("text/html");       
            request.setAttribute("outgoingShippingArray", outgoingShippingArray);

            RequestDispatcher view = request.getRequestDispatcher("DriverAccess.jsp");
            view.forward(request, response);
        }
        else {                  // Not valid user
            response.setContentType("text/html");                      
            RequestDispatcher view = request.getRequestDispatcher("AccessDenied.jsp");
            view.forward(request, response);
        }            
    }
    
    //Forward HTTP methods to processRequest()
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        processRequest(request, response);        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        processRequest(request, response);
    }
}