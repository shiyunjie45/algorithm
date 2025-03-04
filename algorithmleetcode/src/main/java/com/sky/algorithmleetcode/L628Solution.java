package com.sky.algorithmleetcode;

/*
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 示例 1:  输入: [1,2,3] 输出: 6  示例 2:  输入: [1,2,3,
4] 输出: 24  注意:  	给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 	输入的数组中任意三个数的乘积不会
超出32位有符号整数的范围。
*/

 class L628Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums); // 先排序
        int len = nums.length;
        // 三个正数，排序后只需取末尾的三个数相乘
        int product1 = nums[len-1] * nums[len-2] * nums[len-3];
        // 两个负数一个正数，要考虑负数和正数的位置关系
        int product2 = nums[0] * nums[1] * nums[len-1];
        return Math.max(product1, product2);
    }
} 