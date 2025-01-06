package com.sky.algorithmleetcode;

/*
给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。 子序列可以通过删去字符
串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。 输入将是一个字符串列表，输出是最长特殊序列的长度。如
果最长特殊序列不存在，返回 -1 。   示例： 输入: "aba", "cdc", "eae" 输出: 3    提示：  	所有给定的字符串长度不会超过 1
0 。 	给定字符串列表的长度将在 [2, 50 ] 之间。
*/

 class L522Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length()); // 对字符串数组按照长度进行从大到小排序
        for (int i = 0; i < strs.length; i++) {
            if (i == 0 || !strs[i].equals(strs[i - 1])) { // 当前字符串不等于前一个字符串时
                boolean isSubsequence = false;
                for (int j = 0; j < i; j++) { // 检查当前字符串是否是前面某个字符串的子序列
                    if (isSubsequence(strs[j], strs[i])) {
                        isSubsequence = true;
                        break;
                    }
                }
                if (!isSubsequence) { // 如果当前字符串不是任何前面字符串的子序列，则返回当前字符串长度
                    return strs[i].length();
                }
            }
        }
        return -1; // 如果没有特殊子序列，则返回 -1
    }

    // 判断字符串 a 是否是字符串 b 的子序列
    private boolean isSubsequence(String a, String b) {
        int i = 0;
        for (char c : b.toCharArray()) {
            if (i < a.length() && c == a.charAt(i)) {
                i++;
            }
        }
        return i == a.length();
    }
} 