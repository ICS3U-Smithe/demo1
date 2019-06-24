/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics4u.pkgfinal.exam;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asmit
 */
public class ProgrammingQuestion3Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        printBoard(num);

    }

    public static void printBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i + j) % 2);
            }
            System.out.println();
        }

    }
}
