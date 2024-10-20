package com.sky.algorithmleetcode;

/*
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。  例如，给定一个 3叉树 :          返回其层序遍历:  [    [1],
    [3,2,4],    [5,6] ]      说明:   	树的深度不会超过 1000。 	树的节点总数不会超过 5000。
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class L429Solution {
    class Node {
        public int val;
        public List<L429Solution.Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<L429Solution.Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(L429Solution.Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<L429Solution.Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                L429Solution.Node current = queue.poll();
                level.add(current.val);
                
                if (current.children != null) {
                    for (L429Solution.Node child : current.children) {
                        queue.offer(child);
                    }
                }
            }
            
            result.add(level);
        }
        
        return result;
    }
} 