package com.sky.algorithmleetcode;

/*
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值
之和。   例如： 输入: 原始二叉搜索树:        5       /  \      2   13 输出: 转换为累加树:       18     
  /  \      20   13    注意：本题和 1038: https://leetcode-cn.com/problems/binary-sear
ch-tree-to-greater-sum-tree/ 相同
*/

 class L538Solution {
    int sum = 0;//保存大于当前节点值的累加和
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    private void traverse(TreeNode root){
        if(root == null) return;
        //遍历右子树
        traverse(root.right);
        //累加和
        sum += root.val;
        //更新当前节点的值
        root.val = sum;
        //遍历左子树
        traverse(root.left);
    }
} 