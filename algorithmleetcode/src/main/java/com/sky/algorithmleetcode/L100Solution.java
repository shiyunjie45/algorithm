package com.sky.algorithmleetcode;

/*
给定两个二叉树，编写一个函数来检验它们是否相同。 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 示例 1: 输入:    1     1 
     / \    / \     2  3   2  3     [1,2,3],  [1,2,3] 输出: true 示例 2: 输入:   1    
 1      /      \     2       2     [1,2],   [1,null,2] 输出: false  示例 3: 输入:    1
     1      / \    / \     2  1   1  2     [1,2,1],  [1,1,2] 输出: false
*/

 class L100Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个树都为空，则认为它们是相同的
        if (p == null && q == null) {
            return true;
        }
        // 如果只有一个树为空，则认为它们不相同
        if (p == null || q == null) {
            return false;
        }
        // 如果节点的值不同，则认为它们不相同
        if (p.val != q.val) {
            return false;
        }
        // 递归检查左子树和右子树是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
} 