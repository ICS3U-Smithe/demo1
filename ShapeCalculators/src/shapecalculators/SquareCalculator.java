package shapecalculators;

/**
 * This class represents a square. Given 
 * the square's side length it can calculate
 * the perimeter and area of the square. 
 * 
 * @author Mr. Smithe
 * @version Sept 2018
 */
public class SquareCalculator {
    //instance variables
    private double sideLength;
    private double perimeter;
    private double area;
    
    /**
     * Creates a SquareCalculator object
     * with the given side length. 
     * 
     * @param sideLength the side length of the square
     */
    public SquareCalculator(double sideLength){
        //initialize instance variables
        this.sideLength = sideLength;
        
        perimeter = 4 * sideLength;
        area = Math.pow(sideLength, 2);
        
    }
    
    /**
     * returns the side length of the square
     * 
     * @return the side length of the square
     */
    public double getSideLength() {
        return sideLength;
    }
    
    /**
     * sets the side length of the square. 
     * 
     * @param sideLength the side length of the square
     */
    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
        perimeter = sideLength * 4;
        area = sideLength * sideLength;
    }
    
    /**
     * This returns the perimeter of the square. 
     * 
     * @return The perimeter 
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * This returns the area of the square. 
     * 
     * @return the area 
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns a string representation of the object. 
     * 
     * @return A string representation of the object 
     */
    @Override
    public String toString() {
        return "SquareCalculator{" + "sideLength=" + sideLength + ", perimeter=" + perimeter + ", area=" + area + '}';
    }
    
    
}
