package com.sky.algorithmleetcode;

/*
和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。 示例 1:  输
入: [1,3,2,2,5,2,3,7] 输出: 5 原因: 最长的和谐数组是：[3,2,2,2,3].  说明: 输入的数组长度最大不超过20,000.
*/

 java.util.HashMap;

public class L594Solution {
    public int findLHS(int[] nums) {
        // 用哈希表存储每个数的出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        // 遍历哈希表，寻找相差为 1 的键值对，并计算和谐子序列的长度
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                max = Math.max(max, map.get(num) + map.get(num + 1));
            }
        }

        return max;
    }
} 