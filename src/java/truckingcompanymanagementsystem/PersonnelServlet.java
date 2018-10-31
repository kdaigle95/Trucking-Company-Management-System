package truckingcompanymanagementsystem;

/**
 *
 * @author Andrea
 * made Outgoing Shipping forward request 10/30/2018
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;




public class PersonnelServlet extends HttpServlet {

    //private static final long serialVersionUID = 1L;
    
    private PersonnelServlet testdemoservlet;
    private OutgoingShippingServlet shippingservlet;
    
    
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
        //request.setAttribute("outgoingShippingArray", outgoingShippingArray);
        
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OutgoingShippingDataServlet");
//        dispatcher.forward(request, response);
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OutgoingShippingServelt");
//        dispatcher.include(request, response);
        
        view.forward(request, response);
        
    }
    

}