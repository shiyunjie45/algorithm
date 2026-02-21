package com.sky.algorithmleetcode;

/*
给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。 形式上，如果可以找出索引 i+1  且满足 (A[0] 
+ A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A
[A.length - 1]) 就可以将数组三等分。   示例 1： 输入：[0,2,1,-6,6,-7,9,1,2,0,1] 输出：true 解释：0 + 2
 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1  示例 2： 输入：[0,2,1,-6,6,7,9,-1,2,0,1] 输出：fal
se  示例 3： 输入：[3,3,6,5,-2,2,5,1,-9,4] 输出：true 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 
9 + 4    提示：  	3 	-10^4
*/

 class L1013Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int i = 0, j = A.length - 1;
        int leftSum = A[i], rightSum = A[j];
        while (i + 1 < j) {
            if (leftSum == target && rightSum == target) {
                return true;
            }
            if (leftSum != target) {
                i++;
                leftSum += A[i];
            }
            if (rightSum != target) {
                j--;
                rightSum += A[j];
            }
        }
        return false;
    }
} 