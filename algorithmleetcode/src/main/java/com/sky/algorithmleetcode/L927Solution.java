package com.sky.algorithmleetcode;

/*
给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。 如果可以做到，请返回任何 [i, j]，其中 i+1
 ，这样一来：  	A[0], A[1], ..., A[i] 组成第一部分； 	A[i+1], A[i+2], ..., A[j-1] 作为第二部分； 	A[
j], A[j+1], ..., A[A.length - 1] 是第三部分。 	这三个部分所表示的二进制值相等。  如果无法做到，就返回 [-1, -1]。 
注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1
] 和 [1,1] 表示相同的值。   示例 1： 输入：[1,0,1,0,1] 输出：[0,3]  示例 2： 输出：[1,1,0,1,1] 输出：[-1,-
1]   提示：  	3 	A[i] == 0 或 A[i] == 1
*/

 class L927Solution {
    public int[] threeEqualParts(int[] A) {
        int numberOfOnes = 0; // 统计数组中1的个数
        for (int i = 0; i < A.length; i++) {
            numberOfOnes += A[i];
        }

        if (numberOfOnes == 0) { // 当数组中没有1时，可以将数组切成[0,0,length-1]的形式
            return new int[]{0, A.length - 1};
        }

        if (numberOfOnes % 3 != 0) { // 如果1的个数不能被3整除，无法分成3个相等部分
            return new int[]{-1, -1};
        }

        int onesInEachPart = numberOfOnes / 3; // 每个部分中1的个数
        int i = 0, j = 0, k = 0;
        int ones = 0;
        while (ones < onesInEachPart) {
            if (A[k] == 1) {
                ones++;
            }
            k++;
        }
        i = k - 1;
        ones = 0;
        while (ones < onesInEachPart) {
            if (A[k] == 1) {
                ones++;
            }
            k++;
        }
        j = k;
        while (k < A.length) {
            if (A[i] != A[j] || A[j] != A[k]) {
                return new int[]{-1, -1}; // 如果三部分不相等，无法完成分割
            }
            i++;
            j++;
            k++;
        }
        return new int[]{i - 1, j};
    }
} 