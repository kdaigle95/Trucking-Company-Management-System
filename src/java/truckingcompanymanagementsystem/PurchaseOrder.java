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

public class PurchaseOrder 
{
    private String item_name;
    private int item_amount;
    private float unit_cost;
    private float total_item_cost;
    private String availability;


    public PurchaseOrder()
    {
        this.item_name = "";
        this.item_amount = 0;
        this.unit_cost = 0;
        this.total_item_cost = 0;
        this.availability = "nah";
    }
    
    public PurchaseOrder(String item_name, int item_amount, float unit_cost, float total_item_cost, String availability)
    {
        this.item_name = item_name;
        this.item_amount = item_amount;
        this.unit_cost = unit_cost;
        this.total_item_cost = total_item_cost;
        this.availability = availability;        
    }

    public String getItem_Name()
    {
        return item_name;
    }

    public void setItem_Name()
    {
        this.item_name = item_name;
    }
    
    public int getItem_Amount()
    {
        return item_amount;
    }
    
    public void setItem_Amount()
    {
        this.item_amount = item_amount;
    }
    
    public float getUnit_Cost()
    {
        return unit_cost;
    }
    
    public void setUnit_Cost()
    {
        this.unit_cost = unit_cost;
    }
    
    public float getTotal_Item_Cost()
    {
        return total_item_cost;
    }
    
    public void setTotal_Item_Cost()
    {
        this.total_item_cost = total_item_cost;
    }
    
    public String getAvailability()
    {
        return availability;
    }
    
    public void setAvailability()
    {
        this.availability = availability;
    }
}
