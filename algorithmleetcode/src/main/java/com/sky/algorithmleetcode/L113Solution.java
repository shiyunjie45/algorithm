package com.sky.algorithmleetcode;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 说明: 叶子节点是指没有子节点的节点。 示例: 给定如下二叉树，以及目标和
 sum = 22，        5       / \       4  8      /  / \      11 13 4     / \  / \  
   7  2 5  1  返回: [  [5,4,11,2],  [5,8,4,5] ]
*/

import java.util.ArrayList;
import java.util.List;

public class L113Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, sum, path, result);
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        //将当前节点加入路径中
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            //找到一个叶子节点，且路径和等于目标和，将路径加入结果集中
            result.add(new ArrayList<>(path));
        } else {
            //递归遍历左右子树
            helper(root.left, sum - root.val, path, result);
            helper(root.right, sum - root.val, path, result);
        }
        //回溯，将当前节点从路径中移除
        path.remove(path.size() - 1);
    }
} 