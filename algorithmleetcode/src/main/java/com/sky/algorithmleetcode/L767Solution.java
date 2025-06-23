package com.sky.algorithmleetcode;

/*
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 若可行，输出任意可行的结果。若不可行，返回空字符串。 示例 1:  输入: S = "a
ab" 输出: "aba"  示例 2:  输入: S = "aaab" 输出: ""  注意:  	S 只包含小写字母并且长度在[1, 500]区间内。
*/

 java.util.*;

public class L767Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        if (n < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (n + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> counts[c2 - 'a'] - counts[c1 - 'a']);
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                queue.offer((char) ('a' + i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            int index1 = c1 - 'a';
            int index2 = c2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(c1);
            }
            if (counts[index2] > 0) {
                queue.offer(c2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
} 