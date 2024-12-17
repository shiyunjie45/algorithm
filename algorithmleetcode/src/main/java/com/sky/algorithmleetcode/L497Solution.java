package com.sky.algorithmleetcode;

/*
给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。 提示：  	整数点是具有整数坐标的点。 	矩形周边上
的点包含在矩形覆盖的空间中。 	第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是
右上角的整数坐标。 	每个矩形的长度和宽度不超过 2000。 	1 	pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。 	pick 最多被调用
10000次。    示例 1：  输入: ["Solution","pick","pick","pick"] [[[[1,1,5,5]]],[],[],[]]
 输出: [null,[4,1],[4,1],[3,3]]  示例 2：  输入: ["Solution","pick","pick","pick","pick
","pick"] [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]] 输出: [null,[-1,-2],[2,0],[
-2,-1],[3,0],[-2,-2]]   输入语法的说明： 输入是两个列表：调用的子例程及其参数。Solution 的构造函数有一个参数，即矩形数组 re
cts。pick 没有参数。参数总是用列表包装的，即使没有也是如此。
*/

 java.util.Random;

public class L497Solution {

    int[][] rects;
    int[] prefixSum;
    Random random;

    public L497Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSum = new int[rects.length];
        this.random = new Random();

        int area = 0;
        for (int i = 0; i < rects.length; i++) {
            int width = rects[i][2] - rects[i][0] + 1;
            int height = rects[i][3] - rects[i][1] + 1;
            area += width * height;
            prefixSum[i] = area;
        }
    }

    public int[] pick() {
        int target = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int index = binarySearch(target);
        int[] rect = rects[index];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int base = prefixSum[index] - width * height;
        int offset = target - base - 1;
        int x = rect[0] + offset % width;
        int y = rect[1] + offset / width;
        return new int[]{x, y};
    }

    private int binarySearch(int target) {
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
} 