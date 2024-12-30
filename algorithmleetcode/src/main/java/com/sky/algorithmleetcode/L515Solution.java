package com.sky.algorithmleetcode;

/*
您需要在二叉树的每一行中找到最大的值。 示例：  输入:       1     / \     3  2    / \  \     5  3  9  输出:
 [1, 3, 9]
*/

 java.util.*;

public class L515Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(max);
        }

        return result;
    }
} 