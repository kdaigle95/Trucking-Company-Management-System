<%-- 
    Document   : DeleteData
    Created on : Nov 10, 2018, 3:34:58 PM
    Author     : Andrea

--%>
<link href="CSS/DeleteData.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete JSP</title>
    </head>
    <body>
        <h1>Delete Data</h1>
        <div align="center">
            <h2>Are you sure you want to delete?<br>
                Click the button to confirm</h2>
            
            <form action="DeleteDataServlet">
                <input type="hidden" name="primary_key" value="<%=request.getParameter("id")%>"/>
                <input type="hidden" name="generic_table" value="<%=request.getParameter("generic_table")%>"/>
                
            </form>
            <button class="button">Confirm Delete</button>    
         
        </div>
    </body>
</html>
