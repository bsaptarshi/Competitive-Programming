package com.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class BucketSort {
    int[] arr;
    int n;
    LinkedList<Integer>[] buckets;
    
    int bucketRange;
    
    int min;
    
    int max;
    
    public BucketSort(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        initializeBuckets();
        setRadix();
    }
    
    private void initializeBuckets() {
        buckets = new LinkedList[n];
        for (int i = 0; i < n; i++)
            buckets[i] = new LinkedList<Integer>();
    }
    
    private void setRadix() {
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        bucketRange = (int) ((max - min) / n + 1);
    }
    
    private int getBucketId(int num) {
        return (num - min) / bucketRange;
    }
    
    private void insertIntoBuckets(int num) {
        int bucketId = getBucketId(num);
        
        buckets[bucketId].add(num);
    }
    
    private void sortListViaInsertionSort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            int currNum = nums.get(i);
            int j = i - 1;
            
            // Perform insertion sort
            while (j >= 0 && nums.get(j) > currNum) {
                nums.set(j + 1, nums.get(j));
                j--;
            }
            nums.set(j + 1, currNum);
        }
    }
    
    private int[] aggregateBucketsToArray(List<Integer>[] buckets) {
        int[] res = new int[n];
        int idx = 0;
        for (List<Integer> bucket : buckets) {
            System.out.println("Bucket :" + bucket);
            for (int j = 0; j < bucket.size(); j++) {
                res[idx++] = bucket.get(j);
            }
        }
        
        return res;
    }
    
    public int[] sort() {
        for (int i : arr)
            insertIntoBuckets(i);
        
        for (List<Integer> bucket : buckets)
            sortListViaInsertionSort(bucket);
        
        return aggregateBucketsToArray(buckets);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 8, 10, 2, -3, 5};
        BucketSort bucketSort = new BucketSort(arr);
        int[] sorted = bucketSort.sort();
        
        System.out.println("Sorted => " + Arrays.toString(sorted));
    }
}
