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
     * @param driverID
     * @return
     */
    public Vehicle createVehicle(String vin, String truckBrand, int truckYear, String truckModel, int truckID, int driverID){
        
        return new Vehicle(vin, truckBrand, truckYear, truckModel, truckID, driverID);
        
    }
}
