package com.sky.algorithmleetcode;

/*
给定一个二叉树，在树的最后一行找到最左边的值。 示例 1:  输入:   2  / \  1  3 输出: 1    示例 2:  输入:     1    /
 \    2  3   /  / \   4  5  6    /    7 输出: 7    注意: 您可以假设树（即给定的根节点）不为 NULL。
*/

import java.util.LinkedList;
import java.util.Queue;

public class L513Solution {
    static class TreeNode {
        int val;
        L513Solution.TreeNode left;
        L513Solution.TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, L513Solution.TreeNode left, L513Solution.TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
    public int findBottomLeftValue(L513Solution.TreeNode root) {
        Queue<L513Solution.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                L513Solution.TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2, new L513Solution.TreeNode(1), new TreeNode(3));
        System.out.println(new L513Solution().findBottomLeftValue(root1)); // 1

        TreeNode node4 = new L513Solution.TreeNode(4);
        TreeNode node5 = new L513Solution.TreeNode(5);
        TreeNode node6 = new L513Solution.TreeNode(6, new TreeNode(7), null);

        TreeNode root2 = new TreeNode(1, new L513Solution.TreeNode(2, node4, null), new L513Solution.TreeNode(3, node5, node6));
        System.out.println(new L513Solution().findBottomLeftValue(root2)); // 7
    }
}

