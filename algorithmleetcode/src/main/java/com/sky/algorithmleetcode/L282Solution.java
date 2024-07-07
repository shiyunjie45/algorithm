package com.sky.algorithmleetcode;

/*
给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。 示例 1: 输入: n
um = "123", target = 6 输出: ["1+2+3", "1*2*3"]  示例 2: 输入: num = "232", target = 8
 输出: ["2*3+2", "2+3*2"] 示例 3: 输入: num = "105", target = 5 输出: ["1*0+5","10-5"] 示
例 4: 输入: num = "00", target = 0 输出: ["0+0", "0-0", "0*0"]  示例 5: 输入: num = "3456
237490", target = 9191 输出: []
*/

import java.util.*;

public class L282Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        help(res, num, target, "", 0L, 0L);
        return res;
    }

    private void help(List<String> res, String num, int target, String path, long cur, long pre) {
        if (num.length() == 0 && cur == target) {
            res.add(path);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String str = num.substring(0, i);
            if (str.length() > 1 && str.charAt(0) == '0') {
                return;
            }
            long val = Long.parseLong(str);
            String nextNum = num.substring(i);
            if (path.length() == 0) {
                help(res, nextNum, target, "" + val, val, val);
            } else {
                help(res, nextNum, target, path + "+" + val, cur + val, val);
                help(res, nextNum, target, path + "-" + val, cur - val, -val);
                help(res, nextNum, target, path + "*" + val, cur - pre + pre * val, pre * val);
            }
        }
    }
} 