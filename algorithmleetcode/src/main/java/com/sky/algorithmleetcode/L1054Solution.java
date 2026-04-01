package com.sky.algorithmleetcode;

/*
在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该
要求的答案，此题保证存在答案。   示例 1： 输入：[1,1,1,2,2,2] 输出：[2,1,2,1,2,1]  示例 2： 输入：[1,1,1,1,2,2
,3,3] 输出：[1,3,1,3,2,1,2,1]   提示：  	1 	1
*/

 java.util.Arrays;

public class L1054Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] ans = new int[n];
        int index = 0; // 当前要填充的位置

        // 统计每个条形码出现的次数
        int[] count = new int[10001];
        for (int code : barcodes) {
            count[code]++;
        }

        // 存储条形码以及出现的次数
        Node[] nodes = new Node[10001];
        for (int i = 1; i <= 10000; i++) {
            nodes[i] = new Node(i, count[i]);
        }

        // 贪心算法，优先填充出现次数最多的条形码
        Arrays.sort(nodes, 1, 10001); // 对结点按出现次数从小到大排序
        for (int i = 1; i <= 10000 && index < n; i++) {
            Node node = nodes[i];
            while (node.count-- > 0 && index < n) {
                ans[index] = node.code;
                index += 2; // 填充偶数位置
            }
        }

        // 填充奇数位置
        for (int i = 0; i <= 10000 && index < n; i++) {
            Node node = nodes[i];
            while (node.count-- > 0 && index < n) {
                ans[index] = node.code;
                index += 2; // 填充奇数位置
            }
        }

        return ans;
    }

    static class Node implements Comparable<Node> {
        int code;
        int count;

        public Node(int code, int count) {
            this.code = code;
            this.count = count;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.count, node.count);
        }
    }
} 