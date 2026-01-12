package com.sky.algorithmleetcode;

/*
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。   示例： 输入：A = [4,5,0,-2,-3,1], K = 5 输出
：7 解释： 有 7 个子数组满足其元素之和可被 K = 5 整除： [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2,
 -3], [0], [0, -2, -3], [-2, -3]    提示：  	1 	-10000 	2
*/

 java.util.HashMap;
import java.util.Map;

public class L974Solution {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum = (sum + A[i]) % K;
            if (sum < 0) {
                sum += K;
            }
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
} 