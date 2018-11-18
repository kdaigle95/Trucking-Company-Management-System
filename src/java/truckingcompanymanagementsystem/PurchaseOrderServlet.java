/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author justin
 */
public class PurchaseOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       
        
        ArrayList<PurchaseOrder> purchaseOrderDataArray = null;
        ArrayList<TotalCosts> totalCostsArray = new ArrayList<TotalCosts>();
        
        String orderID_string = request.getParameter("orderID");
        int orderID = Integer.parseInt(orderID_string);
        
        
        ReportGeneration rg = new ReportGeneration();
        
        purchaseOrderDataArray = rg.makePurchaseReport(orderID);
        System.out.println("testtesttesttesttest");
        System.out.println(purchaseOrderDataArray.toString());
        
        
        totalCostsArray.add(new TotalCosts(purchaseOrderDataArray));
        
        response.setContentType("text/html");
        request.setAttribute("purchaseOrderDataArray", purchaseOrderDataArray);
        
        RequestDispatcher view = null;
        view = request.getRequestDispatcher("PurchaseOrder.jsp");
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

    
    class TotalCosts
    {
        double subtotal;
        double shippingCost;
        double tax;
        double total;
        
        public TotalCosts(ArrayList<PurchaseOrder> purchaseOrderDataArray) {
            double subtotal = 0.0;
        for(int i = 0; i < purchaseOrderDataArray.size(); i++) {
            subtotal += purchaseOrderDataArray.get(i).getTotal_item_cost();
        }
        double shippingCost = subtotal * .15;
        double tax = subtotal * 0.09;
        double total = subtotal + shippingCost + tax;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public double getShippingcost() {
            return shippingCost;
        }

        public double getTax() {
            return tax;
        }

        public double getTotal() {
            return total;
        }
        
        
        
        
    }
}
