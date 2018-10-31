/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

/**
 *
 * @author Andrea
 */
public class OutgoingShipping {
    
    private String m_destinationCompany;
    private String m_destinationCompanyAddress;
    private String m_destinationCompanyState;
    private String m_destinationCompanyZip;
    private String m_deliveryDate;
    
    
    public OutgoingShipping(){
        this.m_destinationCompany = "TCMS";
        this.m_destinationCompanyAddress = "9 Ave";
        this.m_destinationCompanyState = "Alabama";
        this.m_destinationCompanyZip = "35856";
        this.m_deliveryDate = "2018-11-27";
    }
    
    public OutgoingShipping(String m_destinationCompany, String m_destinationCompanyAddress, String m_destinationCompanyState, String m_destinationCompanyZip, String m_deliveryDate){
        this.m_destinationCompany = m_destinationCompany;
        this.m_destinationCompanyAddress = m_destinationCompanyAddress;
        this.m_destinationCompanyState = m_destinationCompanyState;
        this.m_destinationCompanyZip = m_destinationCompanyZip;
        this.m_deliveryDate = m_deliveryDate;
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

    public String getM_destinationCompanyState() {
        return m_destinationCompanyState;
    }

    public void setM_destinationCompanyState(String m_destinationCompanyState) {
        this.m_destinationCompanyState = m_destinationCompanyState;
    }

    public String getM_destinationCompanyZip() {
        return m_destinationCompanyZip;
    }

    public void setM_destinationCompanyZip(String m_destinationCompanyZip) {
        this.m_destinationCompanyZip = m_destinationCompanyZip;
    }

    public String getM_deliveryDate() {
        return m_deliveryDate;
    }

    public void setM_deliveryDate(String m_deliveryDate) {
        this.m_deliveryDate = m_deliveryDate;
    }
    
    
}
