package com.sky.algorithmleetcode;

/*
给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）
。 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。 示例:  输入: [[0,0],[1,0]
,[2,0]] 输出: 2 解释: 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
*/

 java.util.HashMap;
import java.util.Map;

public class L447Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int distance = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int count : map.values()) {
                result += count * (count - 1);
            }
        }
        return result;
    }
} 