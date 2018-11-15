/*
 * 
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 11/10/18
 * @author Andrea
 */
public class AddDataServlet extends HttpServlet {

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
                   incomingSQLQuery = datamod.addIncoming(
                           Integer.parseInt(request.getParameter("m_orderID")), 
                           request.getParameter("m_sourceCompany"), 
                           request.getParameter("m_address"), 
                           request.getParameter("m_city"), 
                           request.getParameter("m_state"), 
                           Integer.parseInt(request.getParameter("m_zip")),
                           Integer.parseInt(request.getParameter("m_truckID")),
                           request.getParameter("m_departureDate"),
                           request.getParameter("m_estArrival"), 
                           request.getParameter("m_arrivalConf"),
                           Integer.parseInt(request.getParameter("m_driverID")),
                           request.getParameter("m_paymentConf")
                    );
                           try {
                                System.out.println(incomingSQLQuery);

                                db.AddData(incomingSQLQuery);

                                System.out.println(tableName);

                            }catch (SQLException ex) {
                                Logger.getLogger(AddDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                break;
                
            case "outgoing_shipping":
                    outgoingSQLQuery = datamod.addOutgoing(
                           Integer.parseInt(request.getParameter("m_orderID")), 
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
                           try {
                                System.out.println(outgoingSQLQuery);

                                db.AddData(outgoingSQLQuery);

                                System.out.println(tableName);

                            }catch (SQLException ex) {
                                Logger.getLogger(AddDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
                break;
                
            case "vehicle_data":
                    vehicleSQLQuery = datamod.addTruck(
                            request.getParameter("m_vin"), 
                            request.getParameter("m_truckBrand"), 
                            Integer.parseInt(request.getParameter("m_truckYear")), 
                            request.getParameter("m_truckModel"), 
                            Integer.parseInt(request.getParameter("m_truckID")), 
                            Integer.parseInt(request.getParameter("m_driverID")),
                            Integer.parseInt(request.getParameter("m_availability")),
                            request.getParameter("m_partsList")
                    );

                    try {

                        System.out.println(vehicleSQLQuery);          

                        db.AddData(vehicleSQLQuery);

                        System.out.println(tableName);

                        } 
                    catch (SQLException ex) {
                            Logger.getLogger(AddDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                 
                break;
                
            case "maintenance_data":
                    maintenanceSQLQuery = datamod.addMaintenance(
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
                    
                    try {

                        System.out.println(maintenanceSQLQuery);          

                        db.AddData(maintenanceSQLQuery);

                        System.out.println(tableName);

                        } 
                    catch (SQLException ex) {
                            Logger.getLogger(AddDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    break;
             
                    
                
            case "Personnel_Data":
                    personnelSQLQuery = datamod.addPersonnel(
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
                            request.getParameter("m_assignment")
                    );
                    
                        try {
                            System.out.println(personnelSQLQuery);

                            db.AddData(personnelSQLQuery);

                            System.out.println(tableName);
            
                            } catch (SQLException ex) {
                                Logger.getLogger(AddDataServlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                    break;
     
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
