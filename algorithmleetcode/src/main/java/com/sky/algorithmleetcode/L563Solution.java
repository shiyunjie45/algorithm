package com.sky.algorithmleetcode;

/*
给定一个二叉树，计算整个树的坡度。 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。 整个树的坡度就是其所有
节点的坡度之和。 示例:  输入:      1    /  \    2   3 输出: 1 解释: 结点的坡度 2 : 0 结点的坡度 3 : 0 结点的坡
度 1 : |2-3| = 1 树的坡度 : 0 + 0 + 1 = 1  注意:  	任何子树的结点的和不会超过32位整数的范围。 	坡度的值不会超过32位整
数的范围。
*/

 class L563Solution {
    int tilt = 0; // 全局变量记录坡度

    public int findTilt(TreeNode root) {
        sum(root); // 递归求每个节点的子树节点之和
        return tilt;
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        int leftSum = sum(node.left); // 左子树节点之和
        int rightSum = sum(node.right); // 右子树节点之和
        tilt += Math.abs(leftSum - rightSum); // 累加坡度
        return leftSum + node.val + rightSum; // 当前子树的节点之和
    }
} 