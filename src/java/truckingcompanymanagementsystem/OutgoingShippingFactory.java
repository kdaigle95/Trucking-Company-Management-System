/*
 * 10/29/18
 */
package truckingcompanymanagementsystem;

/**
 *
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
    
    public OutgoingShipping createOutgoingShipping(String destinationCompany, String destinationCompanyAddress, String destinationCompanyState, String destinationCompanyZip, String deliveryDate){
        return new OutgoingShipping(destinationCompany, destinationCompanyAddress, destinationCompanyState, destinationCompanyZip, deliveryDate);
    }
}
