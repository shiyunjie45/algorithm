package com.sky.algorithmleetcode;

/*
给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 示例 1:  输入: [2,2,3,4] 输出: 3 解释: 有效的组合是: 
2,3,4 (使用第一个 2) 2,3,4 (使用第二个 2) 2,2,3  注意:  	数组长度不超过1000。 	数组里整数的范围为 [0, 1000]。
*/

 class L611Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int k = j + 1;
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }
} 