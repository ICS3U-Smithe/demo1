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
public class ProgrammingQuestion2 {
    
    public static void main(String[] args){
        Random r = new Random();
        
        for(int i = 0; i < 5; i++){
            System.out.println("case=Test "+(i+1));
            int num = r.nextInt(100) + 1;
            System.out.println("input=" + num);
            System.out.print("output=");
            countOddUpTo(num);
            
        }
    }
    
    public static void countOddUpTo(int n){
        for(int i = 1; i < n; i += 2){
            System.out.println(i + ", ");
        }
        
    }
}
