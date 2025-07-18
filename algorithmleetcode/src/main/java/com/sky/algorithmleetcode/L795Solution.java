package com.sky.algorithmleetcode;

/*
给定一个元素都是正整数的数组A ，正整数 L 以及 R (L )。 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。 例如 : 输入: A =
 [2, 1, 4, 3] L = 2 R = 3 输出: 3 解释: 满足条件的子数组: [2], [2, 1], [3].  注意:  	L, R  和 A
[i] 都是整数，范围在 [0, 10^9]。 	数组 A 的长度范围在[1, 50000]。
*/

 class L795Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count = 0;  // 子数组数量
        int left = -1;  // L和R之间的左侧下标
        int right = -1;  // R右侧的下标
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {  // 如果当前元素大于R，清空left和right
                left = -1;
                right = -1;
            } else if (A[i] >= L && A[i] <= R) {  // 如果当前元素在L和R之间
                count += i - right;  // 中间的子数组数量
                left = i;  // 更新left
            } else if (left != -1) {  // 如果当前元素小于L
                count += left - right;  // 中间的子数组数量
            }
            if (A[i] >= L) {  // 更新right
                right = i;
            }
        }
        return count;
    }
} 