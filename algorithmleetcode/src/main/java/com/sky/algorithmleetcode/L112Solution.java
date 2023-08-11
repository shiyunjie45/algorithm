package com.sky.algorithmleetcode;

/*
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 说明: 叶子节点是指没有子节点的节点。 示例:  给
定如下二叉树，以及目标和 sum = 22，        5       / \       4  8      /  / \      11 13 4   
  / \   \     7  2   1  返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
*/

 class L112Solution {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         public TreeNode(int val) {
             this.val = val;
         }
     }
     public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 如果当前节点是叶子节点，并且sum减到节点值刚好为0，说明存在和为sum的路径
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // 递归判断左子树和右子树是否存在和为(sum - val)的路径
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        L112Solution solution = new L112Solution();
        System.out.println(solution.hasPathSum(root, 22));   // true
    }
}

