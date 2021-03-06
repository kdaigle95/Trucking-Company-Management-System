<%-- 
    Document   : PayrollReport
    Created on : Nov 17, 2018, 7:51:36 PM
    Author     : justi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/Report.css" rel="stylesheet" type="text/css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monthly Payroll</title>
    </head>
    <body>
            <table class="table">
                <th>ID</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Position</th>
                <th>Pay</th>
                <c:forEach items="${payrollReportDataArray}" var="payrollReportDataArray" begin="0">
                    <tr class="tr"> 
                        <td>${payrollReportDataArray.employeeID}</td>
                        <td>${payrollReportDataArray.lName}</td>
                        <td>${payrollReportDataArray.fName}</td>
                        <td>${payrollReportDataArray.position}</td>
                        <td>${payrollReportDataArray.pay}</td>
                    </tr>    
                </c:forEach> 
            </table>
            <button type="button" name="back" onclick="history.back()">back</button>
        </form>
    </body>
</html>

