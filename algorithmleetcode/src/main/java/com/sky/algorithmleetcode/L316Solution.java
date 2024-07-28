package com.sky.algorithmleetcode;

/*
给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。   示例 1
: 输入: "bcabc" 输出: "abc"  示例 2: 输入: "cbacdcbc" 输出: "acdb"   注意：该题与 1081 https://l
eetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
*/

import java.util.*;

public class L316Solution {
    public String removeDuplicateLetters(String s) {
        // 记录每个字符出现的最后一个位置
        Map<Character, Integer> lastOccur = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccur.put(s.charAt(i), i);
        }
        // 栈中保存的是字典序最小的字符序列
        Stack<Character> stack = new Stack<>();
        // 记录已经出现在栈中的字符以及数量
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符已经出现在栈中，跳过
            if (used.contains(c)) {
                continue;
            }
            // 如果当前字符比栈顶字符小且栈顶字符在后面还会出现，则弹出栈顶字符
            while (!stack.isEmpty() && c < stack.peek() && lastOccur.get(stack.peek()) > i) {
                used.remove(stack.pop());
            }
            stack.push(c);
            used.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
} 