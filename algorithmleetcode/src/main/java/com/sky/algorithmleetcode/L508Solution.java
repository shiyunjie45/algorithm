package com.sky.algorithmleetcode;

/*
给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 你需要返回出
现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。   示例 1： 输入:  5 / \ 2  -3  返回 
[2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 示例 2： 输入：  5 / \ 2  -5  返回 [2]，只有 2 出现两次，-5 只出
现 1 次。   提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
*/

 java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L508Solution {
    private Map<Integer, Integer> map;
    private int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        maxCount = 0;
        helper(root);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        int sum = node.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, map.get(sum));
        return sum;
    }
} 