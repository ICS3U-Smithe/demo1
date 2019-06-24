package oopexample;

/**
 * This class represents a person. 
 * 
 * @author Mr. Smithe
 */
public class Person {
    
    //instance variables
    private String firstName;
    private String lastName;
    private int age; 
    
    /**
     * This is the default constructor that sets all of the properties. 
     * 
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param age the person's age
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    /**
     * A second constructor that just take a first and last name. 
     * 
     * @param firstName the person's first name
     * @param lastName the person's last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        age = 21; //assumes a default age of 21
    }
    
    /**
     * Returns the person's first name. 
     * 
     * @return The person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the person's first name
     * 
     * @param firstName the Person's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Returns the person's last name
     * 
     * @return the person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the person's last name
     * 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the person's age
     * 
     * @return the person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets the person's age. 
     * @param age the person's age (non-negative)
     */
    public void setAge(int age) {
        if(age < 0)
            throw new IllegalArgumentException("Age must be positive");
        this.age = age;
    }
    
    /**
     * A human readable string representation of the person. 
     * 
     * @return the String representation of the person. 
     */
    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age  + '}';
    }
}
