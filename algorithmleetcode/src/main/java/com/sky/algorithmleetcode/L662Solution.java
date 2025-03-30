package com.sky.algorithmleetcode;

/*
给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为
空。 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 示例 1:  输入:       1     / 
 \     3   2    / \   \     5  3   9  输出: 4 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)
。  示例 2:  输入:       1     /      3      / \       5  3    输出: 2 解释: 最大值出现在树的第 3 
层，宽度为 2 (5,3)。  示例 3:  输入:       1     / \     3  2     /        5    输出: 2 解释: 
最大值出现在树的第 2 层，宽度为 2 (3,2)。  示例 4:  输入:       1     / \     3  2    /   \     5  
  9    /     \   6      7 输出: 8 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,n
ull,null,7)。  注意: 答案在32位有符号整数的表示范围内。
*/

 java.util.LinkedList;
import java.util.Queue;

public class L662Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = indexQueue.peek();
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = indexQueue.poll();
                right = index;
                if (node.left != null) {
                    queue.offer(node.left);
                    indexQueue.offer(index * 2 + 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexQueue.offer(index * 2 + 2);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        // 构造测试样例二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        L662Solution solution = new L662Solution();
        System.out.println(solution.widthOfBinaryTree(root)); // 4
    }
} 