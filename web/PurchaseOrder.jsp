<%-- 
    Document   : PurchaseOrder
    Created on : Nov 15, 2018, 12:07:43 AM
    Author     : justin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/Report.css" rel="stylesheet" type="text/css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Order</title>
    </head>
    <body>
            <h1>Purchase Order</h1>

            <table class = "table">
                <th>Item Name</th>
                <th>Item Amount</th>
                <th>Unit Cost</th>
                <th>Total Cost</th>
                <th>Availability</th> 

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
                <button class="button" onclick="history.back()">back</button>
        </form>
    </body>
</html>
