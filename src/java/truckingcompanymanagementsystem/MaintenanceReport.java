/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

/**
 *
 * @author kdaig
 */
public class MaintenanceReport {
    
    private int workOrder;
    private int truckID;
    private String vin;
    private int maintenanceID;
    private String date;
    private String jobDone;
    private String parts;
    private String cost;
    private String desc;

    protected MaintenanceReport(int workOrder, int truckID, String vin, 
            int maintenanceID, String date, String jobDone, String parts, 
            String cost, String desc) {
        this.workOrder = workOrder;
        this.truckID = truckID;
        this.vin = vin;
        this.maintenanceID = maintenanceID;
        this.date = date;
        this.jobDone = jobDone;
        this.parts = parts;
        this.cost = cost;
        this.desc = desc;
    }

    protected int getWorkorder() {
        return workOrder;
    }

    protected void setWorkOrder(int workOrder) {
        this.workOrder = workOrder;
    }

    protected int getTruckid() {
        return truckID;
    }

    protected void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    protected String getVin() {
        return vin;
    }

    protected void setVin(String vin) {
        this.vin = vin;
    }

    protected int getMaintenanceid() {
        return maintenanceID;
    }

    protected void setMaintenanceID(int maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    protected String getDate() {
        return date;
    }

    protected void setDate(String date) {
        this.date = date;
    }

    protected String getJobdone() {
        return jobDone;
    }

    protected void setJobDone(String jobDone) {
        this.jobDone = jobDone;
    }

    protected String getParts() {
        return parts;
    }

    protected void setParts(String parts) {
        this.parts = parts;
    }

    protected String getCost() {
        return cost;
    }

    protected void setCost(String cost) {
        this.cost = cost;
    }

    protected String getDesc() {
        return desc;
    }

    protected void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
