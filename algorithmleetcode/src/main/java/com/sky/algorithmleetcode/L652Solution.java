package com.sky.algorithmleetcode;

/*
给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 两棵树重复是指它们具有相同的结构以及相同的结点值。 示例 1：
     1    / \    2  3   /  / \   4  2  4    /    4  下面是两个重复的子树：    2   /   4  和 
  4  因此，你需要以列表的形式返回上述重复子树的根结点。
*/

 java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L652Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        dfs(root, map, res);
        return res;
    }

    private String dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) {
            return "#";
        }
        String subtree = node.val + "," + dfs(node.left, map, res) + "," + dfs(node.right, map, res);
        map.put(subtree, map.getOrDefault(subtree, 0) + 1);
        if (map.get(subtree) == 2) {
            res.add(node);
        }
        return subtree;
    }

} 