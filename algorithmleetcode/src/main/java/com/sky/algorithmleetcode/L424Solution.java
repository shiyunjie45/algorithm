package com.sky.algorithmleetcode;

/*
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。 注
意: 字符串长度 和 k 不会超过 104。 示例 1: 输入: s = "ABAB", k = 2 输出: 4 解释: 用两个'A'替换为两个'B',反之亦然
。  示例 2: 输入: s = "AABABBA", k = 1 输出: 4 解释: 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。 子串 
"BBBB" 有最长重复字母, 答案为 4。
*/

 java.util.*;

public class L424Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // 记录每个字母出现的次数
        int left = 0;  // 滑动窗口的左边界
        int maxCount = 0;  // 当前窗口中出现最多的字母的个数
        int maxLength = 0;  // 最长重复字母的长度

        for (int right = 0; right < s.length(); right++) { // 右边界不停往右滑动
            count[s.charAt(right) - 'A']++;  // 记录右边界对应的字母出现次数
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);  // 更新当前窗口中出现最多的字母的个数
            int replaceCount = right - left + 1 - maxCount;  // 需要替换的字符个数
            if (replaceCount > k) {  // 需要替换的字符个数超过了k个
                count[s.charAt(left) - 'A']--;  // 左边界右移，对应字母出现次数要减1
                left++;  // 左边界右移
            } else {  // 需要替换的字符个数不超过k个
                maxLength = Math.max(maxLength, right - left + 1);  // 更新最长重复字母的长度
            }
        }
        return maxLength;
    }
} 