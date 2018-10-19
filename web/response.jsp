<%-- 
    Document   : response
    Created on : Oct 11, 2018, 9:39:57 AM
    Author     : Andrea
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link href="style.css/userStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1> Welcome to TCMS </h1>
        <h2 class="user"> President's Page </h2>
        <div class="wrapper">
        
        <p> User page </p> 
        <div>
           <br><br/>
           <select name="Placeholder" multiple="multiple">
                <option action="personnel.jsp" mehtod="post">Personnel Data</option>
                <option>Equipment Data</option>
                <option>Shipping Data</option>
                <option>Maintenance Data</option>
                <option>Drivers</option>
                <option>Reports</option>
           </select>
            
            <br><br/>
        </div>
        </div>
    </body>
</html>
