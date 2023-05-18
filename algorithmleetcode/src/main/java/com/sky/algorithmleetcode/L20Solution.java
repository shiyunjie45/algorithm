package com.sky.algorithmleetcode;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 有效字符串需满足：  	左括号必须用相同类型的右括号闭合。 	左
括号必须以正确的顺序闭合。  注意空字符串可被认为是有效字符串。 示例 1: 输入: "()" 输出: true  示例 2: 输入: "()[]{}" 输出:
 true  示例 3: 输入: "(]" 输出: false  示例 4: 输入: "([)]" 输出: false  示例 5: 输入: "{[]}" 输出
: true
*/

import java.util.Stack;

public class L20Solution {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

} 