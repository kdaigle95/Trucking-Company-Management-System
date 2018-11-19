<%-- 
    Document   : personnel
    Created on : Oct 18, 2018, 9:00:09 PM
    Author     : Andrea
    https://www.w3schools.com/howto/howto_js_full_page_tabs.asp
--%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "truckingcompanymanagementsystem.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="CSS/FullPageTabs.css" rel="stylesheet" type="text/css"/>
        <title>TCMS</title>
    </head>
    <body>
        <h1>Maintenance Access User</h1>
        <div align ="right">
            <form action="Logout.jsp">
                <input type ="submit" value="logout" name ="logout" id="form_submit"/>
            </form>
        </div>    
        <button class="tablink" onclick="openPage('Home', this, 'rgba(9,21,52,0.98)')" id="defaultOpen">Home</button>

        <button class="tablink" onclick="openPage('Equipment', this, 'rgba(9,21,52,0.98)')">Equipment</button>

        <button class="tablink" onclick="openPage('Maintenance', this, 'rgba(9,21,52,0.98)')">Maintenance</button>

        <button class="tablink" onclick="openPage('Safety', this, 'rgba(9,21,52,0.98)')" >Safety</button>

        <div id="Home" class="tabcontent">
            <h3>Home</h3>
            <p id = "date"></p>
            <p>Company Info</p>

        </div>

        <div id="Equipment" class="tabcontent">
            <div class="row">
                <div class="column" style="background-color: #717e99;">
                    <h2>Vehicles</h2>
                    <div>
                        <a href="AddData.jsp?vehicle_data">
                            <button class="button">Add Active Vehicle</button>       
                        </a>
                    </div>
                    <button class="accordion">Vehicle</button> 
                    <div class ="panel">
                        <table class="table">
                            <th>Vin</th>
                            <th>Truck Brand</th>
                            <th>Truck Year</th>
                            <th>Truck Model</th>
                            <th>Truck ID</th>
                            <th>Driver ID</th>
                            <th>Availability</th>
                            <th>Delete</th>
                                <c:forEach items="${vehicleDataArray}" var="vehicleDataArray" begin="0">
                                <tr class="tr">
                                <form action="UpdateDataServlet" method="post">
                                    <input type="hidden" name="generic_table" value="vehicle_data"/> 
                                    <td><input type="text" name="m_vin" value="${vehicleDataArray.m_vin}"></td>
                                    <td><input type="text" name="m_truckBrand" value="${vehicleDataArray.m_truckBrand}"></td>
                                    <td><input type="text" name="m_truckYear" value="${vehicleDataArray.m_truckYear}"></td>
                                    <td><input type="text" name="m_truckModel" value="${vehicleDataArray.m_truckModel}"></td>
                                    <td><input type="text" name="m_truckID" value="${vehicleDataArray.m_truckID}"></td>
                                    <td><input type="text" name="m_driverID" value="${vehicleDataArray.m_driverID}"></td>
                                    <td><input type="text" name="m_availability" value="${vehicleDataArray.m_availability}"></td>                              
                                    <td><input type="submit" value="Update"></td>
                                    <td><a href="DeleteData.jsp?id=${vehicleDataArray.m_truckID}&generic_table=vehicle_data">Delete</a></td>
                                </form>
                                </tr>    
                            </c:forEach> 
                        </table>
                    </div>       
                </div>
            </div>
        </div>

        <div id="Maintenance" class="tabcontent">    
            <div class="row">
                <div class="column" style="background-color: #717e99;">
                    <h2>Maintenance Records</h2>   
                    <div>
                        <a href="AddData.jsp?maintenance_data">
                            <button class="button">Add Active Vehicle</button>       
                        </a>
                    </div>
                    <button class="accordion">Repair Records</button> 
                    <div class ="panel">
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
                                <form action="UpdateDataServlet" method="post">
                                    <input type="hidden" name="generic_table" value="maintenance_data"/> 
                                    <td><input type="text" name="m_workOrder" value="${maintenanceDataArray.m_workOrder}"></td>
                                    <td><input type="text" name="m_truckID" value="${maintenanceDataArray.m_truckID}"></td>
                                    <td><input type="text" name="m_vin" value="${maintenanceDataArray.m_vin}"></td>
                                    <td><input type="text" name="m_maintenanceID" value="${maintenanceDataArray.m_maintenanceID}"></td>
                                    <td><input type="text" name="m_date" value="${maintenanceDataArray.m_date}"></td>
                                    <td><input type="text" name="m_jobDone" value="${maintenanceDataArray.m_jobDone}"></td>
                                    <td><input type="text" name="m_parts" value="${maintenanceDataArray.m_parts}"></td>
                                    <td><input type="text" name="m_cost" value="${maintenanceDataArray.m_cost}"></td>
                                    <td><input type="text" name="m_report" value="${maintenanceDataArray.m_report}"></td>
                                    <td><input type="submit" value="Update"></td>
                                    <td><a href="DeleteData.jsp?id=${maintenanceDataArray.m_workOrder}&generic_table=maintenance_data">Delete</a></td>
                                </form>
                                </tr>    
                            </c:forEach> 
                        </table>
                    </div>       
                </div>
            </div>

        </div>

        <div id="Safety" class="tabcontent">
            <div class="row">
                <div class="column" style="background-color: #717e99;">
                    <h2>Safety Checks</h2>
                    <button class="accordion">Checklist</button> 
                    <div class ="panel">
                        <table class="table">
                            <th>In the Shop</th>
                            <tr class="tr">                
                                <td>
                                    <br>Everyone must wear safety glasses in a shop environment<br>
                                    <br>Check your clothes and hair before you walk into the shop<br>
                                    <br>Wear appropriate shoes. No open-toed sandals.<br>
                                    <br>Be aware of what's going on around you.<br>
                                    <br>If you don't know how to do something, ASK!<br>
                                </td>
                            </tr>     
                        </table>
                    </div>       
                </div>
            </div>
        </div>
        <script src="JavaScript/FullPageTabs.js" type="text/javascript"></script>
        <script src="JavaScript/AccordionButton.js" type="text/javascript"></script>
        <script src="JavaScript/Date.js" type="text/javascript"></script> 
    </body>
</html>
