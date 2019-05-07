/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccicalculator;

import java.math.BigInteger;

/**
 *
 * @author Mr. Smithe
 */
public class FibonacciCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(recursiveFib(50));//12586269025
        try{
//            for(int i =5;i<Integer.MAX_VALUE; i++){
//                System.out.println(fibForLoopBig(i));
//            }
            //System.out.println(fibForLoopBig(500000000));
            //System.out.println(fibForLoopBig(395174).toString().length());
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    public static long recursiveFib(int n){
        if(n == 1 || n == 2)
            return 1;
        else
            return recursiveFib(n-1) + recursiveFib(n-2);
    }
    
    public static long fibForLoop(int n) throws Exception{
        long[] nums = new long[n];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i < n; i++){
            
            nums[i] = nums[i-1] + nums[i-2];
            if(nums[i] > Long.MAX_VALUE/2)
                throw new Exception("overflow: " + i);
        }
        return nums[n-1];
    }
    
    public static BigInteger fibForLoopBig(int n) throws Exception{
        BigInteger[] nums = new BigInteger[n];
        nums[0] = BigInteger.ONE;
        nums[1] = BigInteger.ONE;
        for(int i = 2; i < n; i++){
            try{
            nums[i] = nums[i-1].add(nums[i-2]);
            }catch(OutOfMemoryError e){
                throw new Exception("overflow: " + i);
            }
        }
        return nums[n-1];
    }
}
