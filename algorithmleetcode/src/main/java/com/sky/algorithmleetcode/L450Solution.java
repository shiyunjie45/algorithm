package com.sky.algorithmleetcode;

/*
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节
点的引用。 一般来说，删除节点可分为两个步骤：  	首先找到需要删除的节点； 	如果找到了，删除它。  说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 示例:  root = [5,3,6,2,4,null,7] key = 3   5  / \  3  6 / \  \ 2  4  7 给定需要删除的节点值
是 3，所以我们首先找到 3 这个节点，然后删除它。 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。   5  / \  4  6
 /   \ 2    7 另一个正确答案是 [5,2,6,null,4,null,7]。   5  / \  2  6  \  \   4  7
*/

 L450Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key) {
            if(root.left == null && root.right == null) return null; // 叶子节点，直接删除
            if(root.left == null) return root.right; // 左子树为空，直接将右子树作为新的根节点
            if(root.right == null) return root.left; // 右子树为空，直接将左子树作为新的根节点
            
            // 左右子树都不为空
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val; // 用后继节点的值替换
            root.right = deleteNode(root.right, minNode.val); // 删除后继节点
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        
        return root;
    }
    
    // 查找以某个节点为根的二叉搜索树的最小节点
    private TreeNode findMin(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
} 