package com.sky.algorithmleetcode;

/*
给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。 选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。 比如，有 A 
= ["babca","bbazb"]，删除索引序列 {0, 1, 4}，删除后 A 为["bc","az"]。 假设，我们选择了一组删除索引 D，那么在执行删
除操作之后，最终得到的数组的行中的每个元素都是按字典序排列的。 清楚起见，A[0] 是按字典序排列的（即，A[0][0] ），A[1] 是按字典序排列的（即，A
[1][0] ），依此类推。 请你返回 D.length 的最小可能值。   示例 1： 输入：["babca","bbazb"] 输出：3 解释： 删除 0、
1 和 4 这三列后，最终得到的数组是 A = ["bc", "az"]。 这两行是分别按字典序排列的（即，A[0][0] A[1] —— 数组 A 不一定是按
字典序排列的。  示例 2： 输入：["edcba"] 输出：4 解释：如果删除的列少于 4 列，则剩下的行都不会按字典序排列。  示例 3： 输入：["ghi
","def","abc"] 输出：0 解释：所有行都已按字典序排列。    提示：  	1 	1
*/

 L960Solution {
    public int minDeletionSize(String[] A) {
        int n = A.length;
        int m = A[0].length();

        // 标识当前列是否需要删除
        boolean[] delete = new boolean[m];

        // 统计需要删除的列数
        int ans = 0;

        // 外循环遍历每一列
        for (int i = 0; i < m; i++) {
            // 内循环遍历每一行
            for (int j = 1; j < n; j++) {
                // 如果当前列已经被标记为需要删除，则跳过检查
                if (delete[i]) {
                    break;
                }
                // 如果当前行的当前列字符比前一行的当前列字符小
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    // 标记当前列需要删除
                    delete[i] = true;
                    // 统计需要删除的列数
                    ans++;
                    // 跳出内循环
                    break;
                }
            }
        }

        return ans;
    }
} 