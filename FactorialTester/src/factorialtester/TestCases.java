/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialtester;

import java.util.Random;

/**
 *
 * @author smitandr7141
 */
public class TestCases {

    public static void main(String[] args) {
        //write java that creates multiple random test cases here
        Random r = new Random();
        for (int i = 0; i < 5; i++) {

            int n = r.nextInt(13);

            System.out.println("case=Test " + i);
            System.out.println("input=" + n);
            System.out.println("output=" + factorial(n));
        }

    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
