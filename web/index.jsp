<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "truckingcompanymanagementsystem.*" %>
<%@page import = "javax.servlet.http.*,javax.servlet.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trucking Company Management System</title>    
        <link href="style.css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="Javascript/LoginButton.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Trucking Company Management System</h1>
        <h3>"Managing your records for over 10 years"</h3>
        <div class="wrapper"> 
            <form class="login" ACTION="FullPageTabs.jsp" METHOD="post">
                <%
                   Controller ctrl = Controller.getInstance();
                   ctrl.getDatabase();
                   ctrl.startDatabase();
                %>
                
                <p class="title">Log in</p>
                <input type="text" placeholder="Username" autofocus/>
                <i class="fa fa-user"></i>
                <input type="password" placeholder="Password" autofocus/>
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