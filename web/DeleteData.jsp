<%-- 
    Document   : DeleteData
    Created on : Nov 10, 2018, 3:34:58 PM
    Author     : Andrea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete JSP</title>
    </head>
    <body>
        <h1>Delete Data</h1>
        <form action="DeleteDataServlet">
            <input type="hidden" name="primary_key" value="<%=request.getParameter("id")%>"/>
            <input type="hidden" name="generic_table" value="<%=request.getParameter("generic_table")%>"/>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
