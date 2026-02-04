package com.sky.algorithmleetcode;

/*
给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。 返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的
充要条件是存在某个索引 i，使得 A1[i] != A2[i]。   示例 1： 输入：[1,17,8] 输出：2 解释： [1,8,17] 和 [17,8,1
] 都是有效的排列。  示例 2： 输入：[2,2,2] 输出：1    提示：  	1 	0
*/

 class L996Solution {
    private int res;
    private boolean[] used;
    private int[] nums;
    private int n;
    private int lastNum;
	
    public int numSquarefulPerms(int[] A) {
        res = 0;
        used = new boolean[A.length];
        nums = A;
        n = A.length;
        Arrays.sort(nums);
        lastNum = nums[0];
        backtrack(0, 0);
        return res;
    }
	
    private void backtrack(int idx, int cnt) {
        if (cnt == n) {
            res++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
               continue;
            }
            int sum = lastNum + nums[i];
            if (cnt == 0 || isPerfectSquare(sum)) {
                used[i] = true;
                lastNum = nums[i];
                backtrack(idx + 1, cnt + 1);
                used[i] = false;
            }
        }
    }
	
    private boolean isPerfectSquare(int num) {
        int temp = (int) Math.sqrt(num);
        return temp * temp == num;
    }
} 