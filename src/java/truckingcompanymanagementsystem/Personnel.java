/*
 * 
 */
package truckingcompanymanagementsystem;

/**
 *
 * @author Andrea
 * 10/24/18
 */
public class Personnel {
    
    private String m_employeeID;
    private String m_firstName;
    private String m_middleName;
    private String m_lastName;
    private String m_streetAddress;
    private String m_city;
    private String m_state;
    private int m_zip;
    private String m_homePhone;
    private String m_cellPhone;
    private int m_years;
    private String m_position;
    private int m_salary;
    private int m_payrate;
    private String m_assignment;
    

    //Default Constructor
    public Personnel() {
        this.m_employeeID = "0";
        this.m_firstName = "Jannet";
        this.m_middleName = "Joline";
        this.m_lastName = "Jacobson";
        this.m_streetAddress = "90210";
        this.m_city = "RocketCity";
        this.m_state = "AL";
        this.m_zip = 99999;
        this.m_homePhone ="256-345-8779";
        this.m_cellPhone = "256-356-9814";
        this.m_years = 10;
        this.m_position = "Office Worker";
        this.m_salary = 80000;
        this.m_payrate = 4000;
        this.m_assignment = "none";

    }
    
    
    public Personnel(String m_employeeID, String m_firstName, String m_middleName, String m_lastName, String m_streetAddress, String m_city, String m_state, int m_zip, String m_homePhone, String m_cellPhone, int m_years, String m_position, int m_salary, int m_payrate, String m_assignment) {
        this.m_employeeID = m_employeeID;
        this.m_firstName = m_firstName;
        this.m_middleName = m_middleName;
        this.m_lastName = m_lastName;
        this.m_streetAddress = m_streetAddress;
        this.m_city = m_city;
        this.m_state = m_state;
        this.m_zip = m_zip;
        this.m_homePhone = m_homePhone;
        this.m_cellPhone = m_cellPhone;
        this.m_years = m_years;
        this.m_position = m_position;
        this.m_salary = m_salary;
        this.m_payrate = m_payrate;
        this.m_assignment = m_assignment;
        
        //this.m_count = m_count;
    }

    public String getM_employeeID() {
        return m_employeeID;
    }

    public void setM_employeeID(String m_employeeID) {
        this.m_employeeID = m_employeeID;
    }

    public String getM_firstName() {
        return m_firstName;
    }

    public void setM_firstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getM_middleName() {
        return m_middleName;
    }

    public void setM_middleName(String m_middleName) {
        this.m_middleName = m_middleName;
    }

    public String getM_lastName() {
        return m_lastName;
    }

    public void setM_lastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public String getM_streetAddress() {
        return m_streetAddress;
    }

    public void setM_streetAddress(String m_streetAddress) {
        this.m_streetAddress = m_streetAddress;
    }

    public String getM_state() {
        return m_state;
    }

    public void setM_state(String m_state) {
        this.m_state = m_state;
    }

    public String getM_city() {
        return m_city;
    }

    public void setM_city(String m_city) {
        this.m_city = m_city;
    }

    public int getM_zip() {
        return m_zip;
    }

    public void setM_zip(int m_zip) {
        this.m_zip = m_zip;
    }
    
    public String getM_homePhone(){
        return m_homePhone;
    }
    
    public void getM_homePhone(String m_homePhone){
        this.m_homePhone = m_homePhone;
    }

    public String getM_cellPhone(){
        return m_cellPhone;
    }
    
    public void getM_cellPhone(String m_cellPhone){
        this.m_cellPhone = m_cellPhone;
    }
    public int getM_years() {
        return m_years;
    }

    public void setM_years(int m_years) {
        this.m_years = m_years;
    }

    public String getM_position() {
        return m_position;
    }

    public void setM_position(String m_position) {
        this.m_position = m_position;
    }

    public int getM_salary() {
        return m_salary;
    }
    

    

    public void setM_salary(int m_salary) {
        this.m_salary = m_salary;
    }

    public int getM_payrate() {
        return m_payrate;
    }

    public void setM_payrate(int m_payrate) {
        this.m_payrate = m_payrate;
    }

    public String getM_assignment() {
        return m_assignment;
    }

    public void setM_assignment(String m_assignment) {
        this.m_assignment = m_assignment;
    }
    

    
}
