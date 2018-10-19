/*
 *This will be the parent class that all user accounts will inherit from 
*/
package truckingcompanymanagementsystem;

import java.util.*;

/**
 *
 * @author Andrea
 * 
 */

//need user factory and user's of the database

public class User 
{
    private int ID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private int address;
    private String city;
    private String state;
    private int zip;
    private int homePhone;
    private int cellPhone;
    private float payRate;
    private int yearsCompany;
    private String workAssignment; //cross reference to driver shipping information
    
    public User()
    {
        //initialize data entries
        this.ID = 9999;
        this.username = "TMCS_user";
        this.password = "12345";
        this.firstName = "fistname";
        this.middleName = "middlename";
        this.lastName = "lastname";
        this.address = 99999;
        this.city = "city";
        this.state = "state";
        this.zip = 99999;
        this.homePhone = 99999999;
        this.cellPhone = 99999999;
        this.payRate = 80000;
        this.yearsCompany = 0;
        this.workAssignment = "workassignment";
        
        
    }
    //_______________________________________________
    //Mutators and Accessors
    //_______________________________________________
    public int getID()
    {
        return ID;
    }
    
    public void setID(int ID)
    {
        this.ID = ID;
    }
    
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String setPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getMiddleName()
    {
        return middleName;
    }
    
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }   
   
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public int address()
    {
        return address;
    }
    
    public void setAddress()
    {
        this.address = address;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity()
    {
        this.city = city;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setSate()
    {
        this.state = state;
    }
    
    public int zip()
    {
        return zip;
    }
    
    public void setZip()
    {
        this.zip = zip;
    }
    
    public int homePhone()
    {
        return homePhone;
    }
    
    public void setHomePhone()
    {
        this.homePhone = homePhone;
    }
    
    public int cellPhone()
    {
        return cellPhone;
    }
    
    public void setCellPhone()
    {
        this.cellPhone = cellPhone;
    }
    
    public float payRate()
    {
        return payRate;
    }
    
    public void setPayRate()
    {
        this.payRate = payRate;
    }
    
    public int yearsCompany()
    {
        return yearsCompany;
    }
    
    public void setYearsCompany()
    {
        this.yearsCompany = yearsCompany;
    }
    
    public String workAssignment()
    {
        return workAssignment;
    }
    
    public void setWorkAssignment()
    {
        this.workAssignment = workAssignment;
    }
    
}//end User class
