package com.sky.algorithmleetcode;

/*
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。 如果数组元素个数小于 2，则返回 0。 示例 1: 输入: [3,6,9,1] 输出: 3 解
释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。 示例 2: 输入: [10] 输出: 0 解释:
 数组元素个数小于 2，因此返回 0。 说明:  	你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。 	请尝试在线性时间复杂度和空间复
杂度的条件下解决此问题。
*/

 class L164Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int gap = Math.max((max - min) / (n - 1), 1);
        int size = (max - min) / gap + 1;
        int[] bucketsMax = new int[size];
        int[] bucketsMin = new int[size];
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        for (int num : nums) {
            int index = (num - min) / gap;
            bucketsMax[index] = Math.max(bucketsMax[index], num);
            bucketsMin[index] = Math.min(bucketsMin[index], num);
        }
        int ans = 0;
        int preMax = max;
        for (int i = 0; i < size; i++) {
            if (bucketsMax[i] == Integer.MIN_VALUE && bucketsMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            ans = Math.max(ans, bucketsMin[i] - preMax);
            preMax = bucketsMax[i];
        }
        return ans;
    }
} 