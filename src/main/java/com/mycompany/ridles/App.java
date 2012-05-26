package com.mycompany.ridles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static int[] LIST = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public static void main(String[] args) throws IOException {
        File f = new File("/Users/mirko/Desktop/numbers.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

        List<int[]> numbers = new ArrayList<int[]>(50);
        String line = br.readLine();
        System.out.println("======= LINES ========");
        while (line != null) {
            System.out.println(line);
            int[] number = new int[50];
            char[] numberInChar = line.toCharArray();
            for(int i = 0; i < numberInChar.length; i++) {
                number[i] = Integer.valueOf(String.valueOf(numberInChar[i]));
            }
            numbers.add(number);
            line = br.readLine();
        }
        System.out.println("======= LINES ========");

        for (int[] number : numbers) {
            for (int i : number) {
                System.out.print(i);
            }
            System.out.println("");
        }

        
        int currentSum = 0;
        int remainder = 0;
        final List<Integer> sum = new ArrayList<Integer>(100);
        

        for (int i = 49; i >=0; i--) {
            currentSum = remainder;
            for (int[] number : numbers) {
                currentSum += number[i];
            }
            sum.add(currentSum % 10);
            remainder = currentSum / 10;
        }
        
        System.out.print(remainder);
        for (int i = sum.size() - 1; i >= 0; i--) {
            System.out.print(sum.get(i));
        }
    
    }

    public static boolean isEvenlyDevisibleByList(long l) {
        for (long factor : LIST) {

            if (l % factor != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(long n) {
//        System.out.println("isPrime(" + n + ")");
        long sqrtN = (long) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
//                System.out.println("false");
                return false;
            }
        }

//        System.out.println("true");
        return true;

    }

    private static boolean isPalindrome(long potentialPalindrome) {
        char[] number = Long.toString(potentialPalindrome).toCharArray();
        char[] chars = new char[number.length];
        int j = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            chars[j] = (number[i]);
            j++;
        }

//        System.out.println("Number : " + String.valueOf(number)
//                + " , reverse : " + String.valueOf(chars)
//                + ", equals = " + String.valueOf(number).equals(String.valueOf(chars)));

        return String.valueOf(number).equals(String.valueOf(chars));
    }

    private static long squarePyramidalNumber(int number) {
        return (2 * (number * number * number) + 3 * number * number + number) / 6;
    }

    private static boolean isPytagoreanTriplet(int a, int b, int c) {
        return (a * a + b * b) == (c * c);

    }

    private static boolean hasMoreThen500Divisors(long triangle) {
        int count = 0;
        for (long factor = 1; factor <= triangle; factor++) {
            if (triangle % factor == 0) {
                count++;
            }
        }
//        System.out.println(triangle + " has " + count + " divisors");
        return 500 <= count;
    }
}
