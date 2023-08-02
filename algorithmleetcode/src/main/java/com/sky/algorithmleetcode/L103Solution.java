package com.sky.algorithmleetcode;

/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 例如： 给定二叉树 [3,9,20,n
ull,null,15,7],   3  / \  9 20   / \  15  7  返回锯齿形层次遍历如下： [  [3],  [20,9],  [15,
7] ]
*/

import java.util.*;

public class L103Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); // 存放结果集
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 存放当前层节点
        boolean flag = false; // 标志位，表示是否是从左向右的顺序访问节点
        queue.offer(root); // 将根节点加入队列
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            List<Integer> currLevel = new ArrayList<Integer>(); // 存放当前层节点值的列表
            for (int i = 0; i < levelSize; i++) {
                L103Solution.TreeNode node = queue.poll(); // 取出当前层的一个节点
                currLevel.add(node.val); // 将当前节点的值加入结果集
                if (node.left != null) {
                    queue.offer(node.left); // 将左子节点加入队列
                }
                if (node.right != null) {
                    queue.offer(node.right); // 将右子节点加入队列
                }
            }
            if (flag) {
                Collections.reverse(currLevel); // 若上一层是从右向左的顺序访问节点，则需要翻转当前层节点的值的列表
            }
            res.add(currLevel); // 将当前层节点的值的列表加入结果集
            flag = !flag; // 更改标志位，为下一层节点的访问顺序做准备
        }
        return res;
    }
} 