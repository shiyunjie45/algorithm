package com.sky.algorithmleetcode;

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。 说明: 叶子节点是指没有子节点的节点。 示例: 输入:   1 /  \ 2   3 \  5 输出: ["
1->2->5", "1->3"] 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
*/

import java.util.ArrayList;
import java.util.List;
public class L257Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        helper(res, root, "");

        return res;
    }

    private static void helper(List<String> res, TreeNode node, String path) {
        if (node.left == null && node.right == null)
            res.add(path + node.val); // 添加当前节点的值

        if (node.left != null)
            helper(res, node.left, path + node.val + "->"); // 继续递归左子树

        if (node.right != null)
            helper(res, node.right, path + node.val + "->"); // 继续递归右子树
    }
}

