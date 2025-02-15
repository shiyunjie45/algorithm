package com.sky.algorithmleetcode;

/*
给定一个 N 叉树，返回其节点值的前序遍历。  例如，给定一个 3叉树 :          返回其前序遍历: [1,3,5,6,2,4]。     说明: 递
归法很简单，你可以使用迭代法完成此题吗?
*/

 java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L589Solution {
    // Definition for Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();
            result.add(current.val);
            List<Node> children = current.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return result;
    }
} 