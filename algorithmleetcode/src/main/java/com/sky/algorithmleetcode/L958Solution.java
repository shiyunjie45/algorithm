package com.sky.algorithmleetcode;

/*
给定一个二叉树，确定它是否是一个完全二叉树。 百度百科中对完全二叉树的定义如下： 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达
到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）   示例 1：  输入：[1,2,3,4
,5,6] 输出：true 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地
向左。  示例 2：  输入：[1,2,3,4,5,null,7] 输出：false 解释：值为 7 的结点没有尽可能靠向左侧。    提示：  	树中将会有 
1 到 100 个结点。
*/

 class L958Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        // 定义flag变量表示当前节点是否为叶子节点
        boolean flag = false;
        // 定义队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 如果当前节点是叶子节点
            if (node.left == null) {
                flag = true;
            // 如果当前节点不是叶子节点，但之前出现过叶子节点了
            } else if (flag) {
                return false;
            // 如果当前节点不是叶子节点，但左孩子为null，右孩子不为null
            } else if (node.left == null && node.right != null) {
                return false;
            // 如果当前节点不是叶子节点，将左右孩子加入队列继续遍历
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
} 