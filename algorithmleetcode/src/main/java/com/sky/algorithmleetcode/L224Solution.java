package com.sky.algorithmleetcode;

/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。 示例 1: 输
入: "1 + 1" 输出: 2  示例 2: 输入: " 2-1 + 2 " 输出: 3 示例 3: 输入: "(1+(4+5+2)-3)+(6+8)" 输出
: 23 说明：  	你可以假设所给定的表达式都是有效的。 	请不要使用内置的库函数 eval。
*/

import java.util.Stack;

public class L224Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
} 