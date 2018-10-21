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
        <table border="1" cellspacing="10" cellpadding="30">
            <thead>
                <tr>
                    <th>
                        <%
                            ctrl.GetPersonnelData();
                            int id = ctrl.getEmployeeID();
                            out.println(id);
                        %>
                    </th>
                    <th>
                        <%
                            ctrl.GetPersonnelData();
                            String name = ctrl.getEmployeeFirstName();
                            out.println(name);
                        %>
                    </th>
                    <th>
                        <%
                            ctrl.GetPersonnelData();
                            String sirName = ctrl.getEmployeeLastName();
                            out.println(sirName);
                        %>
                    </th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> 

                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
