<%-- 
    Document   : PayrollReport
    Created on : Nov 17, 2018, 7:51:36 PM
    Author     : justi
--%>

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
        <form action="PayrollServlet">
            <h1>Monthly Payroll Report</h1>
            <input type="hidden" name="truckID" value="<%=request.getParameter("id")%>"/>
            <input type="submit" value="submit">

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

