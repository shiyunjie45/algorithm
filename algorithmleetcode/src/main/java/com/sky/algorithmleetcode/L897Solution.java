package com.sky.algorithmleetcode;

/*
给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。   示例 ： 输入：[5,3,6,2,4
,null,8,1,null,null,null,7,9]     5    / \   3  6  / \  \  2  4  8  /    / \ 1  
  7  9 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]  1   \   2
    \    3     \     4      \      5       \       6        \        7         \
         8          \         9    提示：  	给定树中的结点数介于 1 和 100 之间。 	每个结点都有一个从 0 到 1
000 范围内的唯一整数值。
*/

 class L897Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode(0); // 创建新的根节点，值为0，方便后续连接操作。
        TreeNode cur = newRoot; // 新建一个指针指向新的根节点 
        Stack<TreeNode> stack = new Stack<>(); // 栈用于中序遍历树
        
        while(!stack.empty() || root != null) {
            while(root != null) { // 左子节点不为空，则一直将左子节点入栈
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // 栈顶元素出栈
            cur.right = new TreeNode(root.val); // 非递归方式，将当前节点的值赋给新节点的右子节点
            cur = cur.right; // 当前节点指向其右子节点
            root = root.right; // 遍历右子树
        }
        return newRoot.right; // 返回新的根节点的右子节点
    }
} 