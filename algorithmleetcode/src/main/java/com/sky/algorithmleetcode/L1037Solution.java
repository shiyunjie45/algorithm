package com.sky.algorithmleetcode;

/*
回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。   示例 1： 输入：[[1,1],[2,
3],[3,2]] 输出：true  示例 2： 输入：[[1,1],[2,2],[3,3]] 输出：false   提示：  	points.length =
= 3 	points[i].length == 2 	0
*/

 class L1037Solution {
    public boolean isBoomerang(int[][] points) {
        // 通过斜率公式判断三个点是否在同一直线上
        // 如果不在同一直线上，则判断斜率是否相等，如果不相等则可以构成回旋镖
        // 斜率公式: k = (y2 - y1)/(x2 - x1)
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];
        return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
    }
} 