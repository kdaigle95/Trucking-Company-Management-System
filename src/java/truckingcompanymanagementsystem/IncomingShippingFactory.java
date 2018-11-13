/*
 * 
 */
package truckingcompanymanagementsystem;

/**
 * 11/07/18
 * @author Andrea
 */
public class IncomingShippingFactory {
    
    static private IncomingShippingFactory singletonFactory;
    
    private IncomingShippingFactory(){
        //default constructor
    }
    
    public static IncomingShippingFactory getIncomingShippingFactory(){
        
        if(singletonFactory == null){
            singletonFactory = new IncomingShippingFactory();
        }
        return singletonFactory;
    }
    
    public IncomingShipping createIncomingShipping(int orderID, String sourceCompany, String address, String city, String state, int zip, int truckID, String departureDate, String estArrival, String arrivalConf, int driverID, String paymentConf){
        return new IncomingShipping(orderID, sourceCompany, address, city, state, zip, truckID, departureDate, estArrival, arrivalConf, driverID, paymentConf);
    }
}
