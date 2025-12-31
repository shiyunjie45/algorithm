package com.sky.algorithmleetcode;

/*
给定一个整数数组 A，坡是元组 (i, j)，其中  i  且 A[i] 。这样的坡的宽度为 j - i。 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
   示例 1： 输入：[6,0,8,2,1,5] 输出：4 解释： 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
  示例 2： 输入：[9,8,1,0,1,9,4,0,4,1] 输出：7 解释： 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[
9] = 1.    提示：  	2 	0
*/

 L962Solution {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n; ++i) {
            if (top == 0 || A[stack[top - 1]] > A[i]) {
                stack[top++] = i;
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            while (top > 0 && A[stack[top - 1]] <= A[i]) {
                ans = Math.max(ans, i - stack[top - 1]);
                --top;
            }
        }
        return ans;
    }
} 