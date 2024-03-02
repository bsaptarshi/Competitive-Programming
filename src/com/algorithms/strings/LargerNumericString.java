package com.algorithms.strings;

/** Given two strings containing digits, return the one which would represent the largest integer
 *  if the digits were sorted in descending order.
 * Example:
 * "5143" -> "5431"
 * "3711" -> "7311"
 
 * return "3711"
 
 * two valid strings always? - null or empty but char will be digits
 * both invalid, throw exception
 * sort using custom comparator
 **/

import java.util.Arrays;

public class LargerNumericString {
    private static String compareInts(String s1, String s2) {
        if ((s1 == null || s1.isEmpty())
                && (s2 == null || s2.isEmpty())) {
            return "";
        }
        
        if (s1 == null || s1.isEmpty())
            return s2;
        
        if (s2 == null || s2.isEmpty())
            return s1;
        
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        
        Arrays.sort(s1c);
        Arrays.sort(s2c);
        
        reverseCharArray(s1c);
        reverseCharArray(s2c);
        
        int p1 = 0, p2 = 0;
        int m = s1c.length, n = s2c.length;
        
        while (p1 < m && p2 < n) {
            if (s1c[p1] == s2c[p2]) {
                p1++;
                p2++;
            } else if (s1c[p1] > s2c[p2] && m >= n) {
                return s1;
            } else if (s1c[p1] < s2c[p2] && m <= n) {
                return s2;
            } else {
                p1++;
                p2++;
            }
        }
        
        if (p1 == m && p2 == n)
            return s1; //or s2
        else if (p1 < m)
            return s1;
        else
            return s2;
        
    }
    
    private static void reverseCharArray(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            char tmp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;
        }
    }
    
    public static void main(String[] args) {
        String s1 = "5143";   // 5143
        String s2 = "3714";   // 3714
        
        System.out.println(s1 + " and " + s2);
        System.out.println("Larger Numeric String = " + compareInts(s1, s2));
    }
}

