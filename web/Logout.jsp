<%-- 
    Document   : Logout
    Created on : Nov 16, 2018, 8:06:34 PM
    Author     : justin
--%>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "truckingcompanymanagementsystem.*" %>
<%@page import = "javax.servlet.http.*,javax.servlet.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trucking Company Management System</title>    
        <link href="CSS/Login.css" rel="stylesheet" type="text/css"/>
        <script src="Javascript/LoginButton.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Trucking Company Management System</h1>
        <h3>"Thanks for using our software!"</h3>
        <div class ="panel" align ="center">
            <form action="LogoutServlet">
            <h1>Click logout to exit or click back to return to previous page</h1>
            <button class="button">Logout</button>
            </form>
            <button class="button" onclick="history.back()">Back</button>           
        </div>
    </body>  
</html>
