package com.mycompany.ridles;

import java.math.BigInteger;

/**
 *
 * @author mirko
 */
public class Factorial {

    public static void main(String[] args) {
        BigInteger fact = new BigInteger("1");
        for (int i = 100; i > 2; i--) {
            System.out.println(i);
            fact = fact.multiply(BigInteger.valueOf(i));
            System.out.println("Fact : " + fact);
        }
        
        String longNumber = fact.toString();
        long sum = 0;
        for (int i = 0; i < longNumber.length(); i++) {
            String.valueOf(longNumber.charAt(i));
            sum += Integer.valueOf(String.valueOf(longNumber.charAt(i)));
        }
            
        System.out.println(sum);
    }
}
