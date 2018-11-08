/*
 * 
 */
package truckingcompanymanagementsystem;

/**
 * 11/07/18
 * @author Andrea
 */
public class Maintenance {
    
    private int m_workOrder;
    private int m_truckID;
    private String m_vin;
    private String m_maintenanceID;
    private String m_date;
    private String m_jobDone;
    private String m_parts;
    private String m_cost;
    private String m_report;
    
    
    public Maintenance(){
        this.m_workOrder = 0;
        this.m_truckID = 9999;
        this.m_vin = "vin";
        this.m_maintenanceID = "maintenance ID";
        this.m_date = "date";
        this.m_jobDone = "job";
        this.m_parts = "parts";
        this.m_cost = "cost";
        this.m_report = "report";
        
    }

    public Maintenance(int m_workOrder, int m_truckID, String m_vin, String m_maintenanceID, String m_date, String m_jobDone, String m_parts, String m_cost, String m_report) {
        this.m_workOrder = m_workOrder;
        this.m_truckID = m_truckID;
        this.m_vin = m_vin;
        this.m_maintenanceID = m_maintenanceID;
        this.m_date = m_date;
        this.m_jobDone = m_jobDone;
        this.m_parts = m_parts;
        this.m_cost = m_cost;
        this.m_report = m_report;
    }

    public int getM_workOrder() {
        return m_workOrder;
    }

    public void setM_workOrder(int m_workOrder) {
        this.m_workOrder = m_workOrder;
    }

    public int getM_truckID() {
        return m_truckID;
    }

    public void setM_truckID(int m_truckID) {
        this.m_truckID = m_truckID;
    }

    public String getM_vin() {
        return m_vin;
    }

    public void setM_vin(String m_vin) {
        this.m_vin = m_vin;
    }

    public String getM_maintenanceID() {
        return m_maintenanceID;
    }

    public void setM_maintenanceID(String m_maintenanceID) {
        this.m_maintenanceID = m_maintenanceID;
    }

    public String getM_date() {
        return m_date;
    }

    public void setM_date(String m_date) {
        this.m_date = m_date;
    }

    public String getM_jobDone() {
        return m_jobDone;
    }

    public void setM_jobDone(String m_jobDone) {
        this.m_jobDone = m_jobDone;
    }

    public String getM_parts() {
        return m_parts;
    }

    public void setM_parts(String m_parts) {
        this.m_parts = m_parts;
    }

    public String getM_cost() {
        return m_cost;
    }

    public void setM_cost(String m_cost) {
        this.m_cost = m_cost;
    }

    public String getM_report() {
        return m_report;
    }

    public void setM_report(String m_report) {
        this.m_report = m_report;
    }

    
}
