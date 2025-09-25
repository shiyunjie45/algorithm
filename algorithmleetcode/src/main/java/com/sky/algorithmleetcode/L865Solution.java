package com.sky.algorithmleetcode;

/*
给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。 一个结点的子树是该结
点加上它的所有后代的集合。 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。   示例： 输入：[3,5,1,6,2,0,8,
null,null,7,4] 输出：[2,7,4] 解释： 我们返回值为 2 的结点，在图中用黄色标记。 在图中用蓝色标记的是树的最深的结点。 输入 "[3, 
5, 1, 6, 2, 0, 8, null, null, 7, 4]" 是对给定的树的序列化表述。 输出 "[2, 7, 4]" 是对根结点的值为 2 的子树
的序列化表述。 输入和输出都具有 TreeNode 类型。    提示：  	树中结点的数量介于 1 和 500 之间。 	每个结点的值都是独一无二的。
*/

 class L865Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth == rightDepth) {
            return root;
        } else if (leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
} 