/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kdaig
 * manifest and purchase order functions updated by Justin on 11/16/18
 */
public class ReportGeneration {

    ArrayList<PayrollReport> payroll = new ArrayList<PayrollReport>();
    ArrayList<Maintenance> monthlyMaint = new ArrayList<Maintenance>();
    ArrayList<Maintenance> truckMaint = new ArrayList<Maintenance>();
    ArrayList<PartList> partList = new ArrayList<PartList>();
    ArrayList<PurchaseOrder> purchaseList = new ArrayList<PurchaseOrder>();
    ArrayList<Manifest> manifestList = new ArrayList<Manifest>();
    private static ReportGeneration instance = null;
    private Database db = Database.getInstance();

    public ReportGeneration() {

    }

    public ReportGeneration getInstance() {
        if (instance == null) {
            instance = new ReportGeneration();
        }

        return instance;
    }

    public ArrayList<PayrollReport> makePayrollReport() {
        payroll.clear();
        ResultSet payrollReport = null;
        try {
            payrollReport = db.getGenericResultSet("SELECT employee_id_number, last_name, "
                    + "first_name, position, monthly_pay_rate FROM Personnel_Data ORDER BY monthly_pay_rate DESC");

            while (payrollReport.next()) {
                payroll.add(new PayrollReport(
                        payrollReport.getInt("employee_id_number"),
                        payrollReport.getString("last_name"),
                        payrollReport.getString("first_name"),
                        payrollReport.getString("position"),
                        payrollReport.getString("monthly_pay_rate")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return payroll;
    }

    public ArrayList<Maintenance> makeTruckMaintenanceReport(int truckID) {
        truckMaint.clear();
        ResultSet truckReport = null;
        try {
            truckReport = db.getGenericResultSet("SELECT * FROM maintenance_data "
                    + "WHERE truck_id = " + truckID + " ORDER BY date ASC");

            while (truckReport.next()) {
                truckMaint.add(new Maintenance(
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
                
                System.out.println(truckMaint.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return truckMaint;
    }

    public ArrayList<Maintenance> makeMonthlyMaintenanceReport(String startDate, String endDate) {
        monthlyMaint.clear();
        ResultSet monthlyMaintReport = null;
        try {
            monthlyMaintReport = db.getGenericResultSet("SELECT * FROM maintenance_data "
                    + "WHERE `date` BETWEEN \"" + startDate + "\" AND \"" + endDate
                    + "\" ORDER BY date ASC");
            while (monthlyMaintReport.next()) {
                monthlyMaint.add(new Maintenance(
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
               System.out.println(monthlyMaintReport.getInt("work_order"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return monthlyMaint;

    }

    public ArrayList<PartList> makePartsList(int truckID) {
        partList.clear();
        ResultSet parts = null;
        try {
            parts = db.getGenericResultSet("SELECT parts.part_name, "
                    + "truck_parts.parts_count, truck_parts.part_source, "
                    + "truck_parts.cost, truck_parts.installation_date "
                    + "FROM parts "
                    + "INNER JOIN truck_parts ON truck_parts.truck_id = "
                    + truckID
                    + " AND truck_parts.part_id = parts.part_id;");

            while (parts.next()) {
                partList.add(new PartList(
                        parts.getString("part_name"),
                        parts.getInt("parts_count"),
                        parts.getString("part_source"),
                        parts.getString("cost"),
                        parts.getString("installation_date")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return partList;
    }

    public ArrayList<Manifest> makeManifestReport(int orderID) {
        manifestList.clear();
        ResultSet manifest = null;
        try {
            manifest = db.getGenericResultSet("SELECT items.item_name, "
                    + "manifests.item_amount, manifests.unit_cost, "
                    + "manifests.total_item_cost FROM items "
                    + "INNER JOIN TCMS_Database.manifests ON manifests.order_id = "
                    + orderID + " AND manifests.item_id = items.item_id;");
            
            while(manifest.next())
            {
                manifestList.add(ManifestFactory.getManifestFactory().createManifest(
                        manifest.getString("item_name"),
                        manifest.getInt("item_amount"),
                        manifest.getFloat("unit_cost"),
                        manifest.getFloat("total_item_cost")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return manifestList;
    }

     public ArrayList<PurchaseOrder> makePurchaseReport(int orderID) {
        purchaseList.clear();
        ResultSet purchase_results = null;
        try {
            purchase_results = db.getGenericResultSet("SELECT items.item_name, "
                    + "manifests.item_amount, manifests.unit_cost, "
                    + "manifests.total_item_cost, items.availability FROM items "
                    + "INNER JOIN TCMS_Database.manifests ON manifests.order_id = "
                    + orderID + " AND manifests.item_id = items.item_id;");

            while (purchase_results.next()) {
                purchaseList.add(PurchaseOrderFactory.getPurchaseOrderFactory().createPurchaseOrder(
                        purchase_results.getString("item_name"),
                        purchase_results.getInt("item_amount"),
                        purchase_results.getFloat("unit_cost"),
                        purchase_results.getFloat("total_item_cost"),
                        purchase_results.getString("availability")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return purchaseList;
    }
    
     
    public ArrayList<PurchaseOrder> getPurchaseList()
    {
        return purchaseList;
    }
    public ArrayList<PayrollReport> getPayroll() {
        return payroll;
    }

    public ArrayList<Maintenance> getMonthlyMaint() {
        return monthlyMaint;
    }

    public ArrayList<Maintenance> getTruckMaint() {
        return truckMaint;
    }

    public ArrayList<PartList> getPartsList() {
        return partList;
    }

}
