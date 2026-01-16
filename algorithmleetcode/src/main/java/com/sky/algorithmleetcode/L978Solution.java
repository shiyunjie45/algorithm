package com.sky.algorithmleetcode;

/*
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：  	若 i ，当 k 为奇数时， A[k] > A[k
+1]，且当 k 为偶数时，A[k] ； 	或 若 i ，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] 。  也就是说，如果比
较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 返回 A 的最大湍流子数组的长度。   示例 1： 输入：[9,4,2,10,7,8,8,1
,9] 输出：5 解释：(A[1] > A[2] A[4]  示例 2： 输入：[4,8,12,16] 输出：2  示例 3： 输入：[100] 输出：1   
 提示：  	1 	0
*/

 class L978Solution {
    public int maxTurbulenceSize(int[] A) {
        if(A.length == 1) {
            return 1;
        }
        int n = A.length;
        int ans = 1;
        int start = 0;
        boolean greater = false;
        for(int i = 1; i < n; i++) {
            if(A[i] == A[i-1]) {
                start = i;
                continue;
            }
            boolean curGreater = A[i] > A[i-1];
            if(i == 1 || curGreater == greater) {
                start = i - 1;
            }
            greater = curGreater;
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
} 