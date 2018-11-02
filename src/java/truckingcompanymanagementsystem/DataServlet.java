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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //pull in array list
        Controller.getInstance().getDatabase();
        Controller.getInstance().startDatabase();
        
        PersonnelFactory.getPersonnelFactory();
        OutgoingShippingFactory.getOutgoingShippingFactory();
        VehicleFactory.getVehicleFactory();
        
        try {
            Controller.getInstance().GetPersonnelData();
        } catch (SQLException ex) {
            //Logger.getLogger(PersonnelDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        ArrayList<Personnel> personnelArray;
        personnelArray = Controller.getInstance().getPersonnelList();
        System.out.println(this);
        
        ArrayList<OutgoingShipping> outgoingShippingArray;
        outgoingShippingArray = Controller.getInstance().getOutgoingShippingList();
        System.out.println(this);
        
        ArrayList<VehicleData> vehicleDataArray;
        vehicleDataArray = Controller.getInstance().getVehicleDataList();
        System.out.println(this);
         
        RequestDispatcher view = request.getRequestDispatcher("FullAccess.jsp");
        
        response.setContentType("text/html");
       
        request.setAttribute("personnelArray", personnelArray);
        //request.setAttribute("vehicleDataArray", vehicleDataArray);
        request.setAttribute("outgoingShippingArray", outgoingShippingArray);
        
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PersonnelServlet");
//       dispatcher.forward(request, response);
//
//for (Map.Entry<Object, Object> en : OutgoingShipping.entrySet()) {
//            Object key = en.getKey();
//            Object value = en.getValue();
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OutgoingShippingServlet");
//            dispatcher.include(request, response);
//        }
        
//       RequestDispatcher vehicledispatcher = getServletContext().getRequestDispatcher("/VehicleDataServlet");
//       vehicledispatcher.forward(request, response);

        view.forward(request, response);     
    }
    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        
//        processRequest(request, response);
//    }
//
//    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
//        
//                
//        ArrayList<Personnel> personnelArray;
//        personnelArray = Controller.getInstance().getPersonnelList();
//        System.out.println(this);
//        
//        ArrayList<OutgoingShipping> outgoingShippingArray;
//        outgoingShippingArray = Controller.getInstance().getOutgoingShippingList();
//        System.out.println(this);
//        
//        ArrayList<VehicleData> vehicleDataArray;
//        vehicleDataArray = Controller.getInstance().getVehicleDataList();
//        System.out.println(this);
//        
//        //request.setAttribute("personnelArray", personnelArray);
//        //request.setAttribute("vehicleDataArray", vehicleDataArray);
//        //request.setAttribute("outgoingShippingArray", outgoingShippingArray);
//        
//
//    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

//    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//        
//    }


}
