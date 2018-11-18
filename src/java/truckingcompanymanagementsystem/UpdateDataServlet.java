/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrea
 */
public class UpdateDataServlet extends HttpServlet {

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
        
        //trying to handle possible date format issue
        //DateFormat df = new SimpleDataFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        
        String personnelSQLQuery = null;
        String incomingSQLQuery = null;
        String outgoingSQLQuery = null;
        String vehicleSQLQuery = null;
        String maintenanceSQLQuery = null;
        

        String tableName = request.getParameter("generic_table");
        Database db = Database.getInstance();
        
        switch(tableName.trim()){
            case "incoming_shipping":

                break;
                
            case "outgoing_shipping":
                outgoingSQLQuery = datamod.updateOutgoing(
                       Integer.parseInt(request.getParameter("m_truckID")),
                       request.getParameter("m_destinationCompany"), 
                       request.getParameter("m_destinationCompanyAddress"),
                       request.getParameter("m_destinationCompanyCity"), 
                       request.getParameter("m_destinationCompanyState"), 
                       Integer.parseInt(request.getParameter("m_destinationCompanyZip")), 
                       Integer.parseInt(request.getParameter("m_truckID")),
                       request.getParameter("m_departureDate"),
                       request.getParameter("m_estArrival"),
                       request.getParameter("m_arrivalConf"),
                       Integer.parseInt(request.getParameter("m_driverID")),
                       request.getParameter("m_paymentConf")
                    );

                System.out.println(outgoingSQLQuery);
                try {
                    db.EditData(outgoingSQLQuery);
                } catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(UpdateDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(tableName);
                break;
                
            case "vehicle_data":
                vehicleSQLQuery = datamod.updateVehicle(
                        Integer.parseInt(request.getParameter("m_truckID")),
                        request.getParameter("m_vin"), 
                        request.getParameter("m_truckBrand"),
                        Integer.parseInt(request.getParameter("m_truckYear")), 
                        request.getParameter("m_truckModel"), 
                        Integer.parseInt(request.getParameter("m_driverID")), 
                        Integer.parseInt(request.getParameter("m_availability")) 
                    );

                System.out.println(vehicleSQLQuery);
                try {
                    db.EditData(vehicleSQLQuery);
                } catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(UpdateDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(tableName);
                
                break;
                
            case "maintenance_data":
                maintenanceSQLQuery = datamod.updateMaintenance(
                        Integer.parseInt(request.getParameter("m_workOrder")),
                        Integer.parseInt(request.getParameter("m_truckID")),
                        request.getParameter("m_vin"), 
                        Integer.parseInt(request.getParameter("m_maintenanceID")),
                        request.getParameter("m_date"), 
                        request.getParameter("m_jobDone"), 
                        request.getParameter("m_parts"), 
                        request.getParameter("m_cost"), 
                        request.getParameter("m_report") 
                    );

                System.out.println(maintenanceSQLQuery);
                try {
                    db.EditData(maintenanceSQLQuery);
                } catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(UpdateDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(tableName);
                
                break;
                
            case "Personnel_Data":
                personnelSQLQuery = datamod.updatePersonnel(
                        Integer.parseInt(request.getParameter("m_employeeID")),
                        request.getParameter("m_firstName"),
                        request.getParameter("m_middleName"),
                        request.getParameter("m_lastName"),
                        request.getParameter("m_streetAddress"),
                        request.getParameter("m_city"),
                        request.getParameter("m_state"),
                        Integer.parseInt(request.getParameter("m_zip")),
                        request.getParameter("m_homePhone"),
                        request.getParameter("m_cellPhone"),
                        Integer.parseInt(request.getParameter("m_years")),
                        request.getParameter("m_position"),
                        Integer.parseInt(request.getParameter("m_salary")),
                        Integer.parseInt(request.getParameter("m_payrate")),
                        Integer.parseInt(request.getParameter("m_assignment"))
                );

                System.out.println(personnelSQLQuery);
                try {
                    db.EditData(personnelSQLQuery);
                } catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(UpdateDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(tableName);
                break;
            
     
        }
        

        response.setContentType("text/html");        
        RequestDispatcher view = request.getRequestDispatcher("DataServlet?tableName=" + tableName);
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
