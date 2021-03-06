package truckingcompanymanagementsystem;
/**
 *
 * @author Andrea
 * 10/30/2018
 */
public class VehicleFactory {
    
    static private VehicleFactory singletonFactory;
    
    private VehicleFactory(){
    
    }
    
    public static VehicleFactory getVehicleFactory(){
        
        if(singletonFactory == null){
            
            singletonFactory = new VehicleFactory();
        }
        
        return singletonFactory;
    }
    
    /**
     *
     * @param vin
     * @param truckBrand
     * @param truckYear
     * @param truckModel
     * @param truckID
     * @param driverID
     * @param availability
     * @return
     */
    public Vehicle createVehicle(String vin, String truckBrand, int truckYear, String truckModel, int truckID, int driverID, int availability){
        
        return new Vehicle(vin, truckBrand, truckYear, truckModel, truckID, driverID, availability);
        
    }
}
