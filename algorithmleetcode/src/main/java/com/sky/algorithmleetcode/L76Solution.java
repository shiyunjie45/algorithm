package com.sky.algorithmleetcode;

/*
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 示例： 输入: S = "ADOBECODEBANC", T = 
"ABC" 输出: "BANC" 说明：  	如果 S 中不存这样的子串，则返回空字符串 ""。 	如果 S 中存在这样的子串，我们保证它是唯一的答案。
*/

import java.util.HashMap;
import java.util.Map;

public class L76Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(); // 用于记录t中每个字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0; // 左右指针
        int count = map.size(); // 记录t中字符的种类数
        int minLen = Integer.MAX_VALUE; // 记录最短子串的长度
        int minStart = 0; // 记录最短子串的开始位置

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                // 当map中的任何一个字符计数器变为0时，总的种类数count减1
                if (map.get(c1) == 0) count--;
            }
            right++;

            // 如果count为0，表示t中所有字符都已经出现过，此时尝试将左指针右移
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char c2 = s.charAt(left);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    // 当map中的任何一个字符计数器大于0时，总的种类数count加1
                    if (map.get(c2) > 0) count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
} 