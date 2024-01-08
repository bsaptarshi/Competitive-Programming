package com.algorithms.linkedlist;

/**
 * You are given the heads of two sorted linked lists list1 and list2. Merge the two lists into one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */


public class MergeTwoSortedLinkedLists {
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ((list1 == null && list2 == null)) {
            return list1;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        ListNode newHead = list1;
        if (list1.val >= list2.val) {
            newHead = list2;
            list2 = list2.next;
        } else {
            list1 = list1.next;
        }
        
        ListNode curr = newHead;
        
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            
            curr = curr.next;
        }
        
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        
        return newHead;
    }
    
    public static void main(String[] args) {
        MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists = new MergeTwoSortedLinkedLists();
        
        SingleLinkedList l1 = new SingleLinkedList();
        SingleLinkedList l2 = new SingleLinkedList();
        
        ListNode head1 = null;
        ListNode head2 = null;
        
        head1 = l1.addNode(5);
        head1 = l1.addNode(7);
        head1 = l1.addNode(8);
        head1 = l1.addNode(11);
        
        System.out.print("First List is : ");
        l1.printList(head1);
        
        head2 = l2.addNode(2);
        head2 = l2.addNode(6);
        head2 = l2.addNode(9);
        
        System.out.print("Second List is : ");
        l1.printList(head2);
        
        ListNode newHead = mergeTwoSortedLinkedLists.mergeTwoLists(head1, head2);
        
        System.out.print("Merged list is : ");
        l1.printList(newHead);
    }
}
