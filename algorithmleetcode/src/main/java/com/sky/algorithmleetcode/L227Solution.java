package com.sky.algorithmleetcode;

/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。 示例 
1: 输入: "3+2*2" 输出: 7  示例 2: 输入: " 3/2 " 输出: 1 示例 3: 输入: " 3+5 / 2 " 输出: 5  说明：  
	你可以假设所给定的表达式都是有效的。 	请不要使用内置的库函数 eval。
*/

import java.util.Stack;

public class L227Solution {

    public int calculate(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
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
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int n : stack) {
            result += n;
        }
        return result;
    }

} 