/*
 * 
 */
package truckingcompanymanagementsystem;

/**
 * 11/07/18
 * @author Andrea
 */
public class IncomingShipping {
    
    private int m_orderID;
    private String m_sourceCompany;
    private String m_address;
    private String m_city;
    private String m_state;
    private int m_zip;
    private String m_truckID;
    private String m_departureDate;
    private String m_estArrival;
    private String m_arrivalConf;
    private int m_driverID;
    private String m_paymentConf;
    
    
    public IncomingShipping(){
        this.m_orderID = 1;
        this.m_sourceCompany = "Target";
        this.m_address = "Electric Blvd";
        this.m_city = "Mobile";
        this.m_state = "AL";
        this.m_zip = 90210;
        this.m_truckID = "99999";
        this.m_departureDate = "2000-01-01 00:00:01";
        this.m_estArrival = "2000-01-01 00:00:01";
        this.m_arrivalConf = "TBD";
        this.m_driverID = 99999;
        this.m_paymentConf = "TBD";
                 
    }

    public IncomingShipping(int m_orderID, String m_sourceCompany, String m_address, String m_city, String m_state, int m_zip, String m_truckID, String m_departureDate, String m_estArrival, String m_arrivalConf, int m_driverID, String m_paymentConf) {
        this.m_orderID = m_orderID;
        this.m_sourceCompany = m_sourceCompany;
        this.m_address = m_address;
        this.m_city = m_city;
        this.m_state = m_state;
        this.m_zip = m_zip;
        this.m_truckID = m_truckID;
        this.m_departureDate = m_departureDate;
        this.m_estArrival = m_estArrival;
        this.m_arrivalConf = m_arrivalConf;
        this.m_driverID = m_driverID;
        this.m_paymentConf = m_paymentConf;
    }

    public int getM_orderID() {
        return m_orderID;
    }

    public void setM_orderID(int m_orderID) {
        this.m_orderID = m_orderID;
    }

    public String getM_sourceCompany() {
        return m_sourceCompany;
    }

    public void setM_sourceCompany(String m_sourceCompany) {
        this.m_sourceCompany = m_sourceCompany;
    }

    public String getM_address() {
        return m_address;
    }

    public void setM_address(String m_address) {
        this.m_address = m_address;
    }

    public String getM_city() {
        return m_city;
    }

    public void setM_city(String m_city) {
        this.m_city = m_city;
    }

    public String getM_state() {
        return m_state;
    }

    public void setM_state(String m_state) {
        this.m_state = m_state;
    }

    public int getM_zip() {
        return m_zip;
    }

    public void setM_zip(int m_zip) {
        this.m_zip = m_zip;
    }

    public String getM_truckID() {
        return m_truckID;
    }

    public void setM_truckID(String m_truckID) {
        this.m_truckID = m_truckID;
    }

    public String getM_departureDate() {
        return m_departureDate;
    }

    public void setM_departureDate(String m_departureDate) {
        this.m_departureDate = m_departureDate;
    }

    public String getM_estArrival() {
        return m_estArrival;
    }

    public void setM_estArrival(String m_estArrival) {
        this.m_estArrival = m_estArrival;
    }

    public String getM_arrivalConf() {
        return m_arrivalConf;
    }

    public void setM_arrivalConf(String m_arrivalConf) {
        this.m_arrivalConf = m_arrivalConf;
    }

    public int getM_driverID() {
        return m_driverID;
    }

    public void setM_driverID(int m_driverID) {
        this.m_driverID = m_driverID;
    }

    public String getM_paymentConf() {
        return m_paymentConf;
    }

    public void setM_paymentConf(String m_paymentConf) {
        this.m_paymentConf = m_paymentConf;
    }
    
    
    
}
