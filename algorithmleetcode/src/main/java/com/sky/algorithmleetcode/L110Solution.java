package com.sky.algorithmleetcode;

/*
给定一个二叉树，判断它是否是高度平衡的二叉树。 本题中，一棵高度平衡二叉树定义为：  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。  示例 1:
 给定二叉树 [3,9,20,null,null,15,7]   3  / \  9 20   / \  15  7 返回 true 。 示例 2: 给定二叉树
 [1,2,2,3,3,null,null,4,4]     1    / \   2  2   / \  3  3  / \ 4  4  返回 false 。
*/

class L110Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node){
        if(node == null) return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
} 