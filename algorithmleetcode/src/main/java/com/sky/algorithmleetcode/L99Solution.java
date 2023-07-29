package com.sky.algorithmleetcode;

/*
二叉搜索树中的两个节点被错误地交换。 请在不改变其结构的情况下，恢复这棵树。 示例 1: 输入: [1,3,null,null,2]   1   /  3   
\   2 输出: [3,1,null,null,2]   3   /  1   \   2  示例 2: 输入: [3,1,4,null,null,2]  3
 / \ 1  4   /   2 输出: [2,1,4,null,null,3]  2 / \ 1  4   /  3 进阶:  	使用 O(n) 空间复杂度
的解法很容易实现。 	你能想出一个只使用常数空间的解决方案吗？
*/

 class L99Solution {
    private TreeNode pre, first, second;

    public void recoverTree(TreeNode root) {
        pre = first = second = null;
        traverse(root);
        swap(first, second);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        traverse(root.right);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
} 