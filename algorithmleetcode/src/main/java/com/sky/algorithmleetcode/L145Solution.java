package com.sky.algorithmleetcode;

/*
给定一个二叉树，返回它的 后序 遍历。 示例: 输入: [1,null,2,3]   1   \   2   /  3  输出: [3,2,1] 进阶: 递归算
法很简单，你可以通过迭代算法完成吗？
*/

import java.util.*;

public class L145Solution {

    // 递归实现后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalHelper(root, res);
        return res;
    }

    private void postorderTraversalHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversalHelper(root.left, res);
        postorderTraversalHelper(root.right, res);
        res.add(root.val);
    }

    // 非递归实现后序遍历
    public List<Integer> postorderTraversalIteratively(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && pre != peek.right) {
                    cur = peek.right;
                } else {
                    res.add(peek.val);
                    pre = peek;
                    stack.pop();
                }
            }
        }
        return res;
    }
} 