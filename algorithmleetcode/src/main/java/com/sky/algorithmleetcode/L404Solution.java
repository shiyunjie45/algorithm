package com.sky.algorithmleetcode;

/*
计算给定二叉树的所有左叶子之和。 示例：    3  / \  9 20   / \  15  7 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回
 24
*/

 L404Solution {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {  //判断当前节点的左孩子是否为叶子节点
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);  //递归计算左子树的左叶子之和
        sum += sumOfLeftLeaves(root.right);  //递归计算右子树的左叶子之和
        return sum;
    }
} 