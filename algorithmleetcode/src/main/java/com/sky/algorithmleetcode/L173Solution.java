package com.sky.algorithmleetcode;

/*
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 调用 next() 将返回二叉搜索树中的下一个最小的数。   示例：  BSTIterato
r iterator = new BSTIterator(root); iterator.next();  // 返回 3 iterator.next();  
// 返回 7 iterator.hasNext(); // 返回 true iterator.next();  // 返回 9 iterator.hasNex
t(); // 返回 true iterator.next();  // 返回 15 iterator.hasNext(); // 返回 true iterat
or.next();  // 返回 20 iterator.hasNext(); // 返回 false   提示：  	next() 和 hasNext() 
操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 	你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，B
ST 中至少存在一个下一个最小的数。
*/

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class L173Solution {

    private Stack<TreeNode> stack;

    public L173Solution(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode nextNode = node.right;
        while (nextNode != null) {
            stack.push(nextNode);
            nextNode = nextNode.left;
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
} 