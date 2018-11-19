<%-- 
    Document   : PartsList
    Created on : Nov 17, 2018, 9:28:54 PM
    Author     : kdaig
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parts List</title>
    </head>
    <style>
        table, td, th
        {
            border: 1px solid #ddd;
            text-align: left;
        }

        table
        {
            border-collapse: collapse;
            width: 100%;
        }

        th, td
        {
            padding: 15px;
        }
    </style>
    <body>
            <h1>Parts List</h1>

            <table class="table">
                <th>Name</th>
                <th>Count</th>
                <th>Source</th>
                <th>Cost</th>
                <th>Installation Date</th>
                    <c:forEach items="${partsDataArray}" var="partsDataArray" begin="0">
                    <tr class="tr"> 
                        <td>${partsDataArray.name}</td>
                        <td>${partsDataArray.count}</td>
                        <td>${partsDataArray.source}</td>
                        <td>${partsDataArray.cost}</td>
                        <td>${partsDataArray.date}</td>
                    </tr>    
                </c:forEach> 
            </table>
            <button type="button" name="back" onclick="history.back()">back</button>
        </form>
    </body>
</html>
