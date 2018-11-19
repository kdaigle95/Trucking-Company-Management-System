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
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="CSS/FullPageTabs.css" rel="stylesheet" type="text/css"/>
        <title>TCMS</title>
    </head>
    <body>
        <h1>Driver Access User</h1>
        <div align ="right">
            <form action="Logout.jsp">
                <input type ="submit" value="logout" name ="logout" id="form_submit"/>
            </form>
        </div>    
        <button class="tablink" onclick="openPage('Home', this, 'rgba(9,21,52,0.98)')" id="defaultOpen">Home</button>

        <button class="tablink" onclick="openPage('Shipping', this, 'rgba(9,21,52,0.98)')" >Shipments</button>

        <button class="tablink" onclick="openPage('Navigate', this, 'rgba(9,21,52,0.98)')">Navigate</button>

        <button class="tablink" onclick="openPage('Safety', this, 'rgba(9,21,52,0.98)')">Safety</button>

        <div id="Home" class="tabcontent">
            <h3>Home</h3>
            <p id = "date"></p>
            <p>Company Info</p>      
        </div>

        <div id="Shipping" class="tabcontent" >
            <div class="row">
                <div class="column" style="background-color: #717e99;">
                    <h2>Incoming Shipments</h2>
                    <button class="accordion">Shipment pick-ups</button> 
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
                            <th>Purchase Order</th>
                                <c:forEach items="${driverIncomingArray}" var="driverIncomingArray" begin="0">
                                <tr class="tr">
                                    <td>${driverIncomingArray.m_orderID}</td>
                                    <td>${driverIncomingArray.m_sourceCompany}</td>
                                    <td>${driverIncomingArray.m_address}</td>
                                    <td>${driverIncomingArray.m_city}</td>
                                    <td>${driverIncomingArray.m_state}</td>
                                    <td>${driverIncomingArray.m_zip}</td>
                                    <td>${driverIncomingArray.m_truckID}</td>
                                    <td>${driverIncomingArray.m_departureDate}</td>
                                    <td>${driverIncomingArray.m_estArrival}</td>
                                </tr>    
                            </c:forEach> 
                        </table>
                    </div>
                </div>
                <div class="column" style="background-color: #717e99;">
                    <h2>Outgoing Shipments</h2>
                    <button class="accordion">Deliveries</button>
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
                            <c:forEach items="${driverOutgoingArray}" var="driverOutgoingArray" begin="0">
                                <tr class="tr">      
                                    <td>${driverOutgoingArray.m_orderID}</td>
                                    <td>${driverOutgoingArray.m_destinationCompany}</td>
                                    <td>${driverOutgoingArray.m_destinationCompanyAddress}</td>
                                    <td>${driverOutgoingArray.m_destinationCompanyCity}</td>
                                    <td>${driverOutgoingArray.m_destinationCompanyState}</td>
                                    <td>${driverOutgoingArray.m_destinationCompanyZip}</td>
                                    <td>${driverOutgoingArray.m_truckID}</td>
                                    <td>${driverOutgoingArray.m_departureDate}</td>
                                    <td>${driverOutgoingArray.m_estArrival}</td>
                                </tr>    
                            </c:forEach> 

                        </table>
                    </div>                
                </div>
            </div>
        </div>

        <div id="Navigate" class="tabcontent">
            <p>Navigation brought to you by Google Maps API</p>

            <div id="googleMap" style="width:100%;height:100%;"></div>

            <script>
                function myMap() {
                    var mapProp = {
                        center: new google.maps.LatLng(37.0902, -95.7129),
                        zoom: 4,
                    };
                    var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
                }
            </script>

            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB8jxwJ1CTRfiujiAu4ZZABGJMhu2Gjj8g&callback=myMap"></script>

    </body>
</html>
</div>

<div id="Safety" class="tabcontent">
    <h3>Safety Checks</h3>
    <p>Ways to prevent accidents and stay safe on the road:</p>
    <div class="row">
        <div class="column" style="background-color: #717e99;">
            <button class="accordion">Checklist</button> 
            <div class ="panel">
                <table class="table">
                    <th>On the Road</th>
                    <tr class="tr">                
                        <td>
                            <br>Wear Your Seatbelt<br>
                            <br>Avoid Using Your Cell Phone<br>
                            <br>Be Aware of Speed Limits<br>
                            <br>Slow Down for Turns/Curves<br>
                            <br>Maintain a Proper Stopping Distance<br>
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
