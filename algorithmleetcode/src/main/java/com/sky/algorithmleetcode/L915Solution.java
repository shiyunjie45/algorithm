package com.sky.algorithmleetcode;

/*
给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：  	left 中的每个元素都小于或等于 right 中的
每个元素。 	left 和 right 都是非空的。 	left 要尽可能小。  在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。   示
例 1： 输入：[5,0,3,8,6] 输出：3 解释：left = [5,0,3]，right = [8,6]  示例 2： 输入：[1,1,1,0,6,12
] 输出：4 解释：left = [1,1,1,0]，right = [6,12]    提示：  	2 	0 	可以保证至少有一种方法能够按题目所描述的那样对
 A 进行划分。
*/

 class L915Solution {
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] maxLeft = new int[n];  // maxLeft[i]表示数组A[0:i]中的最大值
        int[] minRight = new int[n];  // minRight[i]表示数组A[i:n-1]中的最小值

        maxLeft[0] = A[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i]);
        }

        minRight[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], A[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (maxLeft[i] <= minRight[i + 1]) {
                return i + 1;
            }
        }

        return n;
    }
} 