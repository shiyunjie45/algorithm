package com.sky.algorithmleetcode;

/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 你找到的子数组应是最短的，请输出它的长度。 示例 1
:  输入: [2, 6, 4, 8, 10, 9, 15] 输出: 5 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为
升序排序。  说明 :  	输入的数组长度范围在 [1, 10,000]。 	输入的数组可能包含重复元素 ，所以升序的意思是
*/

 class L581Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int start = n, end = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                start = Math.min(start, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }
        return end > start ? end - start + 1 : 0;
    }
} 