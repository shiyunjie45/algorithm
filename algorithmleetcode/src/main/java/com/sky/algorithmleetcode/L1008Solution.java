package com.sky.algorithmleetcode;

/*
返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。 (回想一下，二叉搜索树是二叉树的一种，其每个节点都满
足以下规则，对于 node.left 的任何后代，值总 node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显
示节点的值，然后遍历 node.left，接着遍历 node.right。）   示例： 输入：[8,5,1,7,10,12] 输出：[8,5,10,1,7,n
ull,12]    提示：  	1 	先序 preorder 中的值是不同的。
*/
class L1008Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, bound);
        return root;
    }
}
