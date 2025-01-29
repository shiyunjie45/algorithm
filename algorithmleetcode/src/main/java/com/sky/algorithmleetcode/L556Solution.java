package com.sky.algorithmleetcode;

/*
给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。 示例 1:  输
入: 12 输出: 21  示例 2:  输入: 21 输出: -1
*/

 class L556Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length - 2;
        // 找到第一个降序的数
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = digits.length - 1;
        // 找到第一个比digits[i]大的数
        while (j >= 0 && digits[j] <= digits[i]) {
            j--;
        }
        // 交换i和j
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
        // 把i后面的数字按照升序排序
        Arrays.sort(digits, i + 1, digits.length);
        // 判断是否越界，如果越界返回-1
        long res = Long.parseLong(new String(digits));
        return res <= Integer.MAX_VALUE ? (int) res : -1;
    }
} 