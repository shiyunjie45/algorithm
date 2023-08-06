package com.sky.algorithmleetcode;

/*
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 例如： 给定二叉树 [3,9,20,null,nu
ll,15,7],   3  / \  9 20   / \  15  7  返回其自底向上的层次遍历为： [  [15,7],  [9,20],  [3] ]
*/

import java.util.*;

public class L107Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            res.add(0, curLevel);
        }
        return res;
    }
} 