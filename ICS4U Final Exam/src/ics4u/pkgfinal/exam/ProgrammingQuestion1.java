/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics4u.pkgfinal.exam;

import java.util.Random;

/**
 *
 * @author asmit
 */
public class ProgrammingQuestion1 {
    
    public static String[] names = {"Bob", "Tom", "Fred", "Nathan", "Andrew", 
        "James", "Russel", "Dalton", "David", "Eric", "Ethan", "Thomas", "Justin", 
        "Keenan", "Lucas", "Michael", "Michael", "Nikoula", "Omar", "Nathaniel", 
        "Benjamin", "Franklin", "Michelle", "Melissa", "Suzanne", "Rebecca"}; 
    
    public static String[] colours = {"Red", "Orange", "Yellow", "Green", "Blue",
        "Indigo", "Violet"};
    
    
    public static void main(String[] args){
        Random r = new Random();
        
        for(int i = 0; i < 5; i++){
            System.out.println("Case = Test " + (i + 1));
            String input = "input=";
            String output = "output = What is your name? \n";
            String name = names[r.nextInt(names.length)];
            
            input += name + "\n";
            if(name.length() < 6){
                output += "How old are you? \n";
                int age = r.nextInt(100);
                input += age;
                
                output += "Nice to meet you, " + name + ", who is " + age + "years old. ";
            }else if (name.length() == 6){
                output += "What is your favourite colour? \n";
                String colour = colours[r.nextInt(colours.length)];
                input += colour;
                output += "Hello, " + name + ". I like the colour " + colour + " too! ";
            }else{
                output += "What is your last name? \n";
                
                String lastName = names[r.nextInt(names.length)];
                input += lastName;
                
                output += "Hello, " + name + " " + lastName;
            }
            
            System.out.println(input);
            System.out.println(output);
            
        }
    }
}
