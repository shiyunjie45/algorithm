package com.sky.algorithmleetcode;

/*
给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需
要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。 示例 1:  输入:"-1/2+1/2" 输出: "0/1"   示例 2:
  输入:"-1/2+1/2+1/3" 输出: "1/3"  示例 3:  输入:"1/3-1/2" 输出: "-1/6"  示例 4:  输入:"5/3+1/
3" 输出: "2/1"  说明:  	输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。  	输入和输出分数格式均为 ±
分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 	输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果
分母是1，意味着这个分数实际上是一个整数。 	输入的分数个数范围是 [1,10]。 	最终结果的分子与分母保证是 32 位整数范围内的有效整数。
*/

 java.util.ArrayList;
import java.util.List;

public class L592Solution {

    public String fractionAddition(String expression) {
        List<Integer[]> fractions = parseExpression(expression);
        Integer[] result = fractions.get(0);
        for (int i = 1; i < fractions.size(); i++) {
            result = addFractions(result, fractions.get(i));
        }
        return simplifyFraction(result);
    }

    // 解析表达式，返回分数列表
    private List<Integer[]> parseExpression(String expression) {
        List<Integer[]> fractions = new ArrayList<>();
        int start = 0, end = 0;
        while (end < expression.length()) {
            char ch = expression.charAt(end);
            if (ch == '+' || ch == '-') {
                fractions.add(parseFraction(expression.substring(start, end)));
                start = end;
            }
            end++;
        }
        fractions.add(parseFraction(expression.substring(start)));
        return fractions;
    }

    // 解析分数
    private Integer[] parseFraction(String fraction) {
        int index = fraction.indexOf("/");
        int numerator = Integer.parseInt(fraction.substring(0, index));
        int denominator = Integer.parseInt(fraction.substring(index + 1));
        return new Integer[]{numerator, denominator};
    }

    // 实现分数加法
    private Integer[] addFractions(Integer[] f1, Integer[] f2) {
        int numerator = f1[0] * f2[1] + f2[0] * f1[1];
        int denominator = f1[1] * f2[1];
        return new Integer[]{numerator, denominator};
    }

    // 化简分数
    private String simplifyFraction(Integer[] fraction) {
        int gcd = gcd(fraction[0], fraction[1]);
        int numerator = fraction[0] / gcd;
        int denominator = fraction[1] / gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        return numerator + "/" + denominator;
    }

    // 计算最大公约数
    private int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

} 