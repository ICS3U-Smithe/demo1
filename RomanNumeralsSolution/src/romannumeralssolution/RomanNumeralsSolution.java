package romannumeralssolution;

import java.util.Scanner;

/**
 * This program converts a base 10 number to a roman numeral. 
 * 
 * @author Mr. Smithe
 */
public class RomanNumeralsSolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please input a number. ");
        int num = Integer.parseInt(s.nextLine());
        String output = "";
        
        if(num > 4999){
            System.out.println("Sorry, I don't support numbers beyond 4999. ");
        }else if(num <= 0){
            System.out.println("Sorry, I only support positive integers. ");
        }
        
        if(num == 9){
            output += "IX";
        }else if(num == 8){
            
        }
        
    }
    
}
