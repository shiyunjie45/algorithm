package com.sky.algorithmleetcode;

/*
删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。 说明: 输入可能包含了除 ( 和 ) 以外的字符。 示例 1: 输入: "()())()" 
输出: ["()()()", "(())()"]  示例 2: 输入: "(a)())()" 输出: ["(a)()()", "(a())()"]  示例 3:
 输入: ")(" 输出: [""]
*/

import java.util.ArrayList;
import java.util.List;

class L301Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int left = 0, right = 0; // 记录需要删除的左右括号数
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        dfs(s, 0, left, right, result);
        return result;
    }

    private void dfs(String s, int start, int left, int right, List<String> result) {
        if (left == 0 && right == 0 && isValid(s)) {
            result.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 去重
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (left > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, result);
            }
            if (right > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, result);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
} 