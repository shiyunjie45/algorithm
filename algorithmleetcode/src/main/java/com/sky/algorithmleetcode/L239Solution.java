package com.sky.algorithmleetcode;

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 返回
滑动窗口中的最大值。   进阶： 你能在线性时间复杂度内解决此题吗？   示例: 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7] 解释:   滑动窗口的位置        最大值 ---------------        ----- [1 3 -1
] -3 5 3 6 7    3 1 [3 -1 -3] 5 3 6 7    3 1 3 [-1 -3 5] 3 6 7    5 1 3 -1 [-3 5
 3] 6 7    5 1 3 -1 -3 [5 3 6] 7    6 1 3 -1 -3 5 [3 6 7]   7   提示：  	1 	-10^4  
	1
*/

import java.util.Deque;
import java.util.LinkedList;

public class L239Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int i = 0;
        Deque<Integer> queue = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            while (!queue.isEmpty() && queue.peek() < j - k + 1) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[j] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.offer(j);

            if (j >= k - 1) {
                result[i++] = nums[queue.peek()];
            }
        }

        return result;
    }
} 