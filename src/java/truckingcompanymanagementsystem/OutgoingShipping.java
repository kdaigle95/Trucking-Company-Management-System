/*
 
 */
package truckingcompanymanagementsystem;

import java.util.Map;

/**
 * 10/29/18
 * @author Andrea
 */
public class OutgoingShipping {
    
    private int m_orderID;
    private String m_destinationCompany;
    private String m_destinationCompanyAddress;
    private String m_destinationCompanyCity;
    private String m_destinationCompanyState;
    private int m_destinationCompanyZip;
    private int m_truckID;
    private java.util.Date m_departureDate;
    private java.util.Date m_estArrival;
    private String m_arrivalConf;
    private int m_driverID;
    private String m_paymentConf;
    
    
    public OutgoingShipping(){
        this.m_orderID = 1;
        this.m_destinationCompany = "TCMS";
        this.m_destinationCompanyAddress = "9 Ave";
        this.m_destinationCompanyCity = "Mobile";
        this.m_destinationCompanyState = "AL";
        this.m_destinationCompanyZip = 90210;
        this.m_truckID = 99999;
        this.m_departureDate = null;
        this.m_estArrival = null;
        this.m_arrivalConf = "TBD";
        this.m_driverID = 99999;
        this.m_paymentConf = "TBD";
    }

    public OutgoingShipping(int m_orderID, String m_destinationCompany, String m_destinationCompanyAddress, String m_destinationCompanyCity, String m_destinationCompanyState, int m_destinationCompanyZip, int m_truckID, java.util.Date m_departureDate, java.util.Date m_estArrival, String m_arrivalConf, int m_driverID, String m_paymentConf) {
        this.m_orderID = m_orderID;
        this.m_destinationCompany = m_destinationCompany;
        this.m_destinationCompanyAddress = m_destinationCompanyAddress;
        this.m_destinationCompanyCity = m_destinationCompanyCity;
        this.m_destinationCompanyState = m_destinationCompanyState;
        this.m_destinationCompanyZip = m_destinationCompanyZip;
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

    public String getM_destinationCompany() {
        return m_destinationCompany;
    }

    public void setM_destinationCompany(String m_destinationCompany) {
        this.m_destinationCompany = m_destinationCompany;
    }

    public String getM_destinationCompanyAddress() {
        return m_destinationCompanyAddress;
    }

    public void setM_destinationCompanyAddress(String m_destinationCompanyAddress) {
        this.m_destinationCompanyAddress = m_destinationCompanyAddress;
    }

    public String getM_destinationCompanyCity() {
        return m_destinationCompanyCity;
    }

    public void setM_destinationCompanyCity(String m_destinationCompanyCity) {
        this.m_destinationCompanyCity = m_destinationCompanyCity;
    }

    public String getM_destinationCompanyState() {
        return m_destinationCompanyState;
    }

    public void setM_destinationCompanyState(String m_destinationCompanyState) {
        this.m_destinationCompanyState = m_destinationCompanyState;
    }

    public int getM_destinationCompanyZip() {
        return m_destinationCompanyZip;
    }

    public void setM_destinationCompanyZip(int m_destinationCompanyZip) {
        this.m_destinationCompanyZip = m_destinationCompanyZip;
    }

    public int getM_truckID() {
        return m_truckID;
    }

    public void setM_truckID(int m_truckID) {
        this.m_truckID = m_truckID;
    }

    public java.util.Date getM_departureDate() {
        return m_departureDate;
    }

    public void setM_departureDate(java.util.Date m_departureDate) {
        this.m_departureDate = m_departureDate;
    }

    public java.util.Date getM_estArrival() {
        return m_estArrival;
    }

    public void setM_estArrival(java.util.Date m_estArrival) {
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
