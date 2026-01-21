package com.sky.algorithmleetcode;

/*
给定一个整数数组 A，找出索引为 (i, j, k) 的三元组，使得：  	0 	0 	0 	A[i] & A[j] & A[k] == 0，其中 & 表示按位
与（AND）操作符。    示例： 输入：[2,1,3] 输出：12 解释：我们可以选出如下 i, j, k 三元组： (i=0, j=0, k=1) : 2 
& 2 & 1 (i=0, j=1, k=0) : 2 & 1 & 2 (i=0, j=1, k=1) : 2 & 1 & 1 (i=0, j=1, k=2) 
: 2 & 1 & 3 (i=0, j=2, k=1) : 2 & 3 & 1 (i=1, j=0, k=0) : 1 & 2 & 2 (i=1, j=0, k
=1) : 1 & 2 & 1 (i=1, j=0, k=2) : 1 & 2 & 3 (i=1, j=1, k=0) : 1 & 1 & 2 (i=1, j=
2, k=0) : 1 & 3 & 2 (i=2, j=0, k=1) : 3 & 2 & 1 (i=2, j=1, k=0) : 3 & 1 & 2    提
示：  	1 	0
*/

 class L982Solution {
    public int countTriplets(int[] A) {
        int count = 0;
        int n = A.length;
        // 枚举所有的三元组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((A[i] & A[j] & A[k]) == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
} 