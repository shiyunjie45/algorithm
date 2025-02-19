package com.sky.algorithmleetcode;

/*
给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。 一个点的坐标（x，y）由一个有两个整数的整数数组表示。 示例:  输入: p1 = [0,0], p
2 = [1,1], p3 = [1,0], p4 = [0,1] 输出: True    注意:  	所有输入整数都在 [-10000，10000] 范围内。
 	一个有效的正方形有四个等长的正长和四个等角（90度角）。 	输入点没有顺序。
*/

 java.util.*;

class L593Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] points = new int[][]{p1, p2, p3, p4};
        for (int[] point : points) {
            map.put(point[0] * 10000 + point[1], map.getOrDefault(point[0] * 10000 + point[1], 0) + 1);
        }
        if (map.size() != 4) {
            return false;
        }
        int[] xys = new int[8];
        int i = 0;
        for (int key : map.keySet()) {
            int x = key / 10000;
            int y = key % 10000;
            xys[i++] = x;
            xys[i++] = y;
        }
        Arrays.sort(xys);
        int len = xys[7] - xys[0];
        for (int j = 1; j < 4; j++) {
            if (xys[j * 2 + 1] != xys[(j - 1) * 2 + 1] || xys[j * 2] - xys[(j - 1) * 2 + 2] != len) {
                return false;
            }
        }
        return xys[3] - xys[2] == xys[7] - xys[6] && xys[1] - xys[0] == xys[5] - xys[4] && len * len * 2 == (xys[3] - xys[2]) * (xys[3] - xys[2]) + (xys[1] - xys[0]) * (xys[1] - xys[0]);
    }
} 