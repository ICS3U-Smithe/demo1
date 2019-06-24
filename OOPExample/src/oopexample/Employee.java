package oopexample;

/**
 * This class represents an employee. It extends the person class, therefore 
 * it inherits all of the properties of the person class. 
 * 
 * @author Mr. Smithe
 */
public class Employee extends Person {
   
    //instance variables specific to an employee
    private int employeeNumber;
    private double salary;
    
    //this static variable is shared between all instances of the class
    private static int nextEmployeeNumber = 1;
    
    /**
     * This creates a new Employee with the provided attributes. 
     * 
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param age the employee's age
     * @param salary the employee's gross annual salary
     */
    public Employee(String firstName, String lastName, int age, double salary) {
        //envoke the super class's constructor
        super(firstName, lastName, age);
        
        //set the instance variables specific to this class. 
        this.salary = salary;
        employeeNumber = nextEmployeeNumber;
        nextEmployeeNumber++;
    }

    /**
     * Returns the employee's salary
     * 
     * @return the employee's salary 
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Updates the employee's salary. 
     * @param salary the gross annual salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns the employee's employee number. 
     * 
     * @return the employee's employee number. 
     */
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * An overridden toString method
     *  
     * @return the string representation of the employee. 
     */
    @Override
    public String toString() {
        return "Employee{" + super.toString() + ", " + "employeeNumber=" + employeeNumber + ", salary=" + salary + '}';
    }
    
}
