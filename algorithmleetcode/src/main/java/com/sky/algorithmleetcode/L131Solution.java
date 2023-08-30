package com.sky.algorithmleetcode;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 返回 s 所有可能的分割方案。 示例: 输入: "aab" 输出: [  ["aa","b"
],  ["a","a","b"] ]
*/

import java.util.ArrayList;
import java.util.List;

public class L131Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, int start, List<String> temp, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                dfs(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
} 