package oopexample;

/**
 * This is the main tester class for the project. 
 * 
 * @author Mr. Smithe
 */
public class OOPExample {

    /**
     * This is the only method that is run when we hit play in NetBeans
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create some people
        //each instance of the person class gets its own instance variables
        Person p1 = new Person("Bob", "Mercury", 23);
        Person p2 = new Person("Mary", "Jane", 34);
        
        //we can access the instance variables through getters. 
        System.out.println(p1.getFirstName());
        System.out.println(p2.getFirstName());
        
        //we can modify private instance variables through public setters. 
        p1.setFirstName("Robert");
        
        //by default Java will use the toString method when printing objects. 
        System.out.println(p1);
        System.out.println(p2.toString());
        
        //we can make multiple different constructors
        Person p3 = new Person("Will", "Smith");
        System.out.println(p3); 
        //values we have not set will get default values for primitive types
        //or be null for objects. 
        
        //we can create a new Employee
        Employee p4 = new Employee("Fred", "Flintstone", 900, 12.57);
        System.out.println(p4);
        
        //Employee's are people, so this is valid. 
        Person p5 = new Employee("Barney", "Rubble", 890, 10.47);
        System.out.println(p5);
        //this still uses the Employee class's toString method. 
        
        Manager m1 = new Manager("George", "Slate", 1500, 1, "Bedrock Quarry");
        System.out.println(m1);
        
        
        m1.addEmployee(p4);
        m1.addEmployee((Employee)p5);
        
        m1.ensureSalary();
        System.out.println(m1);
        
    }
    
}
