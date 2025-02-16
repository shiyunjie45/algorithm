package com.sky.algorithmleetcode;

/*
给定一个 N 叉树，返回其节点值的后序遍历。  例如，给定一个 3叉树 :          返回其后序遍历: [5,6,3,2,4,1].     说明: 递
归法很简单，你可以使用迭代法完成此题吗?
*/

 java.util.*;

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
};

public class L590Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(0, node.val);

            for (Node child : node.children) {
                stack.push(child);
            }
        }

        return result;
    }
} 