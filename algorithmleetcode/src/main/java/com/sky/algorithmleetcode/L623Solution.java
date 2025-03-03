package com.sky.algorithmleetcode;

/*
给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空
节点 N，为 N 创建两个值为 v 的左子树和右子树。 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。 如
果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。 示例 1:  输入: 二叉树如下所示:    4  
 /  \   2   6  / \  /  3  1 5   v = 1 d = 2 输出:     4    / \   1  1   /   \  2  
  6  / \   /  3  1  5    示例 2:  输入: 二叉树如下所示:    4   /    2    / \   3  1   v = 1
 d = 3 输出:    4   /    2  / \    1  1 /   \  3    1  注意:  	输入的深度值 d 的范围是：[1，二叉树最
大深度 + 1]。 	输入的二叉树至少有一个节点。
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
class L623Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level == d - 1) {
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    left.left = node.left;
                    node.left = left;
                    right.right = node.right;
                    node.right = right;
                } else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            if (level == d - 1) {
                break;
            }
            level++;
        }
        return root;
    }
} 