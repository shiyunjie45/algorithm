package com.sky.algorithmleetcode;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 求在该柱状图中，能够勾勒出来的矩形的最大面积。    以上是柱状图的示
例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。    图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。   示例: 输
入: [2,1,5,6,2,3] 输出: 10
*/

 java.util.Stack;

public class L84Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int height = heights[top];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int height = heights[top];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
} 