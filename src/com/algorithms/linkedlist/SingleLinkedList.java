package com.algorithms.linkedlist;

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class SingleLinkedList {
    ListNode head;
    
    public SingleLinkedList() {
        head = null;
    }
    
    public ListNode getHead() {
        return this.head;
    }
    
    public ListNode setHead(ListNode listNode) {
        head = listNode;
        return head;
    }
    
    public ListNode addNode(int data) {
        ListNode listNode = new ListNode(data);
        listNode.next = null;
        
        if (head == null) {
            head = listNode;
        } else {
            ListNode ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            
            ptr.next = listNode;
        }
        
        return head;
    }
    
    public ListNode addNodeToFront(int data) {
        ListNode listNode = new ListNode(data);
        
        if (head == null) {
            head = listNode;
        } else {
            listNode.next = head;
            head = listNode;
        }
        
        return head;
    }
    
    public ListNode deleteNode(int data) {
        if (head == null) {
            return head;
        }
        
        ListNode ptr = head;
        while (ptr.next != null) {
            if (ptr.next.val == data) {
                break;
            }
            
            ptr = ptr.next;
        }
        
        ListNode ptr1 = ptr.next;
        ptr.next = ptr1.next;
        
        return ptr1;
    }
    
    public ListNode deleteNodeFromFront() {
        if (head == null) {
            return head;
        }
        
        ListNode deletedListNode = head;
        head = head.next;
        return deletedListNode;
    }
    
    public ListNode reverseList() {
        if (head == null) {
            return head;
        }
        
        ListNode front = null, middle = head, end = null;
        
        while (middle != null) {
            end = middle.next;
            middle.next = front;
            front = middle;
            middle = end;
        }
        
        return front;
    }
    
    public ListNode find(int data) {
        if (head == null) {
            return head;
        }
        
        ListNode ptr = head;
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
        ListNode ptr = head;
        while (ptr.next != null) {
            System.out.print(ptr.val);
            System.out.print("->");
            ptr = ptr.next;
        }
        
        System.out.println(ptr.val);
    }
    
    public void printList(ListNode node) {
        if (node == null) {
            return;
        }
        
        System.out.println();
        while (node.next != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
        
        System.out.println(node.val);
    }
    
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addNode(5);
        sll.addNode(7);
        sll.addNode(8);
        sll.addNode(11);
        sll.addNodeToFront(2);
        sll.printList();
        
        ListNode search = sll.find(7);
        System.out.println("Found node with val = " + search.val);
        
        sll.deleteNode(8);
        sll.printList();
        
        sll.deleteNodeFromFront();
        sll.printList();

        ListNode newHead = sll.reverseList();
        sll.setHead(newHead);
        sll.printList(newHead);
    }
}
