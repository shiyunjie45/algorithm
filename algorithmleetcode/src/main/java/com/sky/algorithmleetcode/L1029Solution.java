package com.sky.algorithmleetcode;

/*
公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。 返回将每个人都飞到某座城市的最低
费用，要求每个城市都有 N 人抵达。   示例： 输入：[[10,20],[30,200],[400,50],[30,20]] 输出：110 解释： 第一个人去
 A 市，费用为 10。 第二个人去 A 市，费用为 30。 第三个人去 B 市，费用为 50。 第四个人去 B 市，费用为 20。 最低总费用为 10 + 3
0 + 50 + 20 = 110，每个城市都有一半的人在面试。    提示：  	1 	costs.length 为偶数 	1
*/

 java.util.Arrays;

public class L1029Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        Arrays.sort(costs, (c1, c2) -> Math.abs(c2[0] - c2[1]) - Math.abs(c1[0] - c1[1]));
        int ans = 0, a = 0, b = 0;
        for (int[] cost : costs) {
            if ((cost[0] <= cost[1] && a < n) || b == n) {
                ans += cost[0];
                a++;
            } else {
                ans += cost[1];
                b++;
            }
        }
        return ans;
    }
} 