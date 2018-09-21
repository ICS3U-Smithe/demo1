package shapecalculators;

/**
 * This class runs tests on the various shape calculator classes. 
 * 
 * @author Mr. Smithe
 * @version Sept 2018
 */
public class ShapeCalculatorTester {

    /**
     * Main method - runs all tests. 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create an instance of the SquareCalculator class
        SquareCalculator s1 = new SquareCalculator(5);
        System.out.println("My square's side length is: " + s1.getSideLength());
        System.out.println("My square's perimeter is: " + s1.getPerimeter());
        System.out.println("My square's area is: " + s1.getArea());
        System.out.println(s1.toString());
        
        
        //create a second instance of the SquareCalculator
        SquareCalculator s2 = new SquareCalculator(12.3);
        //this object has all of its own instance variables
        System.out.println("My square's side length is: " + s2.getSideLength());
        System.out.println("My square's perimeter is: " + s2.getPerimeter());
        System.out.println("My square's area is: " + s2.getArea());
        System.out.println(s2);
        
        //these objects have their own instance variables. s1 still has a
        //side length of 5.0
        System.out.println("My square's side length is: " + s1.getSideLength());
        
        //we can update one of the instance variables of our objects and 
        //all of the properties should update accordingly. 
        s1.setSideLength(52); 
        System.out.println("My square's side length is: " + s1.getSideLength());
        System.out.println("My square's perimeter is: " + s1.getPerimeter());
        System.out.println("My square's area is: " + s1.getArea());
        System.out.println(s1.toString());
        
    }
    
}
