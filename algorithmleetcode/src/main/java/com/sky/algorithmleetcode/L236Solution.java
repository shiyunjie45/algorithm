package com.sky.algorithmleetcode;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,n
ull,null,7,4]    示例 1: 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出
: 3 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。  示例 2: 输入: root = [3,5,1,6,2,0,8,null,null,7,4]
, p = 5, q = 4 输出: 5 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。    说明:  
	所有节点的值都是唯一的。 	p、q 为不同节点且均存在于给定的二叉树中。
*/

/**
 * Definition for TreeNode.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class L236Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // 如果为空节点，或等于 p 或 q 节点，那么当前节点就是最近公共祖先节点
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);  // 在左子树中查找 p 和 q 节点的最近公共祖先节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);  // 在右子树中查找 p 和 q 节点的最近公共祖先节点
        if (left != null && right != null) {
            // 如果左子树和右子树都找到了最近公共祖先节点，那么当前节点就是最近公共祖先节点
            return root;
        } else if (left != null) {
            // 如果只在左子树找到了最近公共祖先节点，那么返回左子树中找到的节点
            return left;
        } else {
            // 否则返回右子树中找到的节点
            return right;
        }
    }
} 