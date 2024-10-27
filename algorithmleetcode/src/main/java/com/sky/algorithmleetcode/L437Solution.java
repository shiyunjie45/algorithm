package com.sky.algorithmleetcode;

/*
给定一个二叉树，它的每个结点都存放着一个整数值。 找出路径和等于给定数值的路径总数。 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（
只能从父节点到子节点）。 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 示例： root = [10,5,-3,
3,2,null,11,3,-2,null,1], sum = 8    10   / \   5  -3  / \  \  3  2  11 / \  \ 3
 -2  1 返回 3。和等于 8 的路径有: 1. 5 -> 3 2. 5 -> 2 -> 1 3. -3 -> 11
*/

 L437Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int pathImLeading = count(root, sum);
        int leftPathSum = pathSum(root.left, sum);
        int rightPathSum = pathSum(root.right, sum);
        return leftPathSum + rightPathSum + pathImLeading;
    }

    private int count(TreeNode node, int target) {
        if (node == null) {
            return 0;
        }

        int isMe = node.val == target ? 1 : 0;
        int leftRemain = target - node.val;
        int left = count(node.left, leftRemain);
        int rightRemain = target - node.val;
        int right = count(node.right, rightRemain);
        return isMe + left + right;
    }
} 