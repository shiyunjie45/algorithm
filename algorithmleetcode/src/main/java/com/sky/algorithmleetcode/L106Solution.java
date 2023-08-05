package com.sky.algorithmleetcode;

/*
根据一棵树的中序遍历与后序遍历构造二叉树。 注意: 你可以假设树中没有重复的元素。 例如，给出 中序遍历 inorder = [9,3,15,20,7] 后序遍
历 postorder = [9,15,7,20,3] 返回如下的二叉树：   3  / \  9 20   / \  15  7
*/

import java.util.HashMap;
import java.util.Map;

class L106Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, n - 1, indexMap, 0, n - 1);
    }

    private TreeNode buildTree(int[] postorder, int postorderLeft, int postorderRight,
                               Map<Integer, Integer> indexMap, int inorderLeft, int inorderRight) {
        if (postorderLeft > postorderRight) {
            return null;
        }
        int rootVal = postorder[postorderRight];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIndex = indexMap.get(rootVal);
        int leftSubtreeSize = inorderRootIndex - inorderLeft;
        root.left = buildTree(postorder, postorderLeft, postorderLeft + leftSubtreeSize - 1,
                indexMap, inorderLeft, inorderRootIndex - 1);
        root.right = buildTree(postorder, postorderLeft + leftSubtreeSize, postorderRight - 1,
                indexMap, inorderRootIndex + 1, inorderRight);
        return root;
    }
} 