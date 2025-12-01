package com.sky.algorithmleetcode;

/*
对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得： 对于每个 i ，都不存在 k 满足 i  使得 A[k] * 2 = A
[i] + A[j]。 那么数组 A 是漂亮数组。   给定 N，返回任意漂亮数组 A（保证存在一个）。   示例 1： 输入：4 输出：[2,1,4,3]  
示例 2： 输入：5 输出：[3,1,2,5,4]   提示：  	1
*/

 class L932Solution {
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        if (N == 1) {
            res.add(1);
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

        int[] odds = beautifulArray((N + 1) / 2);
        int[] evens = beautifulArray(N / 2);
        for (int odd : odds) {
            res.add(odd * 2 - 1);
        }
        for (int even : evens) {
            res.add(even * 2);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
} 