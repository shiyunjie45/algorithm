package com.sky.algorithmleetcode;

/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 示例 1: 输入: [10,2] 输出: 210 示例 2: 输入: [3,30,34,5,9] 
输出: 9534330 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
*/

import java.util.Arrays;
import java.util.Comparator;

public class L179Solution {
    public String largestNumber(int[] nums) {
        // 转为 String 数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Comparator 排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1); // 降序
            }
        });

        // 连接结果
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        // 特殊情况，若全为0，则返回"0"
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
} 