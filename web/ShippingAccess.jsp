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
        <h1>Shipping Access User</h1>
        <div align ="right">
            <form action="Logout.jsp">
                <input type ="submit" value="logout" name ="logout" id="form_submit"/>
            </form>
        </div>    
        <button class="tablink" onclick="openPage('Home', this, 'rgba(9,21,52,0.98)')" id="defaultOpen">Home</button>

        <button class="tablink" onclick="openPage('Shipping', this, 'rgba(9,21,52,0.98)')" >Shipping</button>

        <button class="tablink" onclick="openPage('Equipment', this, 'rgba(9,21,52,0.98)')">Equipment</button>

        <button class="tablink" onclick="openPage('Maintenance', this, 'rgba(9,21,52,0.98)')">Maintenance</button>

        <div id="Home" class="tabcontent">
            <h3>Home</h3>
            <p id = "date"></p>
            <p>Shipping Info</p>
        </div>

        <div id="Shipping" class="tabcontent" >

            <div class="row">
                <div class="column" style="background-color: #717e99;">
                    <h2>Incoming Shipments</h2>           
                    <div>
                        <a href="AddData.jsp?incoming_shipping">
                            <button class="button">Add New Shipment</button>  
                        </a>
                    </div>
                    <button class="accordion">Pick-ups</button>
                    <div class ="panel">                       
                        <table class="table">
                            <th>Order ID</th>
                            <th>Source Company</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Zip</th>
                            <th>Truck ID</th>
                            <th>Departure Date</th>
                            <th>Estimated Arrival Date</th>
                            <th>Has Arrived</th>
                            <th>Driver ID</th>
                            <th>Has Paid</th>
                            <th>Modify Contents</th>
                            <th>Delete</th>
                            <th>Link to Purchase Order</th>
                                <c:forEach items="${incomingShippingArray}" var="incomingShippingArray" begin="0">
                                <tr class="tr">
                                <form action="UpdateDataServlet" method="post">
                                    <input type="hidden" name="generic_table" value="incoming_shipping"/>
                                    <td><input type="text" name="m_orderID" value="${incomingShippingArray.m_orderID}"></td>
                                    <td><input type="text" name="m_sourceCompany" value="${incomingShippingArray.m_sourceCompany}"></td>
                                    <td><input type="text" name="m_address" value="${incomingShippingArray.m_address}"></td>
                                    <td><input type="text" name="m_city" value="${incomingShippingArray.m_city}"></td>
                                    <td><input type="text" name="m_state" value="${incomingShippingArray.m_state}"></td>
                                    <td><input type="text" name="m_zip" value="${incomingShippingArray.m_zip}"></td>
                                    <td><input type="text" name="m_truckID" value="${incomingShippingArray.m_truckID}"></td>
                                    <td><input type="text" name="m_departureDate" value="${incomingShippingArray.m_departureDate}"></td>
                                    <td><input type="text" name="m_estArrival" value="${incomingShippingArray.m_estArrival}"></td>
                                    <td><input type="text" name="m_arrivalConf" value="${incomingShippingArray.m_arrivalConf}"></td>
                                    <td><input type="text" name="m_driverID" value="${incomingShippingArray.m_driverID}"></td>
                                    <td><input type="text" name="m_paymentConf" value="${incomingShippingArray.m_paymentConf}"></td>
                                    <td><input type="submit" value="Update"></td>
                                    <td><a href="DeleteData.jsp?id=${incomingShippingArray.m_orderID}&generic_table=incoming_shipping">Delete</a></td>
                                    <td><a href="PurchaseOrderServlet?orderID=${incomingShippingArray.m_orderID}&generic_table=incoming_shipping"><input type="button" value="Purchase Order" name="Purchase Order"/></a>

                                </form>
                                </tr>    
                            </c:forEach>  
                        </table>
                    </div> 
                </div>
                <div class="column" style="background-color: #717e99;">
                    <h2>Outgoing Shipments</h2>
                    <div>
                        <a href="AddData.jsp?outgoing_shipping">
                            <button class="button">Add Delivery</button>       
                        </a>
                    </div>
                    <button class="accordion">Deliveries</button>
                    <div class ="panel">                  
                        <table class="table">   
                            <th>Order ID</th>
                            <th>Destination Company</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Zip</th>
                            <th>Truck ID</th>
                            <th>Departure Date</th>
                            <th>Estimated Arrival</th>
                            <th>Has Arrived</th>
                            <th>Driver ID</th>
                            <th>Has Paid</th>
                            <th>Modify Contents</th>
                            <th>Delete</th>
                            <th>Link to Shipping Manifest</th>
                            <th>Link to Purchase Order</th>

                            <c:forEach items="${outgoingShippingArray}" var="outgoingShippingArray" begin="0">
                                <tr class="tr">
                                <form action="UpdateDataServlet" method="post">
                                    <input type="hidden" name="generic_table" value="outgoing_shipping"/> 
                                    <td><input type="text" name="m_truckID" value="${outgoingShippingArray.m_orderID}"></td>
                                    <td><input type="text" name="m_destinationCompany" value="${outgoingShippingArray.m_destinationCompany}"></td>
                                    <td><input type="text" name="m_destinationCompanyAddress" value="${outgoingShippingArray.m_destinationCompanyAddress}"></td>
                                    <td><input type="text" name="m_destinationCompanyCity" value="${outgoingShippingArray.m_destinationCompanyCity}"></td>
                                    <td><input type="text" name="m_destinationCompanyState" value="${outgoingShippingArray.m_destinationCompanyState}"></td>
                                    <td><input type="text" name="m_destinationCompanyZip" value="${outgoingShippingArray.m_destinationCompanyZip}"></td>
                                    <td><input type="text" name="m_truckID" value="${outgoingShippingArray.m_truckID}"></td>
                                    <td><input type="text" name="m_departureDate" value="${outgoingShippingArray.m_departureDate}"></td>
                                    <td><input type="text" name="m_estArrival" value="${outgoingShippingArray.m_estArrival}"></td>
                                    <td><input type="text" name="m_arrivalConf" value="${outgoingShippingArray.m_arrivalConf}"></td>
                                    <td><input type="text" name="m_driverID" value="${outgoingShippingArray.m_driverID}"></td>
                                    <td><input type="text" name="m_paymentConf" value="${outgoingShippingArray.m_paymentConf}"></td>
                                    <td><input type="submit" value="Update"></td>
                                    <td><a href="DeleteData.jsp?id=${outgoingShippingArray.m_orderID}&generic_table=outgoing_shipping">Delete</a></td>
                                    <td><a href="ManifestServlet?orderID=${outgoingShippingArray.m_orderID}&generic_table=incoming_shipping"><input type="button" value="Manifest" name="Manifest"/></a>
                                    <td><a href="PurchaseOrderServlet?orderID=${outgoingShippingArray.m_orderID}&generic_table=incoming_shipping"><input type="button" value="Purchase Order" name="Purchase Order"/></a>
                                </form>
                                </tr>    
                            </c:forEach>
                        </table>

                    </div>                
                </div>
            </div>
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
                    <button class="accordion">Active Vehicles</button> 
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
                                    <td><a href="PartsListServlet?truckID=${vehicleDataArray.m_truckID}&generic_table=vehicle_data"><input type="button" value="Parts List" name="Parts List"/></a></td>
                                    <td><a href="TruckMaintenanceServlet?truckID=${vehicleDataArray.m_truckID}&generic_table=vehicle_data"><input type="button" value="Maintenance Report" name="Maintenance"/></a></td>
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
                    <h2>Maintenance</h2>
                    <div>
                        <a href="AddData.jsp?maintenance_data">
                            <button class="button">Add New Record</button>       
                        </a>
                    </div>
                    <button class="accordion">Routine Maintenance and Repairs</button> 
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
        <script src="JavaScript/FullPageTabs.js" type="text/javascript"></script>
        <script src="JavaScript/AccordionButton.js" type="text/javascript"></script>
        <script src="JavaScript/Date.js" type="text/javascript"></script>  
    </body>
</html>
