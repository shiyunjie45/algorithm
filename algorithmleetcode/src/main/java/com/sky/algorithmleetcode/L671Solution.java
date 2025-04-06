package com.sky.algorithmleetcode;

/*
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。  
给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 示例 1:  输入:   2  / \  2  5   / \
   5  7 输出: 5 说明: 最小的值是 2 ，第二小的值是 5 。  示例 2:  输入:   2  / \  2  2 输出: -1 说明: 最小的值
是 2, 但是不存在第二小的值。
*/

 class L671Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1; // 根节点为空或只有一个子节点，直接返回-1
        int left = root.left.val;
        int right = root.right.val;
        // 当节点的值等于左右子节点值时，分别递归查找左右子树中第二小的值，取较小值
        if (root.val == left && root.val == right) {
            int leftSecond = findSecondMinimumValue(root.left);
            int rightSecond = findSecondMinimumValue(root.right);
            if (leftSecond == -1 && rightSecond == -1) return -1; // 左右子树都没有第二小的节点，返回-1
            else if (leftSecond == -1) return rightSecond; // 左子树没有第二小的节点，返回右子树中的第二小节点
            else if (rightSecond == -1) return leftSecond; // 右子树没有第二小的节点，返回左子树中的第二小节点
            else return Math.min(leftSecond, rightSecond); // 左右子树都有第二小的节点，返回最小值
        }
        // 当节点的值等于左子节点或右子节点值时，返回另外一个节点的值
        else if (root.val == left) {
            int rightSecond = findSecondMinimumValue(root.right);
            return rightSecond == -1 ? right : Math.min(right, rightSecond);
        } else {
            int leftSecond = findSecondMinimumValue(root.left);
            return leftSecond == -1 ? left : Math.min(left, leftSecond);
        }
    }
} 