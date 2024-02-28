package com.algorithms.tree;

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class RangeSumOfABST {
    private int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        return root.val
            + rangeSumBST(root.left, low, high)
            + rangeSumBST(root.right, low, high);
    }
    
    private TreeNode createBST(TreeNode root) {
        BinarySearchTree bst = new BinarySearchTree();
        
        if (root == null) {
            root = new TreeNode();
        }
        
        int[] values = {10, 5, 15, 3, 7, 18};
        
        for (int value : values) {
            root = bst.addTreeNode(value, root);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        RangeSumOfABST obj = new RangeSumOfABST();
        TreeNode root = obj.createBST(null);
        
        int res = obj.rangeSumBST(root, 7, 15);
        System.out.println("Range Sum of BST = " + res);
    }
}
