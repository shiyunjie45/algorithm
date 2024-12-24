package com.sky.algorithmleetcode;

/*
给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "
Silver Medal", "Bronze Medal"）。 (注：分数越高的选手，排名越靠前。) 示例 1:  输入: [5, 4, 3, 2, 1] 输出
: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"] 解释: 前三名运动员的成绩为前三高的，因此
将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal"). 余下的两名运
动员，我们只需要通过他们的成绩计算将其相对名次即可。 提示:  	N 是一个正整数并且不会超过 10000。 	所有运动员的成绩都不相同。
*/

 java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L506Solution {
    public String[] findRelativeRanks(int[] nums) {
        //将数组拷贝一份
        int[] copy = Arrays.copyOf(nums, nums.length);
        //对数组进行排序
        Arrays.sort(copy);
        //使用HashMap存储数字和排名的对应关系
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i], copy.length - i);
        }
        String[] result = new String[nums.length];
        //遍历原数组，根据HashMap的映射关系将数字转化为排名
        for (int i = 0; i < nums.length; i++) {
            int rank = map.get(nums[i]);
            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(rank);
            }
        }
        return result;
    }
} 