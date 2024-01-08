package com.algorithms.linkedlist;

public class SingleLinkedList {
    class Node {
        int val;
        Node next;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    Node head;
    
    public SingleLinkedList() {
        head = null;
    }
    
    public Node getHead() {
        return this.head;
    }
    
    public Node setHead(Node node) {
        head = node;
        return head;
    }
    
    public Node addNode(int data) {
        Node node = new Node(data);
        node.next = null;
        
        if (head == null) {
            head = node;
        } else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            
            ptr.next = node;
        }
        
        return head;
    }
    
    public Node addNodeToFront(int data) {
        Node node = new Node(data);
        
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        
        return head;
    }
    
    public Node deleteNode(int data) {
        if (head == null) {
            return head;
        }
        
        Node ptr = head;
        while (ptr.next != null) {
            if (ptr.next.val == data) {
                break;
            }
            
            ptr = ptr.next;
        }
        
        Node ptr1 = ptr.next;
        ptr.next = ptr1.next;
        
        return ptr1;
    }
    
    public Node deleteNodeFromFront() {
        if (head == null) {
            return head;
        }
        
        Node deletedNode = head;
        head = head.next;
        return deletedNode;
    }
    
    public Node reverseList() {
        if (head == null) {
            return head;
        }
        
        Node front = null, middle = head, end = null;
        
        while (middle != null) {
            end = middle.next;
            middle.next = front;
            front = middle;
            middle = end;
        }
        
        return front;
    }
    
    public Node find(int data) {
        if (head == null) {
            return head;
        }
        
        Node ptr = head;
        while (ptr != null) {
            if (ptr.val == data) {
                return ptr;
            }
            
            ptr = ptr.next;
        }
        
        return null;
    }
    
    public void printList() {
        if (head == null) {
            return;
        }
        
        System.out.println();
        Node ptr = head;
        while (ptr.next != null) {
            System.out.print(ptr.val);
            System.out.print("->");
            ptr = ptr.next;
        }
        
        System.out.println(ptr.val);
    }
    
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addNode(5);
        sll.addNode(7);
        sll.addNode(8);
        sll.addNode(11);
        sll.addNodeToFront(2);
        sll.printList();
        
        Node search = sll.find(7);
        System.out.println("Found node with val = " + search.val);
        
        sll.deleteNode(8);
        sll.printList();
        
        sll.deleteNodeFromFront();
        sll.printList();

        Node newHead = sll.reverseList();
        sll.setHead(newHead);
        sll.printList();
    }
}
