/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopexample;

/**
 *
 * @author smitandr7141
 */
public class Manager extends Employee{

    private static int MAX_EMPLOYEES = 10;
    
    private String region;
    private Employee[] subordinates = new Employee[MAX_EMPLOYEES];
    private int numEmployees = 0;

    public Manager(String firstName, String lastName, int age, double salary, String region) {
        super(firstName, lastName, age, salary); 
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public void addEmployee(Employee e){
        subordinates[numEmployees] = e;
        numEmployees++;
    }
    
    public void ensureSalary(){
        for(int i = 0; i < numEmployees; i++){
            if(getSalary() < subordinates[i].getSalary() * 1.1)
                setSalary(subordinates[i].getSalary() * 1.1);
        }
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() + "region=" + region + '}';
    }
    
}
