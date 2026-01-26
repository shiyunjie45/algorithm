package com.sky.algorithmleetcode;

/*
给定二叉树，按垂序遍历返回其结点值。 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。 把一条垂线从
 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。 如果两个结点位
置相同，则首先报告的结点值较小。 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。   示例 1：  输入：[3,9,20,null,null,
15,7] 输出：[[9],[3,15],[20],[7]] 解释： 在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)： 然后，值为 9 的结点出
现在 (-1, -1)； 值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)； 值为 20 的结点出现在 (1, -1)； 值为 7 的
结点出现在 (2, -2)。  示例 2：  输入：[1,2,3,4,5,6,7] 输出：[[4],[2],[1,5,6],[3],[7]] 解释： 根据给定的
方案，值为 5 和 6 的两个结点出现在同一位置。 然而，在报告 "[1,5,6]" 中，结点值 5 排在前面，因为 5 小于 6。    提示：  	树的结点
数介于 1 和 1000 之间。 	每个结点值介于 0 和 1000 之间。
*/

 java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L987Solution {
    private Map<Integer, List<NodePos>> posMap = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<Integer> sortedXValues = new ArrayList<>(posMap.keySet());
        Collections.sort(sortedXValues);

        List<List<Integer>> result = new ArrayList<>();
        for (int x : sortedXValues) {
            List<NodePos> nodeList = posMap.get(x);

            Collections.sort(nodeList);
            List<Integer> valueList = new ArrayList<>();
            for (NodePos nodePos : nodeList) {
                valueList.add(nodePos.value);
            }

            result.add(valueList);
        }

        return result;
    }

    private void dfs(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }

        List<NodePos> nodeList = posMap.getOrDefault(x, new ArrayList<>());
        nodeList.add(new NodePos(node.val, y));
        posMap.put(x, nodeList);

        dfs(node.left, x - 1, y - 1);
        dfs(node.right, x + 1, y - 1);
    }

    private static class NodePos implements Comparable<NodePos> {
        public int value;
        public int y;

        public NodePos(int value, int y) {
            this.value = value;
            this.y = y;
        }

        @Override
        public int compareTo(NodePos other) {
            if (this.y != other.y) {
                // 按照 y 坐标递减排序
                return Integer.compare(other.y, this.y);
            } else {
                // 如果 y 坐标相同，按照节点值递增排序
                return Integer.compare(this.value, other.value);
            }
        }
    }
} 