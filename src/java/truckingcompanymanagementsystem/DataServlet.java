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
    //private PersonnelDataServlet testdemoservlet;
    //private OutgoingShippingDataServlet shippingservlet;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //pull in array list
        Controller.getInstance().getDatabase();
        Controller.getInstance().startDatabase();
        
        PersonnelFactory.getPersonnelFactory();
        OutgoingShippingFactory.getOutgoingShippingFactory();
        
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
        
  
        
        RequestDispatcher view = request.getRequestDispatcher("FullPageTabs.jsp");
        
        response.setContentType("text/html");
       
        request.setAttribute("personnelArray", personnelArray); 
        request.setAttribute("outgoingShippingArray", outgoingShippingArray);
        
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OutgoingShippingDataServlet");
//        dispatcher.forward(request, response);
//        
          view.forward(request, response);
        
    }
    

}
