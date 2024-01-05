package com.algorithms.graph;

import java.util.HashMap;
import java.util.Map;


public class UnionFind {
    private Map<Integer, Node> nodes = new HashMap<>();
    
    /**
     * Internal class to instrument an element in the set
     */
    class Node {
        int data;
        int rank;
        Node parent;
    }
    
    public void makeSet(int n) {
        Node node = new Node();
        
        node.data = n;
        node.rank = 0;
        node.parent = node;
        
        nodes.put(n, node);
    }
    
    public boolean unionSet(int x, int y) {
        Node n1 = nodes.get(x);
        Node n2 = nodes.get(y);
        
        if (null == n1 || null == n2) {
            return false;
        }
        
        Node parent1 = findSet(n1);
        Node parent2 = findSet(n2);
        
        if (parent1.data == parent2.data) {
            return false;
        }
        
        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        
        return true;
    }
    
    public int findSet(int n) {
        Node node = nodes.get(n);
        if (null == node) {
            return Integer.MIN_VALUE;
        }
        return findSet(nodes.get(n)).data;
    }
    
    private Node findSet(Node node) {
        Node parent = node.parent;
        
        if (node == parent) {
            return parent;
        }
        
        node.parent = findSet(node.parent);
        
        return node.parent;
    }
    
    public static void main(String[] args) {
        System.out.println("Executing Union Find..");
        UnionFind obj = new UnionFind();
        
        obj.makeSet(1);
        obj.makeSet(2);
        obj.makeSet(3);
        obj.makeSet(4);
        obj.makeSet(5);
        obj.makeSet(6);
        obj.makeSet(7);
        
        obj.unionSet(1, 2);
        obj.unionSet(2, 3);
        obj.unionSet(4, 5);
        obj.unionSet(6, 7);
        obj.unionSet(5, 6);
        obj.unionSet(3, 7);
        
        System.out.println(obj.findSet(1));
        System.out.println(obj.findSet(2));
        System.out.println(obj.findSet(3));
        System.out.println(obj.findSet(4));
        System.out.println(obj.findSet(5));
        System.out.println(obj.findSet(6));
        System.out.println(obj.findSet(7));
    }
}