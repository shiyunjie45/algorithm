package com.sky.algorithmleetcode;

/*
给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 返回到目标结点 target 距离为 K 的所有结点的值的列表。 
答案可以以任何顺序返回。     示例 1： 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 
2 输出：[7,4,1] 解释： 所求结点为与目标结点（值为 5）距离为 2 的结点， 值分别为 7，4，以及 1  注意，输入的 "root" 和 "targ
et" 实际上是树上的结点。 上面的输入仅仅是对这些对象进行了序列化描述。    提示：  	给定的树是非空的，且最多有 K 个结点。 	树上的每个结点都具有唯
一的值 0  。 	目标结点 target 是树上的结点。 	0 .
*/

 java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L863Solution {
    private HashMap<TreeNode, TreeNode> parentMap;
    private List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parentMap = new HashMap<>();
        res = new ArrayList<>();
        dfs(root, null);
        bfs(target, K);
        return res;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null) return;
        parentMap.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    private void bfs(TreeNode target, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        int level = 0;
        queue.add(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (level == k) res.add(node.val);
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
            if (level == k) break;
            level++;
        }
    }
} 