package com.sky.algorithmleetcode;

/*
给定一个二叉树，返回它的 前序 遍历。  示例: 输入: [1,null,2,3]   1   \   2   /  3  输出: [1,2,3]  进阶: 递
归算法很简单，你可以通过迭代算法完成吗？
*/

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L144Solution {
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    } 
} 