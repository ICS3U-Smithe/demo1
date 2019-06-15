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
public class ProgrammingQuestion4Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        System.out.println(sumUpTo(num));

    }

    public static int sumUpTo(int n) {
        return n == 1 ? n : n + sumUpTo(n - 1);

    }
}
