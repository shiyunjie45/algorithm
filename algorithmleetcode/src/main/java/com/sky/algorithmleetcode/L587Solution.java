package com.sky.algorithmleetcode;

/*
在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好
栅栏。你需要找到正好位于栅栏边界上的树的坐标。     示例 1:  输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]] 输出:
 [[1,1],[2,0],[4,2],[3,3],[2,4]] 解释:    示例 2:  输入: [[1,2],[2,2],[4,2]] 输出: [[1,2
],[2,2],[4,2]] 解释:  即使树都在一条直线上，你也需要先用绳子包围它们。      注意:   	所有的树应当被围在一起。你不能剪断绳子来包围树
或者把树分成一组以上。 	输入的整数在 0 到 100 之间。 	花园至少有一棵树。 	所有树的坐标都是不同的。 	输入的点没有顺序。输出顺序也没有要求。
*/

 java.util.*;

public class L587Solution {

    public static int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0])
                - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public static int distance(int[] p, int[] q) {
        return (q[1] - p[1]) * (q[1] - p[1])
                + (q[0] - p[0]) * (q[0] - p[0]);
    }

    public static int[][] outerTrees(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return points;
        }

        List<int[]> hull = new ArrayList<>();

        int leftmostPoint = 0;
        for (int i = 1; i < n; i++) {
            if (points[i][0] < points[leftmostPoint][0]) {
                leftmostPoint = i;
            }
        }

        int pointOnHull = leftmostPoint;
        do {
            hull.add(points[pointOnHull]);
            int endpoint = 0;
            for (int i = 0; i < n; i++) {
                if (i == pointOnHull) {
                    continue;
                }
                int res = orientation(points[pointOnHull], points[i], points[endpoint]);
                if (endpoint == pointOnHull || res < 0
                        || (res == 0 && distance(points[pointOnHull], points[i]) > distance(points[pointOnHull], points[endpoint]))) {
                    endpoint = i;
                }
            }
            pointOnHull = endpoint;
        } while (pointOnHull != leftmostPoint);

        int[][] res = new int[hull.size()][2];
        for (int i = 0; i < hull.size(); i++) {
            res[i] = hull.get(i);
        }
        return res;
    }
} 