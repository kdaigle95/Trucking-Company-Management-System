/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

/**
 *
 * @author justin
 */
public class Manifest 
{
    private String item_name;
    private int item_amount;
    private float unit_cost;
    private float total_item_cost;


    public Manifest()
    {
        this.item_name = "";
        this.item_amount = 0;
        this.unit_cost = 0;
        this.total_item_cost = 0;
    }
    
    public Manifest(String item_name, int item_amount, float unit_cost, float total_item_cost)
    {
        this.item_name = item_name;
        this.item_amount = item_amount;
        this.unit_cost = unit_cost;
        this.total_item_cost = total_item_cost;        
    }

    public String getItem_name()
    {
        return item_name;
    }

    public void setItem_name()
    {
        this.item_name = item_name;
    }
    
    public int getItem_amount()
    {
        return item_amount;
    }
    
    public void setItem_amount()
    {
        this.item_amount = item_amount;
    }
    
    public float getUnit_cost()
    {
        return unit_cost;
    }
    
    public void setUnit_cost()
    {
        this.unit_cost = unit_cost;
    }
    
    public float getTotal_item_cost()
    {
        return total_item_cost;
    }
    
    public void setTotal_item_cost()
    {
        this.total_item_cost = total_item_cost;
    }
}

