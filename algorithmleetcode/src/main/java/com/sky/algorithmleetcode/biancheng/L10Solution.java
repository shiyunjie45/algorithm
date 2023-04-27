package com.sky.algorithmleetcode.biancheng;

import com.sky.algorithmleetcode.utils.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * 既分治算法和贪心算法之后，本节再给您介绍一种常用的算法——动态规划算法。
 *
 * 和分治算法类似，动态规划算法也是先将问题分解成多个规模更小、更容易解决的小问题，通过解决这些小问题，从而找到解决整个问题的方法。不同之处在于，分治算法分解的每个小问题都是相互独立的，而动态规划算法分解的小问题之间往往存在关联，比如要想解决问题 A 和问题 B，必须先解决问题 C。
 *
 * 讲解贪心算法时，我们举过一个例子：假设有 3 种面值分别为 1、7 和 10 的硬币，要求用尽可能少的硬币拼凑出的总面值为 15。贪心算法的解决方案为共需要 6 枚硬币（10+1+1+1+1+1），但如果采用动态规划算法，可以找到更优的解决方案，只需要 3 枚硬币（ 7+7+1）。
 *
 * 动态规划算法的解题思路是：用 f(n) 表示凑齐面值为 n 所需要的最少的硬币数量，则面值 15 的拼凑方案有以下 3 种：
 * f(15) = f(14) +1：选择一枚面值为 1 的硬币，f(14) 表示拼凑出面值 14 所需要的最少的硬币数量；
 * f(15) = f(8) + 1：选择一枚面值为 7 的硬币，f(8) 表示拼凑出面值 8 所需要的最少的硬币数量；
 * f(15) = f(5) + 1：选择一枚面值为10 的硬币，f(5) 表示拼凑出面值 5 所需要的最少的硬币数量。
 *
 * 由此，我们将求 f(15) 的值，转换成为了求 min( f(14) , f(8) , f(5) ) 的值（min() 表示取三者中的最小值）。在此基础上，f(14)、f(8)、f(5) 还可以分解为更小的问题：
 * f(5) = f(4) + 1；
 * f(8) = f(7) + 1 = f(1) +1；
 * f(14) = f(13)+1 = f(7) + 1 = f(4) +1。
 *
 * 通过不断地分解，问题的规模会不断地减小，直至分解为 f(0) 或 f(1) 这类很简单的子问题。也就是说，我们只需要求得 f(0) 和f(1) 的值，所有小问题都可以得到解决（如表 1 所示）。
 *
 * 表 1 动态规划算法
 * 子问题	分解方案	最佳方案	硬币数量
 * f(0)	不可再分	不选择任何硬币	0
 * f(1)	f(0) + 1	"1"	1
 * f(2)	f(1) + 1	"1+1"	2
 * f(3)	f(2) + 1	"1+1+1"	3
 * f(4)	f(3) + 1	"1+1+1+1"	4
 * f(5)	f(4) + 1	"1+1+1+1+1"	5
 * f(6)	f(5) + 1	 "1+1+1+1+1+1"	6
 * f(7)	f(6) + 1 , f(0) + 1	"7"	1
 * f(8)	f(7) + 1 , f(1) + 1	"7+1"	2
 * f(9)	f(8) + 1 , f(2) + 1	"7+1+1"	3
 * f(10)	f(9) + 1 , f(3) + 1 , f(0) + 1	"10"	1
 * f(11)	f(10) + 1 , f(4) + 1 , f(1) + 1	"10+1"	2
 * f(12)	f(11) + 1 , f(5) + 1 , f(2) + 1	"10+1+1"	3
 * f(13)	f(12) + 1 , f(6) + 1 , f(3) + 1	"10+1+1+1"	4
 * f(14)	f(13) + 1 , f(7) + 1 , f(4) + 1	"7+7"	2
 * f(15)	f(14) + 1 , f(8) + 1 , f(5) + 1	"7+7+1"	3
 * 表 1 中借助 f(0) 和 f(1) 的值，依次推导出了 f(2)~f(15) 的值。因此，我们可以很容易得出“拼凑总面值为 15 只需要 7+7+1 共 3 个硬币”的最佳解决方案，这样解决问题的方法就称为动态规划算法。
 */
public class L10Solution {

    public static int getMinCombination(int[] moneyCombination,int target){
        int min = -1;
        for (int i = 0; i < moneyCombination.length; i++) {
            int cnt = 0;
            if (target - moneyCombination[i]>0) {
                int res = getMinCombination(moneyCombination,target-moneyCombination[i]);
                if (res>-1){
                    cnt = res +1;
                }else{
                    continue;
                }
            } else if (target - moneyCombination[i]==0) {
                return cnt+1;
            }else{
                continue;
            }
            if (cnt>-1){
                if (-1==min||min>cnt){
                    min = cnt;
                }
            }
        }
        return min;
    }


    public static int getMinCombination2(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        int[] path = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (dp[i - coins[j]] + 1 < dp[i]) {
                        dp[i] = dp[i - coins[j]] + 1;
                        path[i] = coins[j];
                    }
                }
            }
        }
        System.out.println("最少硬币数量: " + dp[amount]);
        System.out.print("硬币组合: ");
        while (amount > 0) {
            System.out.print(path[amount] + " ");
            amount -= path[amount];
        }
        System.out.println();
        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount, int[] memo, int[] path) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != 0) return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin, memo, path);
            if (subProblem == -1) continue;
            if (subProblem + 1 < res) {
                res = subProblem + 1;
                path[amount] = coin;
            }
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = Utils.generateRandomArray(5,1,20);
        Random random = new Random();
        int target = random.nextInt(100);

        System.out.println("硬币值为:"+Arrays.toString(coins));
        System.out.println("目标金额:"+target);
        System.out.println("最少硬币数量:"+getMinCombination(coins,target));
        getMinCombination2(coins,target);

        int[] memo = new int[target + 1];;
        int[] path = new int[target + 1];;
        int result = coinChange(coins, target,memo,path);
        System.out.println("最少硬币数量: " + result);
        System.out.print("硬币组合: ");
        while (target > 0) {
            System.out.print(path[target] + " ");
            target -= path[target];
        }
        System.out.println();
    }
}
