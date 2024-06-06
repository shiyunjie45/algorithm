package com.sky.algorithmleetcode;

/*
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。  示例: 输入: -3, 0, 3, 4, 0,
 -1, 9, 2 输出: 45 说明: 假设矩形面积不会超出 int 的范围。
*/

 class L223Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 计算两个矩形的面积
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        // 如果两个矩形不重叠，直接返回面积和
        if (E >= C || A >= G || F >= D || B >= H) {
            return area1 + area2;
        }
        
        // 如果两个矩形重叠，计算重叠部分的面积
        int overlapArea = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        
        // 总面积减去重叠部分的面积即为最终结果
        return area1 + area2 - overlapArea;
    }
} 