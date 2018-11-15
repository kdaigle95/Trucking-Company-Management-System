package truckingcompanymanagementsystem;
/**
 *
 * @author justin
 */
public class ManifestFactory 
{
    static private ManifestFactory singletonFactory;
    
    private ManifestFactory()
    {
    
    }
    
    public static ManifestFactory getManifestFactory()
    {
        if(singletonFactory == null)
        {
            
            singletonFactory = new ManifestFactory();
        }
        
        return singletonFactory;
    }
    
    
    /**
     *
     * @param item_name
     * @param item_amount
     * @param unit_cost
     * @param total_item_cost
     * @return
     */
    
    
     public Manifest createManifest(String item_name, int item_amount, float unit_cost, float total_item_cost)
    {
        
        return new Manifest(item_name, item_amount, unit_cost, total_item_cost);
        
    }
}
