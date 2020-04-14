package com.test.examples;

import java.util.Arrays;
import java.util.List;

public class BinaryTest {
    public static void main(String[] args) {
        BinaryTest binaryTest = new BinaryTest();
        System.out.println(binaryTest.digitsManipulations(123456));
        List<String> ovwels = Arrays.asList("a", "e", "i", "o", "u", "y");
        String pattern = "010";
        String s = "amazing";
        char[] ps= s.toCharArray();
        int counter = 0;
        for (Character c : ps) {
            String cs = String.valueOf(c);
            if(ovwels.contains(cs)) {
                int digit = Character.digit(c, 16);
                if(pattern.contains(String.valueOf(digit))) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    int digitsManipulations(int n) {
        int digit;
        int m =1, s =0;
        while(n > 0) {
            digit = n % 10;
            m *= digit;
            s += digit;
            n = n/10;
        }
        return m - s;
    }
   // String pattern = "010";
   // String s = "amazing";
   // o=2

    //String pattern = "010";
   // String s = "ing";
    //o=0;

    //String pattern = "00";
    //String s = "aaaaaaaa";
   // o=9
}
