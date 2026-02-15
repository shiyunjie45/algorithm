package com.sky.algorithmleetcode;

/*
在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平
铺的每一半上都有一个数字。） 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次
数。 如果无法做到，返回 -1.   示例 1：  输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2] 输出：2 解释： 图一表示：
在我们旋转之前， A 和 B 给出的多米诺牌。 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。  示例 2： 输入：
A = [3,5,1,2,3], B = [3,6,3,3,4] 输出：-1 解释： 在这种情况下，不可能旋转多米诺牌使一行的值相等。    提示：  	1 	
2
*/

 class L1007Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int cntA = 0, cntB = 0;
        // 判断以A[0]为标准时，将A中所有元素变成A[0]或将B中所有元素变成A[0]的最小旋转次数
        for (int i = 0; i < n; i++) {
            if (A[i] != A[0] && B[i] != A[0]) {
                cntA = -1;
                break;
            }
            if (A[i] != A[0]) cntA++;
            if (B[i] != A[0]) cntB++;
        }
        if (cntA == -1 && cntB == -1) return -1; // 无法旋转到一行相等
        if (cntA == -1) cntA = cntB;
        else if (cntB == -1) cntB = cntA;
        else cntA = Math.min(cntA, cntB); // 取旋转次数更小的那个
        cntB = 0;
        // 判断以B[0]为标准时，将A中所有元素变成B[0]或将B中所有元素变成B[0]的最小旋转次数
        for (int i = 0; i < n; i++) {
            if (A[i] != B[0] && B[i] != B[0]) return -1;  // 无法旋转到一行相等
            if (A[i] != B[0]) cntB++;
        }
        return Math.min(cntA, cntB);
    }
} 