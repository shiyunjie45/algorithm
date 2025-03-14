package com.sky.algorithmleetcode;

/*
在LeetCode商店中， 有许多在售的物品。 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。 现给定每个物品的价格，每个大礼包包含物品的清单，
以及待购物品清单。请输出确切完成待购清单的最低花费。 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的
数量。 任意大礼包可无限次购买。 示例 1: 输入: [2,5], [[3,0,5],[1,2,10]], [3,2] 输出: 14 解释: 有A和B两种物品，
价格分别为¥2和¥5。 大礼包1，你可以以¥5的价格购买3A和0B。 大礼包2， 你可以以¥10的价格购买1A和2B。 你需要购买3个A和2个B， 所以你付了¥
10购买了1A和2B（大礼包2），以及¥4购买2A。 示例 2: 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1] 输出:
 11 解释: A，B，C的价格分别为¥2，¥3，¥4. 你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。 你需要买1A，2B和1C，所以你付了¥
4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。  说明:  	最多6种物品， 10
0种大礼包。 	每种物品，你最多只需要购买6个。 	你不可以购买超出待购清单的物品，即使更便宜。
*/

 java.util.*;

public class L638Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 暴搜解法，最后会TLE
        // return shopping(price, special, needs);

        // 记忆化搜索解法
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return shopping(price, special, needs, memo);
    }

    // 暴搜解法
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size(), res = 0;
        for (int i = 0; i < n; i++) {
            res += price.get(i) * needs.get(i);
        }
        for (List<Integer> s : special) {
            boolean isValid = true;
            List<Integer> needsCopy = new ArrayList<>(needs);
            for (int i = 0; i < n; i++) {
                int diff = needsCopy.get(i) - s.get(i);
                if (diff < 0) {
                    isValid = false;
                    break;
                }
                needsCopy.set(i, diff);
            }
            if (isValid) {
                res = Math.min(res, s.get(n) + shopping(price, special, needsCopy));
            }
        }
        return res;
    }

    // 记忆化搜索解法
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, 
                                  Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int n = price.size(), res = 0;
        for (int i = 0; i < n; i++) {
            res += price.get(i) * needs.get(i);
        }
        for (List<Integer> s : special) {
            boolean isValid = true;
            List<Integer> needsCopy = new ArrayList<>(needs);
            for (int i = 0; i < n; i++) {
                int diff = needsCopy.get(i) - s.get(i);
                if (diff < 0) {
                    isValid = false;
                    break;
                }
                needsCopy.set(i, diff);
            }
            if (isValid) {
                res = Math.min(res, s.get(n) + shopping(price, special, needsCopy, memo));
            }
        }
        memo.put(needs, res);
        return res;
    }
} 