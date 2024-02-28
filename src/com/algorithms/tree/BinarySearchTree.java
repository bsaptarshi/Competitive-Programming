package com.algorithms.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode newTreeNode(int val) {
        TreeNode node = new TreeNode(val);
        node.left = null;
        node.right = null;
        
        return node;
    }
}
public class BinarySearchTree {
    public TreeNode addTreeNode(int val, TreeNode root) {
        TreeNode dummyRoot = root;
        TreeNode newNode = TreeNode.newTreeNode(val);
        
        if (root == null) {
            return newNode;
        }
        
        TreeNode parent = null;
        
        while (root != null) {
            parent = root;
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        if (val < parent.val) {
            parent.left = newNode;
        } else if (val > parent.val) {
            parent.right = newNode;
        } else {
            return dummyRoot;
        }
        
        return dummyRoot;
    }
    
    public TreeNode searchTreeNode(int val, TreeNode root) {
        if (root == null) {
            return root;
        }
        
        while(root != null) {
            if (val == root.val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return root;
    }
    
    public TreeNode addTreeNodeRecursive(int value, TreeNode root) {
        if (root == null) {
            return new TreeNode(value);
        }
        
        if (value < root.val) {
            root.left = addTreeNode(value, root.left);
        } else if (value > root.val) {
            root.right = addTreeNode(value, root.right);
        } else {
            return root;
        }
        
        return root;
    }
    
    public TreeNode searchTreeNodeRecursive(int val, TreeNode root) {
        if (root == null || root.val == val) {
            return root;
        }
        
        return val < root.val ? searchTreeNodeRecursive(val, root.left)
                : searchTreeNodeRecursive(val, root.right);
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode rootRec = new TreeNode();
        
        rootRec = bst.addTreeNodeRecursive(10, rootRec);
        rootRec = bst.addTreeNodeRecursive(5, rootRec);
        rootRec = bst.addTreeNodeRecursive(8, rootRec);
        rootRec = bst.addTreeNodeRecursive(6, rootRec);
        rootRec = bst.addTreeNodeRecursive(4, rootRec);
        rootRec = bst.addTreeNodeRecursive(9, rootRec);
        rootRec = bst.addTreeNodeRecursive(1, rootRec);
        rootRec = bst.addTreeNodeRecursive(2, rootRec);
        
        TreeNode resultRec = bst.searchTreeNodeRecursive(2, rootRec);
        System.out.println("Result = " + resultRec.val);
        
        TreeNode root = new TreeNode();
        root = bst.addTreeNode(10, root);
        root = bst.addTreeNode(5, root);
        root = bst.addTreeNode(8, root);
        root = bst.addTreeNode(6, root);
        root = bst.addTreeNode(4, root);
        root = bst.addTreeNode(9, root);
        root = bst.addTreeNode(1, root);
        root = bst.addTreeNode(2, root);
        
        TreeNode result = bst.searchTreeNode(8, root);
        System.out.println("Result = " + result.val);
    }
}
