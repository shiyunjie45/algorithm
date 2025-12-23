package com.sky.algorithmleetcode;

/*
给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 ，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 t
rue；否则，返回 false。   示例 1： 输入：[3,1,3,6] 输出：false  示例 2： 输入：[2,1,2,6] 输出：false  示例 
3： 输入：[4,-2,2,-4] 输出：true 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,
-4] 示例 4： 输入：[1,2,4,16,8,4] 输出：false    提示：  	0 	A.length 为偶数 	-100000
*/

 java.util.Arrays;

public class L954Solution {
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        boolean[] used = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            if (!used[i]) {
                boolean found = false;
                for (int j = i + 1; j < A.length; j++) {
                    if (!used[j] && 2 * A[i] == A[j]) {
                        found = true;
                        used[i] = used[j] = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }
} 