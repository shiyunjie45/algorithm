package com.sky.algorithmleetcode;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 编写一个
函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 示例 1: 输入: nums = [2,5,6,0,0,1,2], tar
get = 0 输出: true  示例 2: 输入: nums = [2,5,6,0,0,1,2], target = 3 输出: false 进阶:  	这
是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。 	这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
*/

 class L81Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[right] == nums[mid]) {
                right--;
                continue;
            }
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
} 