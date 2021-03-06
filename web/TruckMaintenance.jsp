<%-- 
    Document   : PartsList
    Created on : Nov 17, 2018, 7:34:26 PM
    Author     : kdaig
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/Report.css" rel="stylesheet" type="text/css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Truck Maintenance</title>
    </head>
    <body>
     
            <h1>Truck Maintenance</h1>

            <table class="table">
                <th>Work Order</th>
                <th>Truck ID</th>
                <th>Truck Vin</th>
                <th>Maintenance ID</th>
                <th>Date</th>
                <th>Job Type</th>
                <th>Parts</th>
                <th>Cost</th>
                <th>Report Details</th>
                    <c:forEach items="${maintenanceDataArray}" var="maintenanceDataArray" begin="0">
                    <tr class="tr"> 
                        <td>${maintenanceDataArray.m_workOrder}</td>
                        <td>${maintenanceDataArray.m_truckID}</td>
                        <td>${maintenanceDataArray.m_vin}</td>
                        <td>${maintenanceDataArray.m_maintenanceID}</td>
                        <td>${maintenanceDataArray.m_date}</td>
                        <td>${maintenanceDataArray.m_jobDone}</td>
                        <td>${maintenanceDataArray.m_parts}</td>
                        <td>${maintenanceDataArray.m_cost}</td>
                        <td>${maintenanceDataArray.m_report}</td>
                    </tr>    
                </c:forEach> 
            </table>
            <button type="button" name="back" onclick="history.back()">back</button>
        </form>
    </body>
</html>

