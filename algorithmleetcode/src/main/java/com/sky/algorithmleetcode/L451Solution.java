package com.sky.algorithmleetcode;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 示例 1:  输入: "tree" 输出: "eert" 解释: 'e'出现两次，'r'和't'都只
出现一次。 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。  示例 2:  输入: "cccaaa" 输出: "cccaaa" 
解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。 注意"cacaca"是不正确的，因为相同的字母必须放在一起。  示例 3:  输入: 
"Aabb" 输出: "bbAa" 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。 注意'A'和'a'被认为是两种不同的字符。
*/

 java.util.*;

public class L451Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        queue.addAll(freqMap.keySet());

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (int i = 0; i < freqMap.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
} 