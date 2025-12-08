package com.sky.algorithmleetcode;

/*
给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。 如果没有任何矩形，就返回 0。   示例 1： 输入：[
[1,1],[1,3],[3,1],[3,3],[2,2]] 输出：4  示例 2： 输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,
3]] 输出：2    提示：  	1 	0 	0 	所有的点都是不同的。
*/

 java.util.*;

public class L939Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> pointMap = new HashMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            if (!pointMap.containsKey(x)) {
                pointMap.put(x, new HashSet<>());
            }
            pointMap.get(x).add(y);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    if (pointMap.get(x1).contains(y2) && pointMap.get(x2).contains(y1)) {
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
} 