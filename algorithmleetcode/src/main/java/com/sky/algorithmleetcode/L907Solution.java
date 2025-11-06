package com.sky.algorithmleetcode;

/*
给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。 由于答案可能很大，因此返回答案模 10^9 + 7。   示例
： 输入：[3,1,2,4] 输出：17 解释： 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，
[3,1,2,4]。 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。   提示：  	1 	1
*/

 class L907Solution {
    public int sumSubarrayMins(int[] A) {
        int mod = 1000000007;
        int[] left = new int[A.length]; // 记录A[i]左边比它小的第一个元素的下标
        int[] right = new int[A.length]; // 记录A[i]右边比它小的第一个元素的下标
        Stack<Integer> stack = new Stack<>(); // 单调递增栈，栈中存放元素在A数组中的下标
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear(); // 清空栈，用于求right数组
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? A.length : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = (res + A[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return res;
    }
} 