package com.sky.algorithmleetcode;

/*
给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 
min(ai, bi) 总和最大。 示例 1:  输入: [1,4,3,2] 输出: 4 解释: n 等于 2, 最大总和为 4 = min(1, 2) + m
in(3, 4).  提示:  	n 是正整数,范围在 [1, 10000]. 	数组中的元素范围在 [-10000, 10000].
*/

 class L561Solution {
    /**
     * 通过排序，将每个数对的最小值相加即可
     * 时间复杂度：O(nlogn)，空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
} 