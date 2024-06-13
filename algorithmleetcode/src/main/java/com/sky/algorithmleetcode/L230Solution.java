package com.sky.algorithmleetcode;

/*
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 说明： 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个
数。 示例 1: 输入: root = [3,1,4,null,2], k = 1  3  / \ 1  4  \   2 输出: 1 示例 2: 输入: ro
ot = [5,3,6,2,4,null,null,1], k = 3    5    / \   3  6   / \  2  4  / 1 输出: 3 进阶
： 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
*/

 class L230Solution {
    private int count;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTraversal(root);
        return result;
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        inorderTraversal(root.right);
    }
} 