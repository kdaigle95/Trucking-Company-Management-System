/*
 * 
 */
package truckingcompanymanagementsystem;

/**
 *
 * @author Andrea
 * 10/24/18
 */
public class PersonnelFactory {
    
    static private PersonnelFactory singletonFactory;
    
    private PersonnelFactory() {
        
    }
    
    public static PersonnelFactory getPersonnelFactory() {
        
        if(singletonFactory == null){
            
            singletonFactory = new PersonnelFactory();
        }
        return singletonFactory;
    }
    
    
    
    public Personnel createPersonnel(String employeeID, String firstName, String middleName, String lastName, String streetAddress, String city, String state, int zip, String homePhone, String cellPhone, int years, String position, int salary, int payrate, int assignment){

        return new Personnel(employeeID, firstName, middleName, lastName, streetAddress, city, state, zip, homePhone, cellPhone, years, position, salary, payrate, assignment);
    }
            

   public void getMessage(){
       System.out.println("Personnel Factory created");
   }

}


