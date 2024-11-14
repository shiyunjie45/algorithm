package com.sky.algorithmleetcode;

/*
给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因
为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。 确定 nums 中是否存在循环（或周期）。循环必须在
相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。   示例
 1： 输入：[2,-1,1,2,2] 输出：true 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。  示例 2： 输入：[-
1,2] 输出：false 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。  示
例 3: 输入：[-2,1,-1,-2,-2] 输出：false 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为按索引 1 -> 
2 的运动是向前的运动，而按索引 2 -> 1 的运动是向后的运动。一个循环中的所有运动都必须沿着同一方向进行。   提示：  	-1000 ≤ nums[i]
 ≤ 1000 	nums[i] ≠ 0 	0 ≤ nums.length ≤ 5000    进阶： 你能写出时间时间复杂度为 O(n) 和额外空间复杂度为 
O(1) 的算法吗？
*/

 class L457Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果当前位置已经遍历过，跳过
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = next(i, nums);
            // 当前方向与前进方向相同时，继续遍历
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(fast, nums)] > 0) {
                if (slow == fast) {
                    // 如果有大于1的循环，返回true
                    if (slow != next(slow, nums)) {
                        return true;
                    }
                    break;
                }
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
            }
            int j = i;
            while (nums[j] * nums[next(j, nums)] > 0) {
                int temp = j;
                j = next(j, nums);
                nums[temp] = 0;
            }
        }
        return false;
    }

    private int next(int i, int[] nums) {
        int n = nums.length;
        // 需要使用%n，因为环形数组
        // %n + n保证返回值为正数
        return ((i + nums[i]) % n + n) % n;
    }
} 