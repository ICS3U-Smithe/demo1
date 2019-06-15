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
public class ProgrammingQuestion2Solution {
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        
        countOddUpTo(num);
    }
    
    public static void countOddUpTo(int n){
        for(int i = 1; i < n; i += 2){
            System.out.println(i + ", ");
        }
        
    }
}
