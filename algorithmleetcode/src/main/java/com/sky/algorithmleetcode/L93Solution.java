package com.sky.algorithmleetcode;

/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '
.' 分隔。   示例: 输入: "25525511135" 输出: ["255.255.11.135", "255.255.111.35"]
*/

 java.util.ArrayList;
import java.util.List;

public class L93Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    //回溯方法
    private void backtrack(String s, int start, List<String> temp, List<String> res) {
        // 如果已经有四个字符串了，并且已经匹配完整个串了，则加入到结果中
        if (temp.size() == 4 && start == s.length()) {
            res.add(String.join(".", temp));
            return;
        }
        // 如果已经有四个字符串了，但是没有匹配完整个串，则其不是一个有效的IP地址
        if (temp.size() == 4 && start < s.length()) {
            return;
        }
        for (int i = start; i < s.length() && i <= start + 2; i++) {
            String sub = s.substring(start, i + 1);
            if (isValid(sub)) {
                temp.add(sub);
                backtrack(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // 判断是否是合法的IP段
    private boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
} 