package com.sky.algorithmleetcode;

/*
你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。 示例 1: 输入: [4, 1, 8, 7] 输出: 
True 解释: (8-4) * (7-1) = 24  示例 2: 输入: [1, 2, 1, 2] 输出: False  注意:  	除法运算符 / 表示实
数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。 	每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 
1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。 	你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12
 + 12 。
*/

 java.util.*;

public class L679Solution {

    private static final double TARGET = 24;
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        int size = list.size();
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                List<Double> nextRound = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j) {
                        nextRound.add(list.get(k));
                    }
                }
                // 加法
                if (i < j) {
                    nextRound.add(list.get(i) + list.get(j));
                    if (dfs(nextRound)) {
                        return true;
                    }
                    nextRound.remove(nextRound.size() - 1);
                }
                // 减法
                nextRound.add(list.get(i) - list.get(j));
                if (dfs(nextRound)) {
                    return true;
                }
                nextRound.remove(nextRound.size() - 1);
                // 乘法
                if (i < j) {
                    nextRound.add(list.get(i) * list.get(j));
                    if (dfs(nextRound)) {
                        return true;
                    }
                    nextRound.remove(nextRound.size() - 1);
                }
                // 除法
                if (Math.abs(list.get(j)) > EPSILON) {
                    nextRound.add(list.get(i) / list.get(j));
                    if (dfs(nextRound)) {
                        return true;
                    }
                    nextRound.remove(nextRound.size() - 1);
                }
            }
        }
        return false;
    }
} 