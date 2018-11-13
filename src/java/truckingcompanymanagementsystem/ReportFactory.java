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
    ArrayList<MaintenanceReport> monthlyMaint = new ArrayList<MaintenanceReport>();
    ArrayList<MaintenanceReport> truckMaint = new ArrayList<MaintenanceReport>();
    
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
    
    public ArrayList makeTruckMaintenanceReport(int truckID)
    {
        truckMaint.clear();
        ResultSet truckReport = null;
        try 
        {
            truckReport = db.getGenericResultSet("SELECT * FROM maintenance_data "
                    + "WHERE truck_id = " + truckID + " ORDER BY date ASC");
            
            while(truckReport.next())
            {
                monthlyMaint.add(new MaintenanceReport(
                        truckReport.getInt("work_order"),
                        truckReport.getInt("truck_id"),
                        truckReport.getString("truck_vin"),
                        truckReport.getInt("maintenance_id"),
                        truckReport.getString("date"),
                        truckReport.getString("job_done"),
                        truckReport.getString("parts"),
                        truckReport.getString("cost"),
                        truckReport.getString("detailed_report")
                ));
            }
        }
        catch (SQLException e)
        {
            //do something
        }
        return truckMaint;
    }
    
    public ArrayList makeMonthlyMaintenanceReport(String startDate, String endDate)
    {
        monthlyMaint.clear();
        ResultSet monthlyMaintReport = null;
        try 
        {
            monthlyMaintReport = db.getGenericResultSet("SELECT * FROM maintenance_data "
                    + "WHERE `date` BETWEEN \"" + startDate + "\" AND \"" + endDate + 
                    "\" ORDER BY date ASC");
            while(monthlyMaintReport.next())
            {
                monthlyMaint.add(new MaintenanceReport(
                        monthlyMaintReport.getInt("work_order"),
                        monthlyMaintReport.getInt("truck_id"),
                        monthlyMaintReport.getString("truck_vin"),
                        monthlyMaintReport.getInt("maintenance_id"),
                        monthlyMaintReport.getString("date"),
                        monthlyMaintReport.getString("job_done"),
                        monthlyMaintReport.getString("parts"),
                        monthlyMaintReport.getString("cost"),
                        monthlyMaintReport.getString("detailed_report")
                ));
            }
        }
        catch (SQLException e)
        {
            //do something
        }
        return monthlyMaint;
        
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
    
    public ArrayList<PayrollReport> getPayroll() {
        return payroll;
    }

    public ArrayList<MaintenanceReport> getMonthlyMaint() {
        return monthlyMaint;
    }

    public ArrayList<MaintenanceReport> getTruckMaint() {
        return truckMaint;
    }
    

}
