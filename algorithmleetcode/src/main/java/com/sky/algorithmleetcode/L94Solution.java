package com.sky.algorithmleetcode;

/*
给定一个二叉树，返回它的中序 遍历。 示例: 输入: [1,null,2,3]  1   \   2   /  3 输出: [1,3,2] 进阶: 递归算法很简
单，你可以通过迭代算法完成吗？
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class L94Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(L94Solution.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<L94Solution.TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
} 