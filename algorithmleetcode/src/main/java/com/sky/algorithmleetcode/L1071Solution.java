package com.sky.algorithmleetcode;

/*
对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 返回最长字符串 X，要求满足
 X 能除尽 str1 且 X 能除尽 str2。   示例 1： 输入：str1 = "ABCABC", str2 = "ABC" 输出："ABC"  示例 
2： 输入：str1 = "ABABAB", str2 = "ABAB" 输出："AB"  示例 3： 输入：str1 = "LEET", str2 = "CO
DE" 输出：""    提示：  	1 	1 	str1[i] 和 str2[i] 为大写英文字母
*/

 class L1071Solution {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) { // 判断两个字符串是否有公共前缀
            return "";
        }
        int gcd = gcd(str1.length(), str2.length()); // 求两个字符串长度的最大公约数
        return str1.substring(0, gcd);
    }

    // 求最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
} 