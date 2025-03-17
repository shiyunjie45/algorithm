package com.sky.algorithmleetcode;

/*
给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 现在，我们定义一种跟随关系，当且仅当 b  时，数对(c, d) 才可以跟在 (a, b) 
后面。我们用这种形式来构造一个数对链。 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 示
例 :  输入: [[1,2], [2,3], [3,4]] 输出: 2 解释: 最长的数对链是 [1,2] -> [3,4]  注意：  	给出数对的个数在 
[1, 1000] 范围内。
*/

 java.util.Arrays;

public class L646Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        // 按照数对的第二个元素进行升序排序
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE; // 当前数对的第二个元素，初始化为负无穷
        int count = 0; // 数对链的长度
        for (int[] pair : pairs) {
            if (pair[0] > cur) { // 如果当前数对的第一个元素大于前一个数对的第二个元素，说明可以构成数对链
                cur = pair[1]; // 更新前一个数对的第二个元素
                count++; // 数对链的长度加一
            }
        }
        return count;
    }
} 