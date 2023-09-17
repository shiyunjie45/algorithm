package com.sky.algorithmleetcode;

/*
给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 示例 1: 输入: [[1,1],[2,2],[3,3]] 输出: 3 解释: ^ | 
|        o |     o |  o   +-------------> 0  1  2  3 4  示例 2: 输入: [[1,1],[3,2],[
5,3],[4,1],[2,3],[1,4]] 输出: 4 解释: ^ | | o |     o     o |       o |  o     o +--
-----------------> 0  1  2  3  4  5  6
*/

import java.util.HashMap;
import java.util.Map;

public class L149Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int samePoint = 1;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0 && dy == 0) {
                    samePoint++;
                    continue;
                }
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String key = dy + "/" + dx;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            res = Math.max(res, samePoint);
            for (Integer count : map.values()) {
                res = Math.max(res, count + samePoint);
            }
        }
        return res;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
} 