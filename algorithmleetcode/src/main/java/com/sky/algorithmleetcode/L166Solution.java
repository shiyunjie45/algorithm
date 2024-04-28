package com.sky.algorithmleetcode;

/*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。 如果小数部分为循环小数，则将循环的部分括在括号内。
 示例 1: 输入: numerator = 1, denominator = 2 输出: "0.5"  示例 2: 输入: numerator = 2, de
nominator = 1 输出: "2" 示例 3: 输入: numerator = 2, denominator = 3 输出: "0.(6)"
*/

import java.util.HashMap;

public class L166Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";  // 分子为0时返回0

        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {  // 判断正负号
            res.append("-");
        }

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        res.append(num / den);  // 整数部分

        long rem = num % den;
        if (rem == 0) {  // 余数为0，直接返回结果
            return res.toString();
        }

        res.append(".");  // 加小数点

        HashMap<Long, Integer> map = new HashMap<>();  // 记录余数以及余数出现的位置
        while (rem != 0) {
            if (map.containsKey(rem)) {  // 余数出现过，说明出现了循环节
                int index = map.get(rem);
                res.insert(index, "(");  // 在循环节开始的位置添加左括号
                res.append(")");  // 在最后加上右括号
                break;
            }
            map.put(rem, res.length());  // 记录余数以及当前小数部分字符串长度
            rem *= 10;  // 余数乘10
            res.append(rem / den);  // 小数部分
            rem %= den;  // 重新计算余数
        }

        return res.toString();
    }
} 