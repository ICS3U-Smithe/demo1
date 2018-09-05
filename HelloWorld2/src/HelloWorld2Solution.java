package helloworld2;

import java.util.Scanner;

/**
 * This program not only greets the user, but asks for input 
 * in order to personalize the experience. 
 * 
 * @author Mr. Smithe
 */
public class HelloWorld2Solution {
    
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
        
        askName();
        askAge();
        askFavouriteColour();
        askSiblings();
        askPets();
        askBalance();
                
    }
    
    /**
     * This method asks the user for their name, I moved it to its own method
     * for consistency. 
     */
    public static void askName(){
        System.out.println("Hello, what is your name? ");
        
        String name = s.nextLine();
        
        System.out.println("Hello, " + name + ", nice to meet you. ");
        
    }
    
    /**
     * This method asks the user for their age
     */
    public static void askAge(){
        System.out.println("How old are you? ");
        
        //we could read the age in as a string
        //String age = s.nextLine();
        
        //we should read it in as an int
        //int age = s.nextInt();
        
        //alternatively we could convert a String into an int
        int age = Integer.parseInt(s.nextLine());
        //always reading a full line at a time prevents hacky handling of weird issues. 
        
        
        System.out.println("Wow, " + age + " years old, crazy! ");
        
    }
    
    /**
     * this method asks for the favourite colour
     */
    public static void askFavouriteColour(){
        System.out.println("What is your favourite colour? ");
        
        String colour = s.nextLine();
        
        System.out.println("Wow, my favourite colour is also " + colour);
        
    }
    
    public static void askSiblings(){
        System.out.println("Do you have any siblings? (true for yes, false for no) ");
        
        boolean hasSiblings = Boolean.parseBoolean(s.nextLine());
        
        System.out.println("It is " + hasSiblings + " that you have siblings. ");
        
    }
    
    public static void askPets(){
        System.out.println("How many pets do you have? ");
        
        int numPets = Integer.parseInt(s.nextLine());
                
        System.out.println("Wow, " + numPets + "! You must either love or hate animals.  ");
    }
    
    public static void askBalance(){
        System.out.println("How much money do you have in your savings account? ");
        
        double balance = Double.parseDouble(s.nextLine());
                
        System.out.println("Hot dang! $" + balance + " is way more than what I have saved up!  ");
    }
}
