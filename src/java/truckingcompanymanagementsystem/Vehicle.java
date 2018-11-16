/*
 * 10/30/18
 */
package truckingcompanymanagementsystem;

/**
 *
 * @author Andrea
 * 10/30/2018
 */
public class Vehicle {
    
    private String m_vin;
    private String m_truckBrand;
    private int m_truckYear;
    private String m_truckModel;
    private int m_truckID;
    private int m_driverID;
    private int m_availability;
    
    //Default Constructor
    public Vehicle(){
        this.m_vin = "333ABC444";
        this.m_truckBrand = "tonka";
        this.m_truckYear = 2018;
        this.m_truckModel = "tonka3000";
        this.m_truckID = 9999;
        this.m_driverID = 11111111;
        this.m_availability = 0;

    }
    
    public Vehicle(String m_vin, String m_truckBrand, int m_truckYear, String m_truckModel, int m_truckID, int m_driverID, int m_availability){
        this.m_vin = m_vin;
        this.m_truckBrand = m_truckBrand;
        this.m_truckYear = m_truckYear;
        this.m_truckModel = m_truckModel;
        this.m_truckID = m_truckID;
        this.m_driverID = m_driverID;
        this.m_availability = m_availability;

    }   

    public String getM_vin() {
        return m_vin;
    }

    public void setM_vin(String m_vin) {
        this.m_vin = m_vin;
    }

    public String getM_truckBrand() {
        return m_truckBrand;
    }

    public void setM_truckBrand(String m_truckBrand) {
        this.m_truckBrand = m_truckBrand;
    }

    public int getM_truckYear() {
        return m_truckYear;
    }

    public void setM_truckYear(int m_truckYear) {
        this.m_truckYear = m_truckYear;
    }

    public String getM_truckModel() {
        return m_truckModel;
    }

    public void setM_truckModel(String m_truckModel) {
        this.m_truckModel = m_truckModel;
    }

    public int getM_truckID() {
        return m_truckID;
    }

    public void setM_truckID(int m_truckID) {
        this.m_truckID = m_truckID;
    }
    
    public int getM_driverID() {
        return m_driverID;
    }

    public void setM_driverID(int m_driverID) {
        this.m_driverID = m_driverID;
    }
    
    public int getM_availability() {
        return m_availability;
    }

    public void setM_availability(int m_availability) {
        this.m_availability = m_availability;
    }
   
}
