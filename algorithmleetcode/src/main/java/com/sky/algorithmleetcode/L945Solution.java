package com.sky.algorithmleetcode;

/*
给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。 返回使 A 中的每个值都是唯一的最少操作次数。 示例 1: 输入：[1,2,2]
 输出：1 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。 示例 2: 输入：[3,2,1,2,1,7] 输出：6 解释：经过 6 次 mov
e 操作，数组将变为 [3, 4, 1, 2, 5, 7]。 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。  提示：  	0 	
0
*/

 java.util.HashMap;
import java.util.Map;

public class L945Solution {

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        // 定义一个 map 记录每个数出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();

        // 统计每个数出现的次数
        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 定义一个变量记录需要调整的次数
        int moves = 0;

        // 遍历 map 中的每个键值对
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey(); // 数值
            int count = entry.getValue(); // 出现次数

            // 如果这个数值出现多次，需要将后面的重复数值都加上相应的偏移
            while (count > 1) {
                // 找到下一个还没有出现过的数值
                while (countMap.containsKey(num)) {
                    num++;
                    moves++;
                }

                // 标记这个数值已经使用过了
                countMap.put(num, 1);

                // 将重复的数值减少一次
                count--;
            }
        }

        return moves;
    }
} 