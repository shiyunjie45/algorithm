package com.sky.algorithmleetcode;

/*
你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。 我们定义如果 b-a  或者在 b-a == d-c 时
 a ，则区间 [a,b] 比 [c,d] 小。 示例 1:  输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]] 
输出: [20,24] 解释: 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。 列表 2：[0, 9, 12, 20]，2
0 在区间 [20,24] 中。 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。  注意:  	给定的列表可能包含重复元素，所以在
这里升序表示 >= 。 	1 k 	-105 元素的值 5 	对于使用Java的用户，请注意传入类型已修改为List>。重置代码模板后可以看到这项改动。
*/

 java.util.*;

public class L632Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = nums.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i).get(0);
            max = Math.max(max, num);
            pq.offer(new int[]{num, 0, i});
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == n) {
            int[] min = pq.poll();
            int minVal = min[0];
            int i = min[2];
            if (max - minVal < range) {
                range = max - minVal;
                start = minVal;
                end = max;
            }
            int j = min[1] + 1;
            if (j < nums.get(i).size()) {
                int next = nums.get(i).get(j);
                max = Math.max(max, next);
                pq.offer(new int[]{next, j, i});
            }
        }
        return new int[]{start, end};
    }
} 