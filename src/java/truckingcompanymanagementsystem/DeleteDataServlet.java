/*
 * 
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 11/10/2018
 * @author Andrea
 */
public class DeleteDataServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DataModification datamod = new DataModification();
        String personnelSQLQuery = null;
        String incomingSQLQuery = null;
        String outgoingSQLQuery = null;
        String vehicleSQLQuery = null;
        String maintenanceSQLQuery = null;
        
        String primary_key = request.getParameter("primary_key");
        
        String tableName = request.getParameter("generic_table");
        Database db = Database.getInstance();
        
        switch(tableName.trim()){
            
            case "incoming_shipping":

                break;
                
            case "outgoing_shipping":
            
                break;
                
            case "vehicle_data":
                 
                break;
                
            case "maintenance_data":
                   maintenanceSQLQuery = datamod.deleteRow("maintenance_data", Long.parseLong(primary_key));
                break;
                
            case "Personnel_Data":
                
                   personnelSQLQuery = datamod.deleteRow("Personnel_Data", Long.parseLong(primary_key));
                break;
     
        }
        
        try {
            System.out.println(personnelSQLQuery);
            System.out.println(maintenanceSQLQuery);
            
            db.DeleteData(personnelSQLQuery);
            db.DeleteData(maintenanceSQLQuery);
            
            System.out.println(tableName);
        } catch (NullPointerException ex) {
            Logger.getLogger(DeleteDataServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(DeleteDataServlet.class.getName()).log(Level.SEVERE, null, ex);
       }

        response.setContentType("text/html");                      
        RequestDispatcher view = request.getRequestDispatcher("DataServlet");
        view.forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

}