/*
    Document   : DataServlet (created from PersonnelDataServlet, OutgoingDataServlet)
    Created on : Oct 18, 2018, 9:00:09 PM
    Author     : Andrea
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
//import truckingcompanymanagementsystem.UserAccounts.User;

/**
 *
 * @author Andrea
 */
public class DataServlet extends HttpServlet {
    
    private DataServlet dataservlet;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Personnel> personnelArray = null;
        ArrayList<IncomingShipping> incomingShippingArray = null;
        ArrayList<OutgoingShipping> outgoingShippingArray = null;
        ArrayList<Vehicle> vehicleDataArray = null;
        ArrayList<Maintenance> maintenanceDataArray = null;
        ArrayList<IncomingShipping> driverIncomingArray = null;
        ArrayList<OutgoingShipping> driverOutgoingArray = null;
        ReportGeneration rg = new ReportGeneration();
        int id = 0;

        
        String defaultOpen = "defaultOpen";
        String defaultClosed = "defaultClosed";
        
        String tableName;
        try{
            tableName = request.getParameter("tableName").trim();
        }
        catch(NullPointerException ex){
            tableName = "";
        }


        //ArrayList<Manifest> manifestDataArray = null;
        //ArrayList<PurchaseOrder> purchaseOrderDataArray = null;
        
        

