package com.sky.algorithmleetcode;

/*
输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？   示例 1：
  输入: [1,2,3,3,4,5] 输出: True 解释: 你可以分割出这样两个连续子序列 : 1, 2, 3 3, 4, 5    示例 2：  输入:
 [1,2,3,3,4,4,5,5] 输出: True 解释: 你可以分割出这样两个连续子序列 : 1, 2, 3, 4, 5 3, 4, 5    示例 3：
  输入: [1,2,3,4,4,5] 输出: False    提示：  	输入的数组长度范围为 [1, 10000]
*/

 java.util.HashMap;
import java.util.Map;

public class L659Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> needMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freqMap.get(num) == 0) {
                continue;
            }
            if (needMap.getOrDefault(num, 0) > 0) {
                freqMap.put(num, freqMap.get(num) - 1);
                needMap.put(num, needMap.get(num) - 1);
                needMap.put(num + 1, needMap.getOrDefault(num + 1, 0) + 1);
            } else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0) {
                freqMap.put(num, freqMap.get(num) - 1);
                freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                freqMap.put(num + 2, freqMap.get(num + 2) - 1);
                needMap.put(num + 3, needMap.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
} 