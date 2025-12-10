package com.sky.algorithmleetcode;

/*
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：  	A.l
ength >= 3 	在 0  条件下，存在 i 使得： 	 		A[0] 		A[i] > A[i+1] > ... > A[A.length - 1] 	
 	       示例 1： 输入：[2,1] 输出：false  示例 2： 输入：[3,5,5] 输出：false  示例 3： 输入：[0,3,2,1] 
输出：true   提示：  	0 	0
*/

 class L941Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int i = 0;
        // 找到山顶
        while (i < n - 1 && A[i] < A[i + 1]) {
            i++;
        }
        // 判断是否存在山顶
        if (i == 0 || i == n - 1) {
            return false;
        }
        // 判断是否存在下降坡道
        while (i < n - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == n - 1;
    }
} 