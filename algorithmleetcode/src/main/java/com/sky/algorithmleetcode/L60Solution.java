package com.sky.algorithmleetcode;

/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：  	"123" 
	"132" 	"213" 	"231" 	"312" 	"321"  给定 n 和 k，返回第 k 个排列。 说明：  	给定 n 的范围是 [1, 9]。 
	给定 k 的范围是[1,  n!]。  示例 1: 输入: n = 3, k = 3 输出: "213"  示例 2: 输入: n = 4, k = 9 输出
: "2314"
*/

 L60Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--; // 转化为从0开始数的第k个排列
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            k %= factorial[i];
            sb.append(nums[index]);
            for (int j = index; j < i; j++) {
                nums[j] = nums[j + 1];
            }
        }
        return sb.toString();
    }
} 