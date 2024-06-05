package com.sky.algorithmleetcode;

/*
给出一个完全二叉树，求出该树的节点个数。 说明： 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的
节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。 示例: 输入:   1  / \  2  3 / \ / 4 5 6 
输出: 6
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
public class L222Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 0;
        TreeNode p = root;
        while (p.left != null) {
            leftHeight++;
            p = p.left;
        }
        int rightHeight = 0;
        TreeNode q = root;
        while (q.right != null) {
            rightHeight++;
            q = q.right;
        }
        if (leftHeight == rightHeight) { // 左右子树高度相同，是满二叉树
            return (1 << leftHeight + 1) - 1; // 左移运算符，相当于2的幂次方
        } else { // 左右子树高度不同
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
} 