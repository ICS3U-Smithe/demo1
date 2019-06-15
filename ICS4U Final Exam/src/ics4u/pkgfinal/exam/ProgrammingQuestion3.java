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
public class ProgrammingQuestion3 {
    
    public static void main(String[] args){
        Random r = new Random();
        
        for(int i = 1; i <= 5; i++){
            System.out.println("case=Test " + i);
            int num = r.nextInt(100) + 1;
            System.out.println("input=" + num);
            System.out.print("output=");
            printBoard(num);
            
        }
    }
    
    public static void printBoard(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print((i+j)%2);
            }
            System.out.println();
        }
        
    }
}
