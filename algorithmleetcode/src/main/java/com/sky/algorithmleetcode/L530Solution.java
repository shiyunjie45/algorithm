package com.sky.algorithmleetcode;

/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。   示例： 输入：   1   \   3   /  2 输出： 1 解释：
 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。    提示：  	树中至少有 2 个节点。 	本题与 783 https://l
eetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
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
public class L530Solution {
    int minDiff=Integer.MAX_VALUE;
    Integer pre=null;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);//中序遍历
        return minDiff;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(pre!=null) minDiff=Math.min(minDiff,Math.abs(root.val-pre));
        pre=root.val;
        dfs(root.right);
    }
} 