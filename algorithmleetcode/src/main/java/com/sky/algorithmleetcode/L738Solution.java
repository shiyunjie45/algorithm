package com.sky.algorithmleetcode;

/*
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 （当且仅当每个相邻位数上的数字 x 和 y 满足 x
  时，我们称这个整数是单调递增的。） 示例 1: 输入: N = 10 输出: 9  示例 2: 输入: N = 1234 输出: 1234  示例 3: 输
入: N = 332 输出: 299  说明: N 是在 [0, 10^9] 范围内的一个整数。
*/

 class L738Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int len = chars.length;
        int i = 1;
        while (i < len && chars[i - 1] <= chars[i]) {
            i++;
        }
        if (i == len) {
            return N;
        }
        while (i > 0 && chars[i - 1] > chars[i]) {
            chars[i - 1] = (char) (chars[i - 1] - 1);
            i--;
        }
        for (int j = i + 1; j < len; j++) {
            chars[j] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
} 