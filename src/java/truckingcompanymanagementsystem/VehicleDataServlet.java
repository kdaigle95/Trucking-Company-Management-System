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




public class VehicleDataServlet extends HttpServlet {

    //private static final long serialVersionUID = 1L;
    
    private VehicleDataServlet vehicleservlet;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //pull in array list
        Controller.getInstance().getDatabase();
        Controller.getInstance().startDatabase();
        
        VehicleFactory.getVehicleFactory();
        OutgoingShippingFactory.getOutgoingShippingFactory();
        
        try {
            Controller.getInstance().GetPersonnelData();
        } catch (SQLException ex) {
            //Logger.getLogger(PersonnelDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        ArrayList<VehicleData> vehicleDataArray;
        vehicleDataArray = Controller.getInstance().getVehicleDataList();
        System.out.println(this);
  
        
        RequestDispatcher view = request.getRequestDispatcher("FullPageTabs.jsp");
        
        response.setContentType("text/html");
       
        request.setAttribute("vehicleArray", vehicleDataArray); 

        view.forward(request, response);
        
    }
    

}