package com.sky.algorithmleetcode;

/*
我们有一个非负整数数组 A。 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i ），我们对 B 中的每个元素进行按位
或操作，获得结果 A[i] | A[i+1] | ... | A[j]。 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）   示例 1： 输入
：[0] 输出：1 解释： 只有一个可能的结果 0 。  示例 2： 输入：[1,1,2] 输出：3 解释： 可能的子数组为 [1]，[1]，[2]，[1, 1
]，[1, 2]，[1, 1, 2]。 产生的结果为 1，1，2，1，3，3 。 有三个唯一值，所以答案是 3 。  示例 3： 输入：[1,2,4] 输出：6
 解释： 可能的结果是 1，2，3，4，6，以及 7 。    提示：  	1 	0
*/

 L898Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> set = new HashSet<>(); //用于保存所有可能的结果
        HashSet<Integer> pre = new HashSet<>(); //用于保存前一个子数组的结果集
        pre.add(0); //初始化前一个子数组的结果集为0
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> cur = new HashSet<>(); //用于保存当前子数组的结果集
            for (int num : pre) { //遍历前一个子数组的结果集
                cur.add(num | arr[i]); //将当前数与前一个结果集中的数按位或，并加入当前结果集
            }
            cur.add(arr[i]); //加入当前数自己，即子数组长度为1的情况
            pre = cur; //更新前一个子数组的结果集
            set.addAll(cur); //将当前子数组的结果集加入所有可能的结果集中
        }
        return set.size();
    }
} 