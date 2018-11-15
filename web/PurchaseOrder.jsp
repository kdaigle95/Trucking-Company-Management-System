<%-- 
    Document   : PurchaseOrder
    Created on : Nov 15, 2018, 12:07:43 AM
    Author     : justin
--%>

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
        <h1>Purchase Order</h1>
        <table>
          <tr>
            <th>Item Name</th>
            <th>Item Amount</th>
            <th>Unit Cost</th>
            <th>Total Cost</th>
            <th>Availability</th>
          </tr> 
          <tr>
            <td>Test Value</td>
            <td>Test Value</td>
            <td>Test Value</td>
            <td>Test Value</td>
            <td>Test Value</td>
          </tr>
        </table>
    </body>
</html>
