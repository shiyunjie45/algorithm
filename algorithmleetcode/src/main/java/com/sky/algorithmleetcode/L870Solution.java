package com.sky.algorithmleetcode;

/*
给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 返回 A 的任意排列，使其相对于 B 
的优势最大化。   示例 1： 输入：A = [2,7,11,15], B = [1,10,4,11] 输出：[2,11,7,15]  示例 2： 输入：A =
 [12,24,8,32], B = [13,25,32,11] 输出：[24,32,8,12]    提示：  	1 	0 	0
*/

 java.util.Arrays;
import java.util.Comparator;

public class L870Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        Arrays.sort(A);
        Integer[] BIndex = new Integer[n];
        for (int i = 0; i < n; i++) {
            BIndex[i] = i;
        }
        Arrays.sort(BIndex, (i, j) -> B[j] - B[i]);
        int lowA = 0, highA = n - 1;
        for (int i = 0; i < n; i++) {
            if (A[highA] > B[BIndex[i]]) {
                res[BIndex[i]] = A[highA--];
            } else {
                res[BIndex[i]] = A[lowA++];
            }
        }
        return res;
    }
} 