package com.sky.algorithmleetcode;

/*
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 你可以返回满足此条件的任何数组作为答案。   示例： 输入：[3
,1,2,4] 输出：[2,4,3,1] 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。    提示：  	1 	0
*/

public class L905Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int oddIndex = A.length - 1;
        int evenIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[evenIndex++] = A[i];
            } else {
                res[oddIndex--] = A[i];
            }
        }
        return res;
    }
} 