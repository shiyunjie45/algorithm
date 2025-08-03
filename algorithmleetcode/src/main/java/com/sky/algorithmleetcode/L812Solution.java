package com.sky.algorithmleetcode;

/*
给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。  示例: 输入: points = [[0,0],[0,1],[1,0],[0,
2],[2,0]] 输出: 2 解释: 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。   注意:  	3 . 	不存在重复的点。 	 -50 . 	
结果误差值在 10^-6 以内都认为是正确答案。
*/

 class L812Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for (int i = 0; i < points.length-2; i++) {
            for (int j = i+1; j < points.length-1; j++) {
                for (int k = j+1; k < points.length; k++) {
                    double area = area(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private double area(int[] A, int[] B, int[] C) {
        return 0.5 * Math.abs(A[0]*B[1]+B[0]*C[1]+C[0]*A[1]-B[0]*A[1]-C[0]*B[1]-A[0]*C[1]);
    }
} 