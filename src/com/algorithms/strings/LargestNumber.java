package com.algorithms.strings;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumber {
    private String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] numsAsStrs =  new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsAsStrs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(numsAsStrs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if ("0".equals(numsAsStrs[0])) {
            return "0";
        }
        
        StringBuilder largestNum = new StringBuilder();
        for (String str : numsAsStrs) {
            largestNum.append(str);
        }
        
        return largestNum.toString();
    }
    
    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();
        int[] nums = {3,30,34,5,9};
        
        System.out.println("Largest Number as String: "
                + obj.largestNumber(nums));
    }
}
