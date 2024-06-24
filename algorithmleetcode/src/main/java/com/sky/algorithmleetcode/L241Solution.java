package com.sky.algorithmleetcode;

/*
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 示例 1: 输入: "2-1-1" 输出: [0, 2] 解释: ((2-1)-1) = 0 (2-(1-1)) = 2 示例 2: 输入: "2*3-4*5
" 输出: [-34, -14, -10, -10, 10] 解释: (2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14 ((2*(
3-4))*5) = -10 (2*((3-4)*5)) = -10 (((2*3)-4)*5) = 10
*/

import java.util.ArrayList;
import java.util.List;

public class L241Solution {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        int len = input.length();
        // 遍历输入字符串，逐个判断是否是数字或运算符号
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 如果是运算符号，将表达式分成左右两部分，分别计算
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int x : left) {
                    for (int y : right) {
                        // 根据不同的运算符号，计算不同的结果
                        if (c == '+') {
                            result.add(x + y);
                        } else if (c == '-') {
                            result.add(x - y);
                        } else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        // 如果整个输入字符串没有运算符号，说明是一个数字，直接添加到结果集合中
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }

    public static void main(String[] args) {
        L241Solution solution = new L241Solution();
        String input1 = "2-1-1";
        String input2 = "2*3-4*5";
        System.out.println(solution.diffWaysToCompute(input1));
        System.out.println(solution.diffWaysToCompute(input2));
    }
} 