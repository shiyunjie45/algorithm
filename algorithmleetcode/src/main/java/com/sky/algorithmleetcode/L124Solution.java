package com.sky.algorithmleetcode;

/*
给定一个非空二叉树，返回其最大路径和。 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 示例 1:
 输入: [1,2,3]     1    / \   2  3 输出: 6  示例 2: 输入: [-10,9,20,null,null,15,7]   -1
0    / \   9  20     /  \    15   7 输出: 42
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class L124Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int newPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPath);
        return node.val + Math.max(leftGain, rightGain);
    }
} 