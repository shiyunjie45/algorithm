package com.sky.algorithmleetcode;

/*
数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 并且 A[i] > A[j] ，局部倒
置指的是 i 满足 0  并且 A[i] > A[i+1] 。 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。   示例 1:  输入: 
A = [1,0,2] 输出: true 解释: 有 1 个全局倒置，和 1 个局部倒置。  示例 2:  输入: A = [1,2,0] 输出: false 
解释: 有 2 个全局倒置，和 1 个局部倒置。  注意:  	A 是 [0, 1, ..., A.length - 1] 的一种排列 	A 的长度在 [1, 
5000]之间 	这个问题的时间限制已经减少了。
*/

 java.lang.Math;

public class L775Solution {
    public boolean isIdealPermutation(int[] A) {
        int global = 0, local = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    global++;
                }
            }
            if (i < A.length - 1 && A[i] > A[i + 1]) {
                local++;
            }
        }
        return global == local;
    }
} 