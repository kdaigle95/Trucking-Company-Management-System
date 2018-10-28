/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

import java.sql.*;

/**
 *
 * @author kdaig
 */
public class ReportFactory {
    
    private static ReportFactory instance = null;
    private Database db = Database.getInstance();
    
    public ReportFactory() 
    {
        
    }
    
    public ReportFactory getInstance()
    {
        if(instance == null)
            instance = new ReportFactory();
        
        return instance;
    }
    
    public ResultSet makePayrollReport()
    {
        ResultSet payrollReport = null;
        try{
        payrollReport = db.getGenericResultSet("SELECT employee_id_number, last_name, "
                + "first_name, position, monthly_pay_rate FROM Personnel_Data ORDER BY monthly_pay_rate DESC");
        }
        catch (SQLException e){
            //do something
        }
        return payrollReport;
    }
    
    public ResultSet makeTruckMaintenanceReport(int truckID)
    {
        ResultSet truckReport = null;
        try 
        {
            truckReport = db.getGenericResultSet("SELECT * FROM maintenance_data "
                    + "WHERE truck_id = " + truckID + " ORDER BY date ASC");
        }
        catch (SQLException e)
        {
            //do something
        }
        return truckReport;
    }
    
    public ResultSet makeMonthlyMaintenanceReport(String startDate, String endDate)
    {
        ResultSet monthlyMaintReport = null;
        try 
        {
            monthlyMaintReport = db.getGenericResultSet("SELECT * FROM maintenance_data "
                    + "WHERE date BETWEEN " + startDate + " AND " + endDate + 
                    "ORDER BY date ASC");
        }
        catch (SQLException e)
        {
            //do something
        }
        return monthlyMaintReport;
        
    }
    

}
