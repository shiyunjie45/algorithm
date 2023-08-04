package com.sky.algorithmleetcode;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。 注意: 你可以假设树中没有重复的元素。 例如，给出 前序遍历 preorder = [3,9,20,15,7] 中序
遍历 inorder = [9,3,15,20,7] 返回如下的二叉树：   3  / \  9 20   / \  15  7
*/



public class L105Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize, 
                          inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, 
                           inorder, index + 1, inEnd);
        return root;
    }
} 