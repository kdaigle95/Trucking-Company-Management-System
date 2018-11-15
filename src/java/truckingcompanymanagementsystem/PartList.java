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
public class PartList {
    
    private String name;
    private int count;
    private String source;
    private String cost;
    private String date;

    public PartList(String name, int count, String source, String cost, String date) {
        this.name = name;
        this.count = count;
        this.source = source;
        this.cost = cost;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
            
            
 
}
