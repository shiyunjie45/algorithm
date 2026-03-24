package com.sky.algorithmleetcode;

/*
给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案
为 ""。）   示例 1： 输入："banana" 输出："ana"  示例 2： 输入："abcd" 输出：""    提示：  	2 	S 由小写英文字母
组成。
*/

 class L1044Solution {
    public String longestDupSubstring(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int len = S.length();
        int[] sa = new int[len];
        int[] rank = new int[len];
        int[] height = new int[len];

        for (int i = 0; i < len; i++) {
            sa[i] = i;
            rank[i] = S.charAt(i);
        }

        for (int k = 1; k < len; k *= 2) {
            int[] tmp = new int[len];
            for (int i = 0; i < len; i++) {
                tmp[i] = rank[i];
            }
            for (int i = 0; i < len - k; i++) {
                int x = tmp[i];
                int y = tmp[i + k];
                if (x == y) {
                    rank[i] = rank[i + k];
                } else {
                    rank[i] = Math.min(x, y);
                }
            }
            for (int i = 0; i < len; i++) {
                tmp[sa[i]] = rank[i];
            }
            rank = tmp;
        }

        for (int i = 0; i < len; i++) {
            rank[sa[i]] = i;
        }

        int h = 0;
        for (int i = 0; i < len; i++) {
            if (rank[i] == 0) {
                continue;
            }
            int j = sa[rank[i] - 1];
            while (i + h < len && j + h < len && S.charAt(i + h) == S.charAt(j + h)) {
                h++;
            }
            height[rank[i]] = h;
            if (h > 0) {
                h--;
            }
        }

        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (height[i] > maxLen) {
                maxLen = height[i];
                start = i;
            }
        }

        if (maxLen == 0) {
            return "";
        } else {
            return S.substring(sa[start], sa[start] + maxLen);
        }
    }
} 