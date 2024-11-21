package com.sky.algorithmleetcode;

/*
在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。 如果我们将游戏
规则改为 “玩家不能重复使用整数” 呢？ 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。 给定一个整
数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家
游戏时都表现最佳）？ 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。 示例： 输入： max
ChoosableInteger = 10 desiredTotal = 11 输出： false 解释： 无论第一个玩家选择哪个整数，他都会失败。 第一个玩家
可以选择从 1 到 10 的整数。 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。 第二个玩家可以通过选择整数 10（那么累积和为 1
1 >= desiredTotal），从而取得胜利. 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
*/

 java.util.HashMap;
import java.util.Map;

public class L464Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 特殊情况，处理先手赢的情况。
        if (desiredTotal == 0) {
            return true;
        }

        // 特殊情况，处理先手不能选的值比和少的情况，因为这种情况先手无法赢得游戏。
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        // 缓存无序的值（用一个长度为 maxChoosableInteger 的布尔数组表示），value 为能赢得游戏时先手选择某几个数所对应的最高分数
        Map<Integer, Boolean> memoMap = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0, memoMap);
    }

    /**
     * 返回能否赢得游戏。
     *
     * @param maxChoosableInteger 最大可选整数
     * @param desiredTotal 目标和
     * @param chosen 当前已选的值数组（因为值小于 20，可通过 int 类型的二进制优化）
     * @param memoMap 缓存
     * @return
     */
    private boolean canWin(int maxChoosableInteger, int desiredTotal, int chosen, Map<Integer, Boolean> memoMap) {
        if (memoMap.containsKey(chosen)) {
            return memoMap.get(chosen);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur = 1 << i - 1;
            if ((chosen & cur) == 0) {
                if (i >= desiredTotal || !canWin(maxChoosableInteger, desiredTotal - i, chosen | cur, memoMap)) {
                    memoMap.put(chosen, true);
                    return true;
                }
            }
        }
        memoMap.put(chosen, false);
        return false;
    }
} 