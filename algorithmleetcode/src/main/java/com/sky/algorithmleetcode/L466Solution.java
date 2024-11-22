package com.sky.algorithmleetcode;

/*
由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。 如果我们可以从 s2 中删除某些字符使
其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。 现在给你
两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，
其中 S1=[s1,n1] 、S2=[s2,n2] 。 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。   示例： 输入： s1 ="ac
b",n1 = 4 s2 ="ab",n2 = 2 返回： 2
*/

 class L466Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 记录每次 s1 遍历结束后，s2 匹配到的位置及次数
        int[][] match = new int[s1.length() + 1][s2.length() + 1];
        // 记录 s2 中每个字符在 s1 中出现的位置
        int[] next = new int[s2.length()];

        // 预处理 next 数组
        for (int i = 0, j = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            while (j < s1.length()) {
                if (s1.charAt(j++) == c) {
                    next[i] = j - 1;
                    break;
                }
            }
            if (next[i] == 0 && i > 0) {
                // 若 s2[i] 在 s1 中没有出现，则 s2[i] 前面的字符也不可能出现
                // 因此 s2[i] 及其前面的字符在 s1 中的下一次出现位置要从 i-1 开始查找
                next[i] = next[i - 1];
            }
        }

        int count = 0, k = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(k)) {
                    k++;
                    if (k == s2.length()) {
                        count++;
                        k = 0;
                    }
                }
            }
            if (match[j][k] != 0) {
                // 出现了循环节
                int len = i - match[j][k] + 1;
                int repeatCount = (n1 - i - 1) / len;
                int repeatMatchCount = count - match[j][k];
                count += repeatCount * repeatMatchCount;
                i += repeatCount * len;
            } else {
                match[j][k] = i + 1;
            }
        }

        return count / n2;
    }
} 