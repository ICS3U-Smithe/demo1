package helloworld2;

import java.util.Scanner;

/**
 * This program not only greets the user, but asks for input 
 * in order to personalize the experience. 
 * 
 * @author Mr. Smithe
 */
public class HelloWorld2 {
    
    //instance variables - these can be shared across the class
    private static Scanner s = new Scanner(System.in);
    /**
     * This method asks the user for their name, 
     * greets them and calls the askAge method. 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello, what is your name? ");
        
        String name = s.nextLine();
        
        System.out.println("Hello, " + name + ", nice to meet you. ");
        
        askAge();
    }
    
    /**
     * This method asks the user for their age
     */
    public static void askAge(){
        System.out.println("How old are you? ");
        
        //we could read the age in as a string
        //String age = s.nextLine();
        
        //we should read it in as an int
        int age = s.nextInt();
        
        //alternatively we could convert a String into an int
        //int age = Integer.parseInt(s.nextLine());
        
        System.out.println("Wow, " + age + " years old, crazy! ");
        
    }
    
}
