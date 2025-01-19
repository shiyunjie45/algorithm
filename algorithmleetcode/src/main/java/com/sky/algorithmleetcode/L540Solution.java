package com.sky.algorithmleetcode;

/*
给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。 示例 1:  输入: [1,1,2,3,3,4,4,8,8] 输出: 
2  示例 2:  输入: [3,3,7,7,10,11,11] 输出: 10  注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行
。
*/

 class L540Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            //因为每个数都复制了，所以相邻的数对应的索引是奇偶性不同的
            //判断mid索引的数和前面一个数是否相等
            boolean isEven = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    //左边数组包括mid
                    right = mid - 2;
                } else {
                    //右边数组包括mid
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    //左边数组包括mid
                    left = mid + 2;
                } else {
                    //右边数组包括mid
                    right = mid - 1;
                }
            } else {
                //找到只出现一次的数
                return nums[mid];
            }
        }
        //找不到，返回-1
        return -1;
    }
} 