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
        <form action="DataServlet">
            <input type="hidden" name="orderID" value="<%=request.getParameter("m_orderID")%>"/>
            <input type="hidden" name="generic_table" value="<%=request.getParameter("generic_table")%>"/>
            <input type="submit" value="submit">
        
            
        <h1>Purchase Order</h1>
        <button type="button" name="back" onclick="history.back()">back</button>
        <table>
            <th>Item Name</th>
            <th>Item Amount</th>
            <th>Unit Cost</th>
            <th>Total Cost</th>
            <th>Availability</th> 
        
            <c:forEach items="${purchaseOrderDataArray}" var="purchaseOrderDataArray" begin="0">
                <td>${purchaseOrderDataArray.item_name}</td>
                <td>${purchaseOrderDataArray.item_amount}</td>
                <td>${purchaseOrderDataArray.unit_cost}</td>
                <td>${purchaseOrderDataArray.total_item_cost}</td>
                <td>${purchaseOrderDataArray.availability}</td>
            </c:forEach>
          <tr>
            <td>Test Value</td>
            <td>Test Value</td>
            <td>Test Value</td>
            <td>Test Value</td>
            <td>Test Value</td>
          </tr>
        </table>
        </form>
    </body>
</html>
