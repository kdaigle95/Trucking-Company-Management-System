<%-- 
    Document   : Manifest
    Created on : Nov 15, 2018, 12:08:37 AM
    Author     : justin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/Report.css" rel="stylesheet" type="text/css"/>
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
            <table class = "table">
                <th>Item Name</th>
                <th>Item Amount</th>
                <th>Unit Cost</th>
                <th>Total Cost</th>

                <c:forEach items="${manifestDataArray}" var="manifestDataArray" begin="0">
                    <tr class="tr">
                        <td>${manifestDataArray.item_name}</td>
                        <td>${manifestDataArray.item_amount}</td>
                        <td>${manifestDataArray.unit_cost}</td>
                        <td>${manifestDataArray.total_item_cost}</td>
                    </tr>
                </c:forEach>

            </table>

            <table class = "table">
                <th>Subtotal</th>
                <th>Sales Tax</th>
                <th>Shipping and Handling</th>
                <th>Total Cost</th>


                    <tr class="tr">
                        <td>${subtotal}</td>
                        <td>${tax}</td>
                        <td>${shippingCost}</td>
                        <td>${total}</td>
                    </tr>
            </table>
            <button type="button" name="back" onclick="history.back()">back</button>
        </form>
    </body>
</html>
