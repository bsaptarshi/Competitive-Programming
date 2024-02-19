package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 📦💼 Optimizing Box Weights: A Real-World Packing Challenge! 💼📦
 Attention all developers and logistics enthusiasts! We are faced with a packing conundrum that requires an optimized solution.
 
 The Problem:
 A Fulfillment Associate is tasked with packing items into two boxes, A and B. Here's what we must achieve:
 🚫 The intersection of A and B is null.
 🤝 The union of A and B equals the original array.
 🎛️ Subset A must be of minimal size.
 ⚖️ The sum of A's weights is greater than the sum of B's weights.
 
 Examples:
 • n = 5, arr = [3, 7, 5, 6, 2], so A = [6, 7]
 • n = 6, arr = [4, 5, 2, 3, 1, 2], so A = [4, 5]
 • n = 6, arr = [1, 2, 2, 2, 3, 4], so A = [2, 2, 2, 3, 4]
 • n = 4, arr = [2, 2, 2, 3], so A = [2, 2, 2, 3]
 **/

public class OptimizingBoxWeights {
    private List<Integer> minimalHeaviestPackingBox(List<Integer> items) {
        if (null == items || items.size() < 2) {
            return items;
        }
        
        items.sort(Collections.reverseOrder());
        
        List<Integer> boxA = new ArrayList<>();
        int sumA = 0, totalSum = 0;
        
        for (int item : items) {
            totalSum += item;
        }
        
        for (int item : items) {
            if (sumA > (totalSum - sumA)) {
                break;
            }
            sumA += item;
            boxA.add(item);
        }
        
        Collections.reverse(boxA);
        return boxA;
    }
    
    private List<Integer> minimalHeaviestPackingBoxWithHeap(List<Integer> items) {
        if (null == items || items.size() < 2) {
            return items;
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> boxA = new ArrayList<>();
        int sumOfBoxA = 0;
        
        int totalSum = 0;
        for (int item : items) {
            priorityQueue.add(item);
            totalSum += item;
        }
        
        for (int i = 0; i < items.size(); i++) {
            int currElement = priorityQueue.poll();
            sumOfBoxA += currElement;
            boxA.add(currElement);
            
            if (sumOfBoxA > (totalSum - sumOfBoxA)) {
                break;
            }
        }
        
        Collections.reverse(boxA);
        return boxA;
    }
    
    public static void main(String[] args) {
        OptimizingBoxWeights obj = new OptimizingBoxWeights();
        
        List<Integer> items = new ArrayList<>();
        Integer[] itemsArr = {3, 7, 5, 6, 2};
        Collections.addAll(items, itemsArr);
        
        List<Integer> res = obj.minimalHeaviestPackingBox(items);
        System.out.println("Optimizing Box Weights with Sets: " + res);
        
        List<Integer> resFromHeap = obj.minimalHeaviestPackingBoxWithHeap(items);
        System.out.println("Optimizing Box Weights with Heap: " + resFromHeap);
    }
}
