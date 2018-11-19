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
        <div class="loop-wrapper">
            <div class="mountain"></div>
            <div class="hill"></div>
            <div class="tree"></div>
            <div class="tree"></div>
            <div class="tree"></div>
            <div class="rock"></div>
            <div class="truck"></div>
            <div class="wheels"></div>
        </div> 
        <div class="loginwrapper">
            <form class="login" ACTION="DataServlet" METHOD="GET">  
                <p class="title">Log in</p>
                <input type="text" placeholder="Username" name ="username"autofocus/><br>
                <i class="fa fa-user"></i>
                <input type="password" placeholder="Password" name="password" autofocus/>
                <i class="fa fa-key"></i>
                <p >
                <a class="a" href="#">Forgot your password?</a>
                </p>
                <button class="button">
                    <i class="spinner"></i>
                    <span class="state">Submit</span>
                </button>
         
            </form>
                <footer>
                    <a target="blank">TCMS</a>
                </footer>
        </div>
    </body>  
</html>