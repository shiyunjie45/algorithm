package com.sky.algorithmleetcode;

/*
给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 注意:  	num 的长度小于 10002 且 ≥ k。 	num 不
会包含任何前导零。  示例 1 :  输入: num = "1432219", k = 3 输出: "1219" 解释: 移除掉三个数字 4, 3, 和 2 形
成一个新的最小的数字 1219。  示例 2 :  输入: num = "10200", k = 1 输出: "200" 解释: 移掉首位的 1 剩下的数字为 
200. 注意输出不能有任何前导零。  示例 3 :  输入: num = "10", k = 2 输出: "0" 解释: 从原数字移除所有的数字，剩余为空就是
0。
*/

 java.util.Deque;
import java.util.LinkedList;

public class L402Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        // 特判：当要删除的数字个数 k 等于 num 的长度时，直接返回 "0"
        if (k == n) {
            return "0";
        }
        // 维护递增栈
        Deque<Character> deque = new LinkedList<>();
        int i = 0;
        while (i < n) {
            char c = num.charAt(i);
            // 如果当前数字小于栈顶元素，则将栈顶元素出栈
            while (k > 0 && !deque.isEmpty() && c < deque.peekLast()) {
                deque.removeLast();
                k--;
            }
            deque.offerLast(c);
            i++;
        }
        // 如果还有剩余的数字要删除，则继续从栈顶中删除
        while (k > 0) {
            deque.removeLast();
            k--;
        }
        // 构造结果字符串
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        // 注意删去前导零
        int j = 0;
        while (j < sb.length() && sb.charAt(j) == '0') {
            j++;
        }
        String res = sb.substring(j);
        // 如果结果字符串为空，返回 "0"
        if (res.length() == 0) {
            return "0";
        } else {
            return res;
        }
    }
} 