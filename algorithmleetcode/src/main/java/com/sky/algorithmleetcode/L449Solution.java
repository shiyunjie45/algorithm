package com.sky.algorithmleetcode;

/*
序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 设计一个算
法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索
树。 编码的字符串应尽可能紧凑。 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
*/

 java.util.*;
import java.io.*;

public class L449Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder ans = new StringBuilder();
        serialize(root, ans);
        return ans.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
  
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<Integer> q = new LinkedList<>();
        for (String s : data.split(","))
            q.add(Integer.parseInt(s));
        return dfs(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(Queue<Integer> q, int lower, int upper) {
        if (q.isEmpty()) return null;
        int val = q.peek();
        if (val < lower || val > upper) return null;
        q.poll();
        TreeNode node = new TreeNode(val);
        node.left = dfs(q, lower, val);
        node.right = dfs(q, val, upper);
        return node;
    }
} 