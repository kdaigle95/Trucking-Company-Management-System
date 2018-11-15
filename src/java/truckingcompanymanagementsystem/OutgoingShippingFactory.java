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
    
    public OutgoingShipping createOutgoingShipping(int orderID, String destinationCompany, String destinationCompanyAddress, String destinationCompanyCity, String destinationCompanyState, int destinationCompanyZip, int truckID, java.util.Date departureDate, java.util.Date estArrival, String arrivalConf, int driverID, String paymentConf){
        return new OutgoingShipping(orderID, destinationCompany, destinationCompanyAddress, destinationCompanyCity, destinationCompanyState, destinationCompanyZip, truckID, departureDate, estArrival, arrivalConf, driverID, paymentConf);
    }
    
    public void getMessage(){
    System.out.println("OutgoingShipping Factory created");
    }
}
