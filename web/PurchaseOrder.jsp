<%-- 
    Document   : PurchaseOrder
    Created on : Nov 15, 2018, 12:07:43 AM
    Author     : justin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, td, th 
        {    
            border: 1px solid #ddd;
            text-align: left;
        }

        table 
        {
            border-collapse: collapse;
            width: 100%;
        }

        th, td 
        {
            padding: 15px;
        }
    </style>
    <body>
        <form action="PurchaseOrderServlet">
            <h1>Click Submit to Generate Purchase Order</h1>
            <input type="hidden" name="orderID" value="<%=request.getParameter("id")%>"/>
            <input type="submit" value="submit">
            <h1>Purchase Order</h1>

            <table class = "table">
                <tr>Item Name</tr>
                <tr>Item Amount</tr>
                <tr>Unit Cost</tr>
                <tr>Total Cost</tr>
                <tr>Availability</tr> 

                <c:forEach items="${purchaseOrderDataArray}" var="purchaseOrderDataArray" begin="0">
                    <tr class="tr">
                        <td>${purchaseOrderDataArray.item_name}</td>
                        <td>${purchaseOrderDataArray.item_amount}</td>
                        <td>${purchaseOrderDataArray.unit_cost}</td>
                        <td>${purchaseOrderDataArray.total_item_cost}</td>
                        <td>${purchaseOrderDataArray.availability}</td>
                    </tr>
                </c:forEach>
                        
            </table>
            
            <table class = "table">
                <tr>Subtotal</tr>
                <tr>Sales Tax</tr>
                <tr>Shipping and Handling</tr>
                <tr>Total Cost</tr>
                <tr class="tr">
                    <td>${subtotal}</td>
                    <td>${tax}</td>
                    <td>${shippingCost}</td>
                    <td>${total}</td>
                        
                </tr>
            <button type="button" name="back" onclick="history.back()">back</button>
        </form>
    </body>
</html>
