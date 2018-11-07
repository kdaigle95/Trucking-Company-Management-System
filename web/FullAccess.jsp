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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="style.css/FullPageTabs.css" rel="stylesheet" type="text/css"/>
        <title>TCMS</title>
    </head>
    <body>
        <h1>Full Access User</h1>
        <p id = "date"></p>
        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
        <button class="tablink" onclick="openPage('Home', this, '#042844')" id="defaultOpen">Home</button>
       
        <button class="tablink" onclick="openPage('Shipping', this, '#042844')" >Shipping</button>
       
        <button class="tablink" onclick="openPage('Equipment', this, '#042844')">Equipment</button>
        
        <button class="tablink" onclick="openPage('Personnel', this, '#042844')">Personnel</button>

        <div id="Home" class="tabcontent">
            <h3>Home</h3>
            <p>Company Info</p>
            
        </div>
        
        <div id="Shipping" class="tabcontent" >
            <div class="row">
                <div class="column" style="background-color: #aaa;">
                    <h2>Incoming Shipments</h2>
                    <button class="accordion">Shipment pick-ups</button> 
                    <div class ="panel">
                        <table class="table" border='1'>
                            <th>Source Company</th>
                            <th>Address</th>
                            <th>State</th>
                            <th>Zip</th>
                            <th>Vehicle ID</th>
                            <th>Departure Date</th>
                            <th>Estimated Arrival Date</th>
                            <th>Has Arrived</th>
                            <tr>
                                <td>Info</td>    
                            </tr>
                        </table>
                    </div>
                    <button class="addShipmentButton">Add Shipment</button>
                    <button class="purchaseOrderButton">Purchase Order</button>
                </div>
                <div class="column" style="background-color: #bbb;">
                    <h2>Outgoing Shipments</h2>
                    <button class="accordion">Deliveries</button>
                    <div class ="panel">                  
                        <table class="table">
                           <th>Destination Company</th>
                           <th>Address</th>
                           <th>State</th>
                           <th>Zip</th>
                           <th>Delivery Date</th>
                           
                           <c:forEach items="${outgoingShippingArray}" var="outgoingShippingArray" begin="0">
                           <tr class="tr">
                               <td>${outgoingShippingArray.m_orderID}</td>
                               <td>${outgoingShippingArray.m_destinationCompany}</td>
                               <td>${outgoingShippingArray.m_destinationCompanyAddress}</td>
                               <td>${outgoingShippingArray.m_destinationCompanyState}</td>
                               <td>${outgoingShippingArray.m_destinationCompanyZip}</td>
                               <td><a href="edit.jsp?id=#">Edit</a></td>
                               <td><a href="delete.jsp?id=#">Delete</a></td>
                            </tr>    
                           </c:forEach> 
                           
                        </table>
                    
                    </div>                
                    <%--https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_button_split --%>
                    <button class="reportButton">Reports</button>
                    <div class="dropdown">
                        <button class="reportButton" style="border-left: 1px solid navy">
                            <i class="fa fa-caret-down"></i>
                        </button>
                        <div class="dropdown-content">
                            <a href="#">Incoming Report</a>
                            <a href="#">Outgoing Report</a>
                            <a href="#">Custom Report</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div id="Equipment" class="tabcontent">
            <h3>Vehicle and Maintenance Records</h3>
            <div class="row">
                <div class="column" style="background-color: #aaa;">
                    <h3>Vehicles</h3>
                    <button class="accordion">Vehicle</button> 
                    <div class ="panel">
                        <table class="table">
                           <th>Vin</th>
                           <th>Truck Brand</th>
                           <th>Truck Year</th>
                           <th>Truck Model</th>
                           <th>Truck ID</th>
                           <th>Driver ID</th>
                           <c:forEach items="${vehicleDataArray}" var="vehicleDataArray" begin="0">
                           <tr class="tr">                
                               <td>${vehicleDataArray.m_vin}</td>
                               <td>${vehicleDataArray.m_truckBrand}</td>
                               <td>${vehicleDataArray.m_truckYear}</td>
                               <td>${vehicleDataArray.m_truckModel}</td>
                               <td>${vehicleDataArray.m_truckID}</td>
                               <td>${vehicleDataArray.m_driverID}</td>
                               <td><a href="delete.jsp?id=${vehicleDataArray.m_truckID}">Delete</a></td>
                            </tr>    
                           </c:forEach> 
                        </table>
                    </div>       
                </div>
            </div>
            <div class="row">
                <div class="column" style="background-color: #aaa;">
                    <h3>Maintenance</h3>
                    <button class="accordion">Routine Maintenance and Repairs</button> 
                    <div class ="panel">
                        <table class="table">
                           <th>Oil Change</th>
                           <th>Radiator</th>
                           <th>Tires</th>
                           <th>Engine</th>
                           <th>Drive Train</th>
                           <th>Electronics</th>
                           <c:forEach items="${maintenanceArray}" var="vehicleDataArray" begin="0">
                           <tr class="tr">                
                               <td></td>
                            </tr>    
                           </c:forEach> 
                        </table>
                    </div>       
                </div>
            </div>
        </div>
        
        <div id="Personnel" class="tabcontent">
            <h3>Personnel</h3>
            <table class="tablelistjs" id="clients" >
                <th>ID</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Street Address</th>
                <th>State</th>
                <th>City</th>
                <th>Zip</th>
                <th>Home Phone</th>
                <th>Cell Phone</th>
                <th>Years at Company</th>
                <th>Position</th>
                <th>Salary</th>
                <th>Pay Rate</th>
                <th>Assignment</th>
               <%-- <div contenteditable='true'--%>
                    <c:forEach items="${personnelArray}" var="personnelArray" begin="0">
                    <tr class="tr">                
                        <td>${personnelArray.m_employeeID}</td>
                        <td>${personnelArray.m_firstName}</td>
                        <td>${personnelArray.m_middleName}</td>
                        <td>${personnelArray.m_lastName}</td>
                        <td>${personnelArray.m_streetAddress}</td>
                        <td>${personnelArray.m_state}</td>
                        <td>${personnelArray.m_city}</td>
                        <td>${personnelArray.m_zip}</td>
                        <td>${personnelArray.m_homePhone}</td>
                        <td>${personnelArray.m_cellPhone}</td>
                        <td>${personnelArray.m_years}</td>
                        <td>${personnelArray.m_position}</td>
                        <td>${personnelArray.m_salary}</td>
                        <td>${personnelArray.m_payrate}</td>
                        <td>${personnelArray.m_assignment}</td>
                        <td><a href="edit.jsp?id=${personnelArray.m_employeeID}">Edit</a></td>
                        <td><a href="delete.jsp?id=${personnelArray.m_employeeID}">Delete</a></td>
                     </tr>    
                    </c:forEach>
                     
               <%-- </div> --%>
            </table>
        </div>
        <script src="JavaScript/ScrollableTable.js" type="text/javascript"></script>
        <script src="JavaScript/FullPageTabs.js" type="text/javascript"></script>
        <script src="JavaScript/AccordionButton.js" type="text/javascript"></script>
          
    </body>
</html>
