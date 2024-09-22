package com.sky.algorithmleetcode;

/*
给定一个经过编码的字符串，返回它解码后的字符串。 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复
 k 次。注意 k 保证为正整数。 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 此外，你可以认为原始数据不包
含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 示例:  s = "3[a]2[bc]", 返回 "aaabcbc". 
s = "3[a2[c]]", 返回 "accaccacc". s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
*/

import java.util.Stack;

public class L394Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> numStack = new Stack<>(); //保存数字的栈
        Stack<StringBuilder> strStack = new Stack<>(); //保存字母的栈
        StringBuilder currentStr = new StringBuilder(); //当前处理的字母子串
        int repeatTimes = 0; //重复次数
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                repeatTimes = repeatTimes * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(repeatTimes);
                strStack.push(currentStr);
                repeatTimes = 0;
                currentStr = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tmpStr = currentStr;
                currentStr = strStack.pop(); //弹出上一个字母串
                int times = numStack.pop(); //弹出重复次数
                for (int i = 0; i < times; i++) {
                    currentStr.append(tmpStr); //在当前字母串后添加新的重复字母串
                }
            } else {
                currentStr.append(ch); //普通字母，添加到当前字母串中
            }
        }
        return currentStr.toString();
    }
} 