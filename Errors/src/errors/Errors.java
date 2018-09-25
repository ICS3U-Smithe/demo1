package errors;

/**
 * This class outlines the various types of errors. 
 * 
 * @author Mr. Smithe
 */
public class Errors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Syntax errors
        //an error that the compiler is able to catch before the code 
        // is executed. 
        
        //missing semi-colons
        //System.out.print("Hello World")
        
        //incompatible variable types
        //int x = "5";
        
        //wrong parameter type
        //addFive("six");
        
        //missing parameters
        //addFive();
        
        //trying to use a non-static method
        //from a static context. 
        //addFive(5);
        //fix by using an instance of an object.
        //Errors e = new Errors();
        //e.addFive(6);
        
        //incorrect bracket nesting
        
        //missing return statement
        
        //case sensitive issues
        
        //Logical Error
        //program runs, but doesn't do what 
        //was intended.
        
        //total = price * 0.13;
        
        //equality issues. 
        //Formatting of output. 
        //String concatenation vs arithmetic
        // "my num is: " + x + y
        
        
        //run-time errors
        //aren't caught by the compiler, 
        //but the program enters an error
        //state while running
        
        //array out of bounds error. 
        
        //user supplies bad input. 
        
        //null pointer exceptions 
        String s;
        //System.out.println(s.length());
        //printLength(s);
    }
    
    public void addFive(int x){
        System.out.println(x + 5);
    }
    
    public static String addFour(int x){
        x = x + 4;
        return x + "";
    }
    
    public static void printLength(String s){
        System.out.println(s.length());
    }
}