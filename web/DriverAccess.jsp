<%-- 
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
        <h1>Driver Access User</h1>
        <p id = "date"></p>
        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
        <button class="tablink" onclick="openPage('Home', this, '#042844')" id="defaultOpen">Home</button>
       
        <button class="tablink" onclick="openPage('Shipments', this, '#042844')" >Shipments</button>
       
        <button class="tablink" onclick="openPage('Navigate', this, '#042844')">Navigate</button>
        
        <button class="tablink" onclick="openPage('Safety', this, '#042844')">Safety</button>

        <div id="Home" class="tabcontent">
            <h3>Home</h3>
            <p>Company Info</p>
            
        </div>
        
        <div id="Shipments" class="tabcontent" >
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
                               <td>${outgoingShippingArray.m_destinationCompany}</td>
                               <td>${outgoingShippingArray.m_destinationCompanyAddress}</td>
                               <td>${outgoingShippingArray.m_destinationCompanyState}</td>
                               <td>${outgoingShippingArray.m_destinationCompanyZip}</td>
                               <td>${outgoingShippingArray.m_deliveryDate}</td>
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
        
        <div id="Navigate" class="tabcontent">
            <h3>Home</h3>
            <p>Google Maps API</p>
            
        </div>
                    
        <div id="Safety" class="tabcontent">
            <h3>Stay Safe!</h3>
            <p>Ways to keep safe on the road.</p>
            
        </div>
        
     
        <script src="JavaScript/ScrollableTable.js" type="text/javascript"></script>
        <script src="JavaScript/FullPageTabs.js" type="text/javascript"></script>
        <script src="JavaScript/AccordionButton.js" type="text/javascript"></script>
          
    </body>
</html>
