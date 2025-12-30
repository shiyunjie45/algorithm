package com.sky.algorithmleetcode;

/*
在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。 返回重复了 N 次的那个元素。     示例 1： 输入：[1,2,3,
3] 输出：3  示例 2： 输入：[2,1,2,5,3,2] 输出：2  示例 3： 输入：[5,1,5,2,5,3,5,4] 输出：5    提示：  	4
 	0 	A.length 为偶数
*/

 class L961Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1; // 此处代码逻辑需要根据题目具体要求修改
    }
} 