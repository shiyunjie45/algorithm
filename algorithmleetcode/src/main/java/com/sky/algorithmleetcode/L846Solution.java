package com.sky.algorithmleetcode;

/*
爱丽丝有一手（hand）由整数数组给定的牌。  现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。 如果她可以完成分组就返回 tru
e，否则返回 false。     示例 1： 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3 输出：true 解释：爱丽丝的手牌可以
被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。 示例 2： 输入：hand = [1,2,3,4,5], W = 4 输出：false 解释：爱
丽丝的手牌无法被重新排列成几个大小为 4 的组。   提示：  	1 	0 	1
*/

 java.util.HashMap;
import java.util.Map;

public class L846Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : hand) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        int groups = hand.length / W;
        for (int i = 0; i < groups; i++) {
            int minValue = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > 0 && entry.getKey() < minValue) {
                    minValue = entry.getKey();
                }
            }
            for (int j = 0; j < W; j++) {
                int key = minValue + j;
                if (!countMap.containsKey(key) || countMap.get(key) <= 0) {
                    return false;
                }
                countMap.put(key, countMap.get(key) - 1);
            }
        }

        return true;
    }
} 