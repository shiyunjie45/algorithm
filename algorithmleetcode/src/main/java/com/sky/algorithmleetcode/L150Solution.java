package com.sky.algorithmleetcode;

/*
根据逆波兰表示法，求表达式的值。 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 说明：  	整数除法只保留整数
部分。 	给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。  示例 1： 输入: ["2", "1", "+", "3"
, "*"] 输出: 9 解释: ((2 + 1) * 3) = 9  示例 2： 输入: ["4", "13", "5", "/", "+"] 输出: 6 解
释: (4 + (13 / 5)) = 6  示例 3： 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*"
, "17", "+", "5", "+"] 输出: 22 解释:  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((1
0 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17)
 + 5 = (0 + 17) + 5 = 17 + 5 = 22
*/

import java.util.Stack;

public class L150Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            } else if(token.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            } else if(token.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);
            } else if(token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }
        return stack.pop();
    }
} 