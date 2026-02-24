package com.sky.algorithmleetcode;

/*
给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串
，就返回 true，否则返回 false。   示例 1： 输入：S = "0110", N = 3 输出：true  示例 2： 输入：S = "0110",
 N = 4 输出：false    提示：  	1 	1
*/

 class L1016Solution {
    /**
     * 暴力枚举每个数，判断是否为S的子串，并用一个boolean变量标记是否全部符合要求
     * @param S
     * @param N
     * @return
     */
    public boolean queryString(String S, int N) {
        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            String binary = Integer.toBinaryString(i);
            if (!S.contains(binary)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
} 