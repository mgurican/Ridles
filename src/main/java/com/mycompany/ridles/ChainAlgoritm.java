package com.mycompany.ridles;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author mirko
 */
public class ChainAlgoritm {

    public static void main(String[] args) {
        final SortedMap<Long, Integer> map = new TreeMap<Long, Integer>();
        for (int i = 2; i < 1000000; i++) {
            map.put(doSequenceAlgoritm(i), i);
        }

        System.out.println("Smallest chain is from number : " + map.firstKey()
                + " and chain has : " + map.get(map.firstKey()));
        System.out.println("Longest chain is from number : " + map.lastKey()
                + " and chain has : " + map.get(map.lastKey()));
    }

    private static long doSequenceAlgoritm(long number) {
        long count = 0;
        //System.out.println("Number : " + number);
        while (number != 1) {
            if ((number & 1) == 0) {
                number = number / 2;

                count++;
            } else {
                number = 3 * number + 1;
                count++;
            }
        }

        return count;
    }
}
