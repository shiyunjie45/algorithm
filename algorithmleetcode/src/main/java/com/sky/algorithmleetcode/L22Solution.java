package com.sky.algorithmleetcode;

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。   示例： 输入：n = 3 输出：[    "((()))",
    "(()())",    "(())()",    "()(())",    "()()()"   ]
*/

import java.util.ArrayList;
import java.util.List;

public class L22Solution {
    
    // 声明结果列表
    private List<String> resultList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // 递归生成括号
        generate(0, 0, n, "");
        return resultList;
    }

    /**
     * 递归生成括号
     * @param leftCount 左括号已使用的数量
     * @param rightCount 右括号已使用的数量
     * @param n 括号对数
     * @param str 当前括号字符串
     */
    private void generate(int leftCount, int rightCount, int n, String str) {
        // 如果已用完括号对数，则将当前结果添加到结果列表中
        if (leftCount == n && rightCount == n) {
            resultList.add(str);
            return;
        }
        // 如果左括号数量小于n，执行左括号的添加操作
        if (leftCount < n) {
            generate(leftCount + 1, rightCount, n, str + "(");
        }
        // 如果右括号数量小于左括号数量，执行右括号的添加操作
        if (rightCount < leftCount) {
            generate(leftCount, rightCount + 1, n, str + ")");
        }
    }
} 