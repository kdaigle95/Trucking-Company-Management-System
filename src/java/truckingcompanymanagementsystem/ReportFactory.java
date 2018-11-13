/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kdaig
 */
public class ReportFactory {
    
    ArrayList<PayrollReport> payroll = new ArrayList<PayrollReport>();
    
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
    
    public ArrayList makePayrollReport()
    {
        payroll.clear();
        ResultSet payrollReport = null;
        try{
            payrollReport = db.getGenericResultSet("SELECT employee_id_number, last_name, "
                    + "first_name, position, monthly_pay_rate FROM Personnel_Data ORDER BY monthly_pay_rate DESC");
        
            while(payrollReport.next())
            {
                payroll.add(new PayrollReport(
                        payrollReport.getInt("employee_id_number"), 
                        payrollReport.getString("last_name"), 
                        payrollReport.getString("first_name"),
                        payrollReport.getString("position"),
                        payrollReport.getString("monthly_pay_rate")
                ));
            }
        }
        catch (SQLException e){
            //do something
        }
        
        return payroll;
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
                    + "WHERE `date` BETWEEN \"" + startDate + "\" AND \"" + endDate + 
                    "\" ORDER BY date ASC");
        }
        catch (SQLException e)
        {
            //do something
        }
        return monthlyMaintReport;
        
    }
    
    public ResultSet makeManifestReport(int orderID)
    {
        ResultSet manifest = null;
        try
        {
            manifest = db.getGenericResultSet("SELECT items.item_name, "
                    + "manifests.item_amount, manifests.unit_cost, "
                    + "manifests.total_item_cost FROM items" 
                    + "INNER JOIN TCMS_Database.manifests ON manifests.order_id = "
                    + orderID + " AND manifests.item_id = items.item_id;");
        }
        catch (SQLException e)
        {
            //do stuff
        }
        return manifest;
    }
    
    public ResultSet makePurchaseReport(int orderID)
    {
        ResultSet purchase = null;
        try
        {
            purchase = db.getGenericResultSet("SELECT items.item_name, "
                    + "manifests.item_amount, manifests.unit_cost, "
                    + "manifests.total_item_cost, items.availability FROM items" 
                    + "INNER JOIN TCMS_Database.manifests ON manifests.order_id = "
                    + orderID + " AND manifests.item_id = items.item_id;");
        }
        catch (SQLException e)
        {
            //do stuff
        }
        return purchase;
    }

}
