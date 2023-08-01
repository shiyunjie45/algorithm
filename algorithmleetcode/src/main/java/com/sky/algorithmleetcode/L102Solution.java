package com.sky.algorithmleetcode;

/*
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。   示例： 二叉树：[3,9,20,null,null,15,7]
,   3  / \  9 20   / \  15  7  返回其层次遍历结果： [  [3],  [9,20],  [15,7] ]
*/

import java.util.*;

public class L102Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(L102Solution.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<L102Solution.TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 将根节点入队
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) { // 遍历当前层的所有节点
                L102Solution.TreeNode node = queue.poll();
                level.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left); // 将左子节点入队
                }
                
                if (node.right != null) {
                    queue.offer(node.right); // 将右子节点入队
                }
            }
            
            result.add(level);
        }
        
        return result;
    }
}

