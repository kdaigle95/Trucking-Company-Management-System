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
public class PayrollReport {
    
    private int employeeID;
    private String lName;
    private String fName;
    private String position;
    private String pay;
    
    protected PayrollReport(int id, String last, String first, String position, String pay)
    {
        this.employeeID = id;
        this.lName = last;
        this.fName = first;
        this.position = position;
        this.pay = pay;
    }

    public int getEmployeeid() {
        return employeeID;
    }

    public void setEmployeeid(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getlname() {
        return lName;
    }

    public void setlname(String lName) {
        this.lName = lName;
    }

    public String getfname() {
        return fName;
    }

    public void setfname(String fName) {
        this.fName = fName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
    
}
