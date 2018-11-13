/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;

/**
 *
 * @author justi
 */
public class PurchaseOrderFactory 
{
    static private PurchaseOrderFactory singletonFactory;
    
    private PurchaseOrderFactory()
    {
    
    }
    
    public static PurchaseOrderFactory getPurchaseOrderFactory()
    {
        if(singletonFactory == null)
        {
            
            singletonFactory = new PurchaseOrderFactory();
        }
        
        return singletonFactory;
    }
    
    
    /**
     *
     * @param item_name
     * @param item_amount
     * @param unit_cost
     * @param total_item_cost
     * @param availability
     * @return
     */
    
    
     public PurchaseOrder createPurchaseOrder(String item_name, int item_amount, float unit_cost, float total_item_cost, String availability)
    {
        
        return new PurchaseOrder(item_name, item_amount, unit_cost, total_item_cost, availability);
        
    }
}
