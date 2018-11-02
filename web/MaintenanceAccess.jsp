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
        <h1>Maintenance Access User</h1>
        <p id = "date"></p>
        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
        <button class="tablink" onclick="openPage('Home', this, '#042844')" id="defaultOpen">Home</button>
       
        <button class="tablink" onclick="openPage('Equipment', this, '#042844')">Equipment</button>
        
        <button class="tablink" onclick="openPage('Maintenance', this, '#042844')">Maintenance</button>

        <button class="tablink" onclick="openPage('Shipping', this, '#042844')" >Safety</button>
        
        <div id="Home" class="tabcontent">
            <h3>Home</h3>
            <p>Company Info</p>
            
        </div>
 
        <div id="Equipment" class="tabcontent">
            <h3>Vehicles</h3>
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
                            </tr>    
                           </c:forEach> 
                        </table>
                    </div>       
                </div>
            </div>

        </div>
                    
        <div id="Maintenance" class="tabcontent">
            <h3>Maintenance Records</h3>
            <div class="row">
                <div class="column" style="background-color: #aaa;">
                    <button class="accordion">Routine Maintenance Records</button> 
                    <div class ="panel">
                        <table class="table">
                           <th>Service Number</th>
                           <th>Service Type</th>
                           <th>Date Serviced</th>
                           <c:forEach items="${routineMaintenanceArray}" var="vehicleDataArray" begin="0">
                           <tr class="tr">                
                               <td>${routineMaintenanceArray.m_serviceNo}</td>
                            </tr>    
                           </c:forEach> 
                        </table>
                    </div>       
                </div>
            </div>
            <div class="row">
                <div class="column" style="background-color: #aaa;">
                    <button class="accordion">Repair Records</button> 
                    <div class ="panel">
                        <table class="table">
                           <th>Oil Changes</th>
                           <th>Filter Changes</th>
                           <th>Tire Rotations</th>
                           <c:forEach items="${repairRecordsArray}" var="vehicleDataArray" begin="0">
                           <tr class="tr">                
                               <td>${repairRecordsArray.m_oilchanges}</td>
                            </tr>    
                           </c:forEach> 
                        </table>
                    </div>       
                </div>
            </div>
        </div>
        
        <div id="Safety" class="tabcontent">
            <h3>Safety Checks</h3>
            <p>Ways to prevent accidents</p>
            
        </div> 
        
        <script src="JavaScript/ScrollableTable.js" type="text/javascript"></script>
        <script src="JavaScript/FullPageTabs.js" type="text/javascript"></script>
        <script src="JavaScript/AccordionButton.js" type="text/javascript"></script>
          
    </body>
</html>
