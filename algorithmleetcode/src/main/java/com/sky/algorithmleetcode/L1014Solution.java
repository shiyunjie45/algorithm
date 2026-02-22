package com.sky.algorithmleetcode;

/*
给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。 一对景点（i ）组成的观光组合的得分为（A[i
] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。 返回一对观光景点能取得的最高分。   示例： 输入：[8,1,5,2,6] 输出：1
1 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11    提示：  	2 	1
*/

 class L1014Solution {

    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;
        int maxSightseeingIndex = 0;
        for (int i = 0; i < A.length; i++) {
            maxScore = Math.max(maxScore, maxSightseeingIndex + A[i] - i);
            maxSightseeingIndex = Math.max(maxSightseeingIndex, A[i] + i);
        }
        return maxScore;
    }
} 