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
                           <c:forEach items="${vehicleDataArray}" var="vehicleDataArray" begin="0">
                           <tr class="tr">                
                               <td>${vehicleDataArray.m_vin}</td>
                               <td>${vehicleDataArray.m_truckBrand}</td>
                               <td>${vehicleDataArray.m_truckYear}</td>
                               <td>${vehicleDataArray.m_truckModel}</td>
                               <td>${vehicleDataArray.m_truckID}</td>
                               <td>${vehicleDataArray.m_driverID}</td>
                               <td><a href="PartsListServlet?truckID=${vehicleDataArray.m_truckID}&generic_table=vehicle_data"><input type="button" value="Parts List" name="Parts List"/></a></td>
                               <td><a href="TruckMaintenanceServlet?truckID=${vehicleDataArray.m_truckID}&generic_table=vehicle_data"><input type="button" value="Maintenance Report" name="Maintenance"/></a></td>
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
                <div class="column" style="background-color: #717e99;">
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
