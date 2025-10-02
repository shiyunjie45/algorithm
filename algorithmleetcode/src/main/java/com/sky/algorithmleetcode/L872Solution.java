package com.sky.algorithmleetcode;

/*
请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。  举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8)
 的树。 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 
true；否则返回 false 。   提示：  	给定的两颗树可能会有 1 到 200 个结点。 	给定的两颗树上的值介于 0 到 200 之间。
*/

 java.util.ArrayList;
import java.util.List;

public class L872Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        if (leaves1.size() != leaves2.size()) { // 两棵树叶子结点数不同，一定不相似
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i) != leaves2.get(i)) { // 两棵树叶子结点不同，不相似
                return false;
            }
        }
        return true; // 两棵树叶子结点均相同，相似
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) { // 叶子结点
            list.add(node.val);
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
} 