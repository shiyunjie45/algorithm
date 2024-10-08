package com.sky.algorithmleetcode;

/*
给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。 注意： 数组大小可能非常大。 使用太多额外空间的解决
方案将不会通过测试。 示例:  int[] nums = new int[] {1,2,3,3,3}; Solution solution = new Solu
tion(nums); // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。 solution.pick(3); // pick(
1) 应该返回 0。因为只有nums[0]等于1。 solution.pick(1);
*/

 java.util.Random;

public class L398Solution {
    private int[] nums;
    private Random random;

    public L398Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int count = 0; // 统计target出现的次数
        int index = -1; // 记录最后一次出现的位置（即随机返回的位置）
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // 根据概率选择是否更新最后一次出现的位置
                if (random.nextInt(count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
} 