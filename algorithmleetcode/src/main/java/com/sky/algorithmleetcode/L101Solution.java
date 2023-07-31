package com.sky.algorithmleetcode;

/*
给定一个二叉树，检查它是否是镜像对称的。   例如，二叉树 [1,2,2,3,4,4,3] 是对称的。   1  / \  2  2 / \ / \ 3 4 4
 3    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:   1  / \  2  2  \  \  3  3    进阶： 你
可以运用递归和迭代两种方法解决这个问题吗？
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class L101Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { // 空树
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) { // 左右子树均为null
            return true;
        }
        if (left == null || right == null) { // 左右子树有一个为null
            return false;
        }
        if (left.val != right.val) { // 左右子树根节点不同
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
} 