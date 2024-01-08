package com.algorithms.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that
 * answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        
        int[] prodNums = new int[nums.length];
        Arrays.fill(prodNums, 1);
        
        int currProd = 1;
        
        /**
         * Traverse array from left to right and store the prefix product in prodNums
         * prodNums[i] = nums[0] * nums[1] * ... * nums[i - 1];
         */
        for (int i = 0; i < nums.length; i++) {
            prodNums[i] *= currProd;
            currProd *= nums[i];
        }
        
        currProd = 1;
        /**
         * Traverse array from right to left and append suffix prod to prefix product already existing in prodNums
         * prodNums[i] = (nums[0] * nums[1] * ... * nums[i - 1]) //prefix product already computed
         *             * (nums[i+1] * nums[i+2] * ... * nums[n - 1])
         * where n = nums.length
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            prodNums[i] *= currProd;
            currProd *= nums[i];
        }
        
        return prodNums;
    }
    
    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        
        int[] res = productOfArrayExceptSelf.productExceptSelf(nums);
        
        System.out.println("Product of Array except self for input = " + Arrays.toString(nums));
        System.out.println(Arrays.toString(res));
    }
    

}
