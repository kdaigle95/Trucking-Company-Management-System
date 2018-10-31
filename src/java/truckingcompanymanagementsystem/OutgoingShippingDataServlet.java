/*
 * 
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrea
 */
public class OutgoingShippingDataServlet extends HttpServlet {

    private OutgoingShippingDataServlet shippingservlet;
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //pull in array list
        Controller.getInstance().getDatabase();
        Controller.getInstance().startDatabase();
        OutgoingShippingFactory.getOutgoingShippingFactory();
        try {
            Controller.getInstance().GetOutgoingShippingData();
        } catch (SQLException ex) {
            //Logger.getLogger(PersonnelDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        ArrayList<OutgoingShipping> outgoingShippingArray;
        outgoingShippingArray = Controller.getInstance().getOutgoingShippingList();
        System.out.println(this);
        
        response.setContentType("text/html");
        request.setAttribute("outgoingShippingArray", outgoingShippingArray);
        RequestDispatcher view = request.getRequestDispatcher("FullPageTabs.jsp");
        view.forward(request, response);
        
    }
 
}
