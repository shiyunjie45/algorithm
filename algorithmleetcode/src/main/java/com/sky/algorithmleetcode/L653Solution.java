package com.sky.algorithmleetcode;

/*
给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 案例 1:  输入:   5  / \  3  
6 / \  \ 2  4  7 Target = 9 输出: True    案例 2:  输入:   5  / \  3  6 / \  \ 2  4  7
 Target = 28 输出: False
*/

 java.util.HashSet;
import java.util.Set;

public class L653Solution {
    public boolean findTarget(TreeNode root, int k) {
        // 利用 HashSet 存储节点值
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        // 当前节点的值为 k - 已遍历节点中的某个值
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val); // 将当前节点加入已遍历节点
        // 递归遍历左右子树
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
} 