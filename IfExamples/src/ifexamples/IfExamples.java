package ifexamples;

import java.util.Scanner;

/**
 * This class demonstrates the use of if statements. 
 * 
 * 
 * @author Mr. Smithe
 */
public class IfExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        
        System.out.println("What is your name? ");
        String name = s.nextLine();
        name = name.trim();
        
        String firstName;
        String lastName;
        
        if(name.contains(" ")){ //&& name.indexOf(" ") != name.length() - 1){
            firstName = name.substring(0, name.indexOf(" "));
            lastName = name.substring(name.indexOf(" ") + 1);
        }else{
            firstName = name;
            System.out.println("What is your last name? ");
            lastName = s.nextLine().trim();
        }
        System.out.println("Hello " + firstName + ". ");
        System.out.println("I know a Tammy " + lastName + ", any relation? ");
        
        boolean tammyRelative = s.nextLine().trim().toLowerCase().equals("yes");
        
        //System.out.println(tammyRelative);
        
        System.out.println("How old are you? ");
        int age = Integer.parseInt(s.nextLine());
        
        if(age >= 65){
            System.out.println("Ahh, a senior citizen. Enjoy those discounts. ");
            if(tammyRelative){
                System.out.println("Is Tammy your Granddaughter? ");
            }
        }else if(age >= 18){
            System.out.println("Don't forget to vote in the upcoming election! ");
            if(tammyRelative && age > 40)
                System.out.println("Is Tammy your daughter? ");
            else if(tammyRelative)
                System.out.println("Is Tammy your cousin? ");
        }else if(age >= 13){
            if(tammyRelative){
                System.out.println("Ahh, is Tammy your little sister? ");
            }else{
                System.out.println("Enjoy your teenage years! ");
            }
        }else{
            if(tammyRelative){
                System.out.println("Ahh, is Tammy your big sister? ");
            }else{
                System.out.println("See you when you get to high school. ");
            }
        }
    }
    
}
