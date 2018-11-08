/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truckingcompanymanagementsystem;
import java.util.LinkedList; 
import java.util.Queue; 
/**
 *
 * @author justin
 */
public class ResourceAllocation 
{
    
    public static ResourceAllocation getInstance()
    {
        return ResourceAllocationHolder.INSTANCE;
    }
    
    private static class ResourceAllocationHolder
    {
        private static final ResourceAllocation INSTANCE = new ResourceAllocation();
    }
   
    Queue<Integer> availableTruckQueue;
    Queue<Integer> availableDriverQueue;
    
    private ResourceAllocation()
    {
        //constructor to create queues
        this.availableTruckQueue = new LinkedList<>();
        this.availableDriverQueue = new LinkedList<>();
        
        //logic to read in truck and driver ids into respective queues from remote database available trucks and available drivers table 
    }
    
    //Functions for operations on queues
    public void enQueueTruck(int truck_id)
    {
        availableTruckQueue.add(truck_id);
    }
    
    public int deQueueTruck()
    {
        availableTruckQueue.remove();
        int truck_id = 0;
        return truck_id;
    }
    
    public void enQueueDriver(int driver_id)
    {
        availableDriverQueue.add(driver_id);
    }
    
    public int deQueueDriver()
    {
        availableDriverQueue.remove();
        int driver_id = 0;
        return driver_id;
    }
}