        //Get updated version of data
        try {
            Controller.getInstance().GetPersonnelData();
            Controller.getInstance().GetVehicleData();
            Controller.getInstance().GetIncomingShippingData();
            Controller.getInstance().GetOutgoingShippingData();
            Controller.getInstance().GetMaintenanceData();
            
            //Controller.getInstance().GetManifestData(orderID);
            //Controller.getInstance().GetPurchaseOrderData(orderID);
        } catch (SQLException ex) {
            //Logger.getLogger(PersonnelDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

       // personnelArray = Controller.getInstance().getPersonnelList();
        //System.out.println(this);

        //incomingShippingArray = Controller.getInstance().getIncomingShippingList();
        //System.out.println(this);

        //outgoingShippingArray = Controller.getInstance().getOutgoingShippingList();
        //System.out.println(this);

        //vehicleDataArray = Controller.getInstance().getVehicleDataList();
        //System.out.println(this);                     

        //maintenanceDataArray = Controller.getInstance().getMaintenanceDataList();
        //System.out.println(this);         
        
        
        UserAccounts ua = Controller.getInstance().getUserAccounts();

        //user name and password is not cached
        //this means you can only view the dataservlet the one time
        //hard coding for now
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //String username = "masterTest";
        //String password = "pass";
        
        
        boolean user_authenticated = false;
        if(ua.has_logged_in == false)
        {
            ua.userAuthentication(username, password);
            id = ua.getID();
        }
        
        RequestDispatcher view = null;
        
        
        personnelArray = Controller.getInstance().getPersonnelList();
        System.out.println(this);
        
        incomingShippingArray = Controller.getInstance().getIncomingShippingList();
        System.out.println(this);

        outgoingShippingArray = Controller.getInstance().getOutgoingShippingList();
        System.out.println(this);

        vehicleDataArray = Controller.getInstance().getVehicleDataList();
        System.out.println(this);                     

        maintenanceDataArray = Controller.getInstance().getMaintenanceDataList();
        System.out.println(this);     
        
        driverIncomingArray = rg.makeDriverIncoming(id);
        driverOutgoingArray = rg.makeDriverOutgoing(id);
        System.out.println(driverIncomingArray.toString());
        System.out.println(driverOutgoingArray.toString());
        
        
        //manifestDataArray = Controller.getInstance().getManifestDataList();
        //System.out.println(this);
        
        //purchaseOrderDataArray = Controller.getInstance().getPurchaseOrderDataList();
        //System.out.println(this);
        
        
        switch(tableName){
            
            case "incoming_shipping":
                request.setAttribute("homeOpen", defaultClosed);
                request.setAttribute("shippingOpen", defaultOpen);
                request.setAttribute("equipmentOpen", defaultClosed);
                request.setAttribute("personnelOpen", defaultClosed);
                break;
                
            case "outgoing_shipping":
                request.setAttribute("homeOpen", defaultClosed);
                request.setAttribute("shippingOpen", defaultOpen);
                request.setAttribute("equipmentOpen", defaultClosed);
                request.setAttribute("personnelOpen", defaultClosed);
                break;
                
            case "vehicle_data":
                request.setAttribute("homeOpen", defaultClosed);
                request.setAttribute("shippingOpen", defaultClosed);
                request.setAttribute("equipmentOpen", defaultOpen);
                request.setAttribute("personnelOpen", defaultClosed);
                break;
                
            case "maintenance_data":
                request.setAttribute("homeOpen", defaultClosed);
                request.setAttribute("shippingOpen", defaultClosed);
                request.setAttribute("equipmentOpen", defaultOpen);
                request.setAttribute("personnelOpen", defaultClosed);
                break;

            case "Personnel_Data":
                request.setAttribute("homeOpen", defaultClosed);
                request.setAttribute("shippingOpen", defaultClosed);
                request.setAttribute("equipmentOpen", defaultClosed);
                request.setAttribute("personnelOpen", defaultOpen);
                break;
                
            default:
                request.setAttribute("homeOpen", defaultOpen);
                request.setAttribute("shippingOpen", defaultClosed);
                request.setAttribute("equipmentOpen", defaultClosed);
                request.setAttribute("personnelOpen", defaultClosed);
                break;
     
        }       
 
    if(ua.user_authenticated == true)
    {
        if (ua.access_level == "full") {         // Full access -> if user == admin
            response.setContentType("text/html");
            request.setAttribute("personnelArray", personnelArray);
            request.setAttribute("vehicleDataArray", vehicleDataArray);
            request.setAttribute("incomingShippingArray", incomingShippingArray);
            request.setAttribute("outgoingShippingArray", outgoingShippingArray);
            request.setAttribute("maintenanceDataArray", maintenanceDataArray);
            


            view = request.getRequestDispatcher("FullAccess.jsp");
            view.forward(request, response);
        }
        else if (ua.access_level == "shipping") {   // Shipping access -> if user == shipping
            response.setContentType("text/html");       
            request.setAttribute("vehicleDataArray", vehicleDataArray);
            request.setAttribute("incomingShippingArray", incomingShippingArray);
            request.setAttribute("outgoingShippingArray", outgoingShippingArray);               
            request.setAttribute("maintenanceDataArray", maintenanceDataArray);
            
            view = request.getRequestDispatcher("ShippingAccess.jsp");
            view.forward(request, response);
        }
        else if (ua.access_level == "maint") {      // Maintenance access -> if user == maintenance
            response.setContentType("text/html");       
            request.setAttribute("vehicleDataArray", vehicleDataArray);
            request.setAttribute("maintenanceDataArray", maintenanceDataArray);

            view = request.getRequestDispatcher("MaintenanceAccess.jsp");
             view.forward(request, response);
        }
        else if (ua.access_level == "driver") {       // Driver access -> if user == driver
            response.setContentType("text/html");       
            request.setAttribute("driverIncomingArray", driverIncomingArray);
            request.setAttribute("driverOutgoingArray", driverOutgoingArray);

            view = request.getRequestDispatcher("DriverAccess.jsp");
            view.forward(request, response);
        }
        else {                  // Not valid user
            response.setContentType("text/html");                      
            view = request.getRequestDispatcher("AccesDenied.jsp");
            view.forward(request, response);
        }
        
        //@Andrea added clearLists method 11/11/18
       clearLists(personnelArray, incomingShippingArray, outgoingShippingArray, vehicleDataArray, maintenanceDataArray); 
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
    
    protected void clearLists( ArrayList<Personnel> personnelArray, ArrayList<IncomingShipping> incomingShippingArray, ArrayList<OutgoingShipping> outgoingShippingArray, ArrayList<Vehicle> vehicleDataArray, ArrayList<Maintenance> maintenanceDataArray){
        
        if(!(personnelArray.isEmpty())){
            personnelArray.clear();
        }
        
        if(!(incomingShippingArray.isEmpty())){
            incomingShippingArray.clear();
        }
        
        if(!(outgoingShippingArray.isEmpty())){
            outgoingShippingArray.clear();
        }
        
        if(!(vehicleDataArray.isEmpty())){
            vehicleDataArray.clear();
        }
        
        if(!(maintenanceDataArray.isEmpty())){
            maintenanceDataArray.clear();
        }
    }
}
