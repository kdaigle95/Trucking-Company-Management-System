<%-- 
    Document   : personnel
    Created on : Oct 18, 2018, 9:00:09 PM
    Author     : Andrea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "truckingcompanymanagementsystem.Controller" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personnel Data</title>
    </head>
    <body>
        <h1>Preliminary Personnel View</h1>
        <%
            Controller ctrl = Controller.getInstance();
        %>
        <div class="tabtable">
            <ul class="tabs">
                <li><a href="#tab1">Tab 1</a></li>
                <li><a href="#tab2">Tab 2</a></li>
                <li><a href="#tab3">Tab 3</a></li>
            </ul>
            <div class="tabcontent">
                <div id="tab1" class="tab">
                    Tab 1 Contents
                </div>
                <div id="tab2" class="tab">
                    Tab 2 Contents
                </div>
                <div id="tab3" class="tab">
                    Tab 3 Contents
                </div>
            </div>
        </div>



    </body>
</html>
