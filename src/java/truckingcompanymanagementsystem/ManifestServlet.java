/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justi
 */
public class ManifestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
     
        
        
        ArrayList<Manifest> manifestDataArray = null;
        
        String orderID_string = request.getParameter("orderID");
        int orderID = Integer.parseInt(orderID_string);
       
        
        ReportGeneration rg = new ReportGeneration();
        
        manifestDataArray = rg.makeManifestReport(orderID);
       
      
       double subtotal = 0.0;
        for (int i = 0; i < manifestDataArray.size(); i++) {
            subtotal += manifestDataArray.get(i).getTotal_item_cost();
        }
        subtotal = BigDecimal.valueOf(subtotal)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
        double shippingCost = BigDecimal.valueOf(subtotal * 0.01)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
        double tax = BigDecimal.valueOf(subtotal * 0.09)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
        double total = BigDecimal.valueOf(subtotal + shippingCost + tax)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();

        
        request.setAttribute("subtotal", subtotal);
        request.setAttribute("shippingCost", shippingCost);
        request.setAttribute("tax", tax);
        request.setAttribute("total", total);

        response.setContentType("text/html");
        request.setAttribute("manifestDataArray", manifestDataArray);
        RequestDispatcher view = null;
        view = request.getRequestDispatcher("Manifest.jsp");
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
