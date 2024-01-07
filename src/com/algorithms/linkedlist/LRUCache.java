package com.algorithms.linkedlist;

import java.util.Map;
import java.util.HashMap;

public class LRUCache {
    class DLLNode {
        int key;
        int value;
        
        DLLNode prev;
        DLLNode next;
    }
    
    /**
     * This is the fake head; eliminates the need to check for null head
     * Always add elements after head(i.e. head.next will have the new node)
     */
    private DLLNode head;
    
    /**
     * This is the fake tail
     * Always remove element to the left of the tail(i.e. tail.prev element will always be popped)
     */
    private DLLNode tail;
    
    /**
     * This is the max capcity of the LRUCache; when the capacity is hit(tracked by count),
     * evict the least recently used element from the cache
     */
    private int capacity;
    
    /**
     * This keeps track of the number of elements currently present in the cache
     */
    private int count;
    
    /**
     * This map is for quick lookup of elements from the cache
     */
    private Map<Integer, DLLNode> cache;
    
    public LRUCache(int capacity) {
        this.head = new DLLNode();
        this.tail = new DLLNode();
        
        head.prev = null;
        head.next = tail;
        head.key = 0;
        head.value = 0;
        
        tail.prev = head;
        tail.next = null;
        tail.key = 0;
        tail.value = 0;
        
        this.count = 0;
        this.capacity = capacity;
        
        this.cache = new HashMap<>();
    }
    
    /**
     * Add a node to the right of the fake head of the linked list
     * @param newNode
     */
    private void addNode(DLLNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        
        head.next.prev = newNode;
        head.next = newNode;
    }
    
    /**
     * Remove the given node element from the linked list
     */
    private void removeNode(DLLNode node) {
        DLLNode prevNode = node.prev;
        DLLNode nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    /**
     * This operation will move a node immediately to the right of the fake head
     */
    private void moveToHead(DLLNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    
    /**
     * This operation will pop the element to the left of the fake tail
     */
    private DLLNode popTail() {
        DLLNode prevNode = tail.prev;
        this.removeNode(prevNode);
        
        return prevNode;
    }
    
    /**
     * retrieves the <key,value> pair from cache
     */
    public int get(int key) {
        DLLNode node = cache.get(key);
        
        if (null == node) {
            return -1;
        }
        
        moveToHead(node);
        return node.value;
    }
    
    /**
     * Add a new <key,value> pair to the cache
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLLNode node = cache.get(key);
        
        if (null == node) {
            // Element did not exist in cache, add it
            DLLNode newNode = new DLLNode();
            newNode.key = key;
            newNode.value = value;
            
            this.addNode(newNode);
            count++;
            
            if (count > capacity) {
                DLLNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            // Element exists in cache, update value and mark as most recently used(i.e. move to front of linked list)
            node.value = value;
            this.moveToHead(node);
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
