package com.sky.algorithmleetcode;

/*
给定一副牌，每张牌上都写着一个整数。 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：  	每组都有 X 张牌。 	组内所有的牌
上都写着相同的整数。  仅当你可选的 X >= 2 时返回 true。   示例 1： 输入：[1,2,3,4,4,3,2,1] 输出：true 解释：可行的分
组是 [1,1]，[2,2]，[3,3]，[4,4]  示例 2： 输入：[1,1,1,2,2,2,3,3] 输出：false 解释：没有满足要求的分组。  示
例 3： 输入：[1] 输出：false 解释：没有满足要求的分组。  示例 4： 输入：[1,1] 输出：true 解释：可行的分组是 [1,1]  示例 5
： 输入：[1,1,2,2,2,2] 输出：true 解释：可行的分组是 [1,1]，[2,2]，[2,2]  提示：  	1 	0
*/

 java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L914Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // 特判
        if (deck.length < 2) {
            return false;
        }
        // 哈希表存储每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 获取哈希表中的值，存入一个数组中
        int[] counts = new int[map.size()];
        int index = 0;
        for (int value : map.values()) {
            counts[index++] = value;
        }
        // 判断 counts 数组中所有数是否都能整除
        int x = counts[0];
        for (int i = 1; i < counts.length; i++) {
            x = gcd(x, counts[i]);
            if (x == 1) {
                return false;
            }
        }
        return true;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        L914Solution solution = new L914Solution();
        int[] deck1 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] deck2 = {1, 1, 1, 2, 2, 2, 3, 3};
        int[] deck3 = {1};
        int[] deck4 = {1, 1};
        int[] deck5 = {1, 1, 2, 2, 2, 2};
        System.out.println(solution.hasGroupsSizeX(deck1)); // true
        System.out.println(solution.hasGroupsSizeX(deck2)); // false
        System.out.println(solution.hasGroupsSizeX(deck3)); // false
        System.out.println(solution.hasGroupsSizeX(deck4)); // true
        System.out.println(solution.hasGroupsSizeX(deck5)); // true
    }
} 