package com.sky.algorithmleetcode;

/*
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 注意：两个节点之间的路径长度由它们之间的边数表示。 示例
 1: 输入:         5       / \       4  5      / \  \      1  1  5  输出:  2  示例 2: 输
入:         1       / \       4  5      / \  \      4  4  5  输出:  2  注意: 给定的二叉树不超
过10000个结点。 树的高度不超过1000。
*/

 class L687Solution {
    private int maxLen = 0; // 保存最长路径的长度

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val); // 从根节点开始遍历
        return maxLen;
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, node.val); // 计算左子树的最长路径长度
        int right = dfs(node.right, node.val); // 计算右子树的最长路径长度
        maxLen = Math.max(maxLen, left + right); // 更新最长路径长度
        if (node.val == val) { // 判断左右子树是否与当前节点相等
            return Math.max(left, right) + 1; // 返回子树中较长的路径长度+1
        } else {
            return 0; // 不相等则返回0
        }
    }
} 