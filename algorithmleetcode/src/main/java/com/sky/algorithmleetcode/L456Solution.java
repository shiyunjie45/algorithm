package com.sky.algorithmleetcode;

/*
给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i j k 时，ai k j。设计一个算法，当给定
有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。 注意：n 的值小于15000。 示例1:  输入: [1, 2, 3, 4] 输出: Fal
se 解释: 序列中不存在132模式的子序列。  示例 2:  输入: [3, 1, 4, 2] 输出: True 解释: 序列中有 1 个132模式的子序列：
 [1, 4, 2].  示例 3:  输入: [-1, 3, 2, 0] 输出: True 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2
], [-1, 3, 0] 和 [-1, 2, 0].
*/

 java.util.Stack;

public class L456Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int n = nums.length;

        int[] minArray = new int[n];
        minArray[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > minArray[i]) {
                while (!stack.empty() && stack.peek() <= minArray[i]) {
                    stack.pop();
                }

                if (!stack.empty() && stack.peek() < nums[i]) {
                    return true;
                }

                stack.push(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {3, 1, 4, 2};
        int[] nums3 = {-1, 3, 2, 0};

        L456Solution solution = new L456Solution();
        System.out.println(solution.find132pattern(nums1));
        System.out.println(solution.find132pattern(nums2));
        System.out.println(solution.find132pattern(nums3));
    }
} 