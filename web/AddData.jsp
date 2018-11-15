<%-- 
    Document   : AddData
    Created on : Nov 10, 2018, 3:35:10 PM
    Author     : Andrea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/AddData.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add JSP</title>
    </head>
    <body>
        <h1>TCMS Form</h1>
        <div class="contanier">
        <%
            switch(request.getQueryString()){
                
                case "incoming_shipping":
                    %>
                        <form action="AddDataServlet">
                            <h2>New Shipment</h2>
                                <input type="hidden" name="generic_table" value=" <%=request.getQueryString()%>"/>
                                Order ID:<input type="text" name="m_orderID" placeholder="Order Number" autofocus/><br>
                                Source Company:<input type="text" name="m_sourceCompany" placeholder="Source Company" autofocus/><br>
                                Address:<input type="text" name="m_address" placeholder="Address" autofocus/><br>
                                City:<input type="text" name="m_city" placeholder="City" autofocus/><br>
                                State:<input type="text" name="m_state" placeholder="State" autofocus/><br>
                                Zip:<input type="text" name="m_zip" placeholder="Zip" autofocus/><br>
                                Truck ID:<input type="text" name="m_truckID" placeholder="Truck ID" autofocus/><br>
                                Departure Date:<input type="text" name="m_departureDate" placeholder="YYYY-MM-DD" autofocus/><br>
                                Estimated Arrival Date:<input type="text" name="m_estArrival" placeholder="YYYY-MM-DD" autofocus/><br>
                                Has Arrived:<input type="text" name="m_arrivalConf" placeholder="True or False" autofocus/><br>
                                Driver ID:<input type="text" name="m_driverID" placeholder="Driver ID" autofocus/><br>
                                Has Paid:<input type="text" name="m_paymentConf" placeholder="True or False" autofocus/><br>
                                <input type="submit" value="submit">
                        </form>
                    <%
                        break;
                case "outgoing_shipping":
                    %>
                        <form action="AddDataServlet">
                            <h2>Add Outgoing Shipment</h2>
                                <input type="hidden" name="generic_table" value=" <%=request.getQueryString()%>"/>
                                Order ID:<input type="text" name="m_orderID" placeholder="Order ID" autofocus/><br>
                                Source Company:<input type="text" name="m_destinationCompany" placeholder="Source Company" autofocus/><br>
                                Company Address:<input type="text" name="m_destinationCompanyAddress" placeholder="Address" autofocus/><br>
                                City:<input type="text" name="m_destinationCompanyCity" placeholder="City" autofocus/><br>
                                State:<input type="text" name="m_destinationCompanyState" placeholder="State" autofocus/><br>
                                Zip:<input type="text" name="m_destinationCompanyZip" placeholder="Zip" autofocus/><br>
                                Truck ID:<input type="text" name="m_truckID" placeholder="Truck ID" autofocus/><br>
                                Departure Date:<input type="text" name="m_departureDate" placeholder="YYYY-MM-DD" autofocus/><br>
                                Estimated Arrival Date:<input type="text" name="m_estArrival" placeholder="YYYY-MM-DD" autofocus/><br>
                                Has Arrived:<input type="text" name="m_arrivalConf" placeholder="True or False" autofocus/><br>
                                Driver ID:<input type="text" name="m_driverID" placeholder="Driver ID" autofocus/><br>
                                Has Paid:<input type="text" name="m_paymentConf" placeholder="True or False" autofocus/><br>
                                <input type="submit" value="submit">
                        </form>
                    <%
                        break;
                case "vehicle_data":
                    %>
                        <form action="AddDataServlet">
                            <h2>New Vehicle Data</h2>
                                <input type="hidden" name="generic_table" value=" <%=request.getQueryString()%>"/>
                                Vin Number:<input type="text" name="m_vin" placeholder="Vin" autofocus/><br>
                                Truck Brand:<input type="text" name="m_truckBrand" placeholder="Truck Brand" autofocus/><br>
                                Truck Year:<input type="text" name="m_truckYear" placeholder="Truck Year" autofocus/><br>
                                Truck Model:<input type="text" name="m_truckModel" placeholder="Truck Model" autofocus/><br>
                                Truck ID:<input type="text" name="m_truckID" placeholder="Truck ID" autofocus/><br>
                                Driver ID:<input type="text" name="m_driverID" placeholder="Driver ID" autofocus/><br>
                                Availability:<input type="text" name="m_availability" placeholder="Availability" autofocus/><br>
                                Parts List:<input type="text" name="m_partsList" placeholder="Parts List" autofocus/><br>
                                <input type="submit" value="submit">
                        </form>
                    <%
                        break;
                case "maintenance_data":
                    %>
                        <form action="AddDataServlet">
                            <h2>New Maintenance Data</h2>
                                <input type="hidden" name="generic_table" value=" <%=request.getQueryString()%>"/>
                                Work Order:<input type="text" name="m_workOrder" placeholder="Work Order Number" autofocus/><br>
                                Truck ID:<input type="text" name="m_truckID" placeholder="Truck ID" autofocus/><br>
                                Vin Number:<input type="text" name="m_vin" placeholder="Vin" autofocus/><br>
                                Maintenance ID Record:<input type="text" name="m_maintenanceID" placeholder="Record ID number" autofocus/><br>
                                Date:<input type="text" name="m_date" placeholder="YYYY-MM-DD" autofocus/><br>
                                Routine Inspection:<input type="text" name="m_jobDone" placeholder="Job Type" autofocus/><br>
                                Parts:<input type="text" name="m_parts" placeholder="List all parts" autofocus/><br>
                                Cost:<input type="text" name="m_cost" placeholder="Dollar Amount" autofocus/><br>
                                Detailed Report:<input type="text" name="m_report" placeholder="Details of Inspection" autofocus/><br>
                                <input type="submit" value="submit">
                        </form>
                    <%
                        break;
                case "Personnel_Data":
                    %>
                        <form action="AddDataServlet">
                            <h2>New Personnel</h2>
                                <input type="hidden" name="generic_table" value=" <%=request.getQueryString()%>"/>
                                Employee ID:<input type="text" name="m_employeeID" placeholder="Employee ID" autofocus/><br>
                                First Name:<input type="text" name="m_firstName" placeholder="First Name" autofocus/><br>
                                Middle Name:<input type="text" name="m_middleName" placeholder="Middle Name" autofocus/><br>
                                Last Name:<input type="text" name="m_lastName" placeholder="Last Name" autofocus/><br>
                                Address:<input type="text" name="m_streetAddress" placeholder="Address" autofocus/><br>
                                City:<input type="text" name="m_city" placeholder="City" autofocus/><br>
                                State:<input type="text" name="m_state" placeholder="State" autofocus/><br> 
                                Zip:<input type="text" name="m_zip" placeholder="Zip" autofocus/><br>
                                Home Phone:<input type="text" name="m_homePhone" placeholder="Home Phone" autofocus/><br>
                                Cell Phone:<input type="text" name="m_cellPhone" placeholder="Cell Phone" autofocus/><br>
                                Years with the company:<input type="text" name="m_years" placeholder="Years" autofocus/><br>
                                Position:<input type="text" name="m_position" placeholder="Position" autofocus/><br>
                                Salary:<input type="text" name="m_salary" placeholder="Salary" autofocus/><br>
                                Monthly Pay Rate:<input type="text" name="m_payrate" placeholder="Pay Rate" autofocus/><br>
                                Assignment:<input type="text" name="m_assignment" placeholder="Assignment" autofocus/><br>
                                <input type="submit" value="submit">
                        </form>
                    <%
                        break;
                default:
                break;
            }
        %>
        </div>
    </body>
</html>
