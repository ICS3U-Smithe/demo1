/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics4u.pkgfinal.exam;

import java.util.Scanner;

/**
 *
 * @author asmit
 */
public class ProgrammingQuestion1Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        System.out.println("What is your name? ");
        String name = s.next();
        
        if(name.length() < 6){
            System.out.println("How old are you? ");
            int age = s.nextInt();
            
            System.out.println("Nice to meet you, " + name + ", who is " + age + "years old. ");
        }else if (name.length() == 6){
            System.out.println("What is your favourite colour? ");
            String colour = s.next();
            
            System.out.println("Hello, " + name + ". I like the colour " + colour + " too! ");
        }else{
            System.out.println("What is your last name? ");
            String lastName = s.next();
            
            System.out.println("Hello, " + name + " " + lastName);
        }
        
    }
}
