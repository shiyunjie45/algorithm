package com.sky.algorithmleetcode;

/*
给定一个二叉树，原地将它展开为链表。 例如，给定二叉树   1  / \  2  5 / \  \ 3  4  6 将其展开为： 1 \  2  \   3  
 \    4    \     5     \      6
*/

class L114Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.left != null) {
            flatten(root.left);
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) root = root.right;
            root.right = tmp;
        }
        flatten(root.right);
    }
} 