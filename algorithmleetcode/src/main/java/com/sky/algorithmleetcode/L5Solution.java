package com.sky.algorithmleetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * Related Topics
 * 字符串
 * 动态规划
 */
public class L5Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 预处理字符串，避免奇偶性问题
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        String str = sb.toString();

        // 记录最长回文子串的中心和半径
        int center = 0, maxRight = 0;
        // 记录以每个字符为中心的回文串的半径
        int[] p = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (i < maxRight) {
                // 利用对称性计算 p[i]
                int mirror = 2 * center - i;
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            // 尝试继续扩展回文串
            int left = i - (p[i] + 1);
            int right = i + (p[i] + 1);
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;
            }
            // 更新最长回文子串的中心和半径
            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }
        }

        // 计算最长回文子串的起始位置和长度
        int maxLen = 0, start = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
