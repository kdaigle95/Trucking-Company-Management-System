/*
 * 
 */
package truckingcompanymanagementsystem;

/**
 *11/07/18
 * @author Andrea
 */
public class MaintenanceFactory {
    
    static private MaintenanceFactory singletonFactory;
    
    private MaintenanceFactory(){
    
    }
    
    public static MaintenanceFactory getMaintenanceFactory(){
    
        if(singletonFactory == null){
            
            singletonFactory = new MaintenanceFactory();
        }
        return singletonFactory;
    }
    
    public Maintenance createMaintenance(int workOrder, int truckID, String vin, String maintenanceID, String date, String jobDone, String parts, String cost, String report){

        return new Maintenance(workOrder, truckID, vin, maintenanceID, date, jobDone, parts, cost, report);
    }
    
    public void getMessage(){
    System.out.println("Maintenance Factory created");
   }
}
