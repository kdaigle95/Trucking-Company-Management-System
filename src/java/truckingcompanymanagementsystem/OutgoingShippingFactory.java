/*
 * 
 */
package truckingcompanymanagementsystem;

/**
 * 10/29/18
 * @author Andrea
 */
public class OutgoingShippingFactory {
    
    static private OutgoingShippingFactory singletonFactory;
    
    private OutgoingShippingFactory (){
        //constructor
    }
    
    public static OutgoingShippingFactory getOutgoingShippingFactory(){
        
        if(singletonFactory == null){
            singletonFactory = new OutgoingShippingFactory();
        }
        
        return singletonFactory;
    }
    
    public OutgoingShipping createOutgoingShipping(int orderID, String destinationCompany, String destinationCompanyAddress, String destinationCompanyState, String destinationCompanyZip){
        return new OutgoingShipping(orderID, destinationCompany, destinationCompanyAddress, destinationCompanyState, destinationCompanyZip);
    }
    
    public void getMessage(){
    System.out.println("OutgoingShipping Factory created");
    }
}
