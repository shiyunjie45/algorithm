package com.sky.algorithmleetcode;

/*
给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。 示例: 输入: 3 输出: [   [1,null,3,2],   [3,2,null
,1],   [3,1,null,null,2],   [2,1,3],   [1,null,2,null,3] ] 解释: 以上的输出对应以下 5 种不同结构
的二叉搜索树：   1     3   3   2   1   \    /   /   / \   \   3   2   1   1  3   2   / 
  /    \         \  2   1     2         3
*/

 java.util.ArrayList;
import java.util.List;

public class L95Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
} 