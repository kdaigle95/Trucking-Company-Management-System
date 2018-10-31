<%-- 
    Document   : personnel
    Created on : Oct 18, 2018, 9:00:09 PM
    Author     : Andrea
    https://www.w3schools.com/howto/howto_js_full_page_tabs.asp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "truckingcompanymanagementsystem.Controller" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="style.css/FullPageTabs.css" rel="stylesheet" type="text/css"/>
        <title>TCMS</title>
    </head>
    <body>
        <h1>Preliminary Data Page View</h1>
        <%
            Controller ctrl = Controller.getInstance();
        %>        

        <button class="tablink" onclick="openPage('Home', this, '#0066ff')">Home</button>
        <button class="tablink" onclick="openPage('Shipping', this, '#009999')"id="defaultOpen">Shipping</button>
        <button class="tablink" onclick="openPage('Equipment', this, 'blue')">Equipment</button>
        <button class="tablink" onclick="openPage('Personnel', this, '#003399')">Personnel</button>

        <div id="Home" class="tabcontent">
            <h3>Home</h3>
            <p>Home is where the application works....</p>
        </div>
        
        <div id="Shipping" class="tabcontent">
            <h3>Shipping</h3>
            <p>Incoming and Outgoing Shipments</p>

            <div class="row">
                <div class="column" style="background-color: #aaa;">
                    <h2>Column 1 - Incoming Shipping</h2>
                    <button class="accordion">Incoming Section</button>
                    <div class ="panel">
                        <p>Table stuff</p>
                    </div>
                    
                </div>
                <div class="column" style="background-color: #bbb;">
                    <h2>Column 2 - Outgoing Shipping</h2>
                    <button class="accordion">Outgoing Section</button>
                    <div class ="panel">
                        <p>Table stuff</p>
                    </div>
                </div>
            </div>
        </div>
        
        <div id="Equipment" class="tabcontent">
            <h3>Vehicles</h3>
            <p>Vehicle and Maintenance Records</p>
        </div>
        
        <div id="Personnel" class="tabcontent">
            <h3>Personnel</h3>
            <p>Who we are.</p>
        </div>
        <script src="JavaScript/FullPageTabs.js" type="text/javascript"></script>
    </body>
</html>
