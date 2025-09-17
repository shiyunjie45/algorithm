package com.sky.algorithmleetcode;

/*
有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。 现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一
组 K 名工人时，我们必须按照下述规则向他们支付工资：  	对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。 	工资组中的每名工
人至少应当得到他们的最低期望工资。  返回组成一个满足上述条件的工资组至少需要多少钱。     示例 1： 输入： quality = [10,20,5], w
age = [70,50,30], K = 2 输出： 105.00000 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。 示例 2： 输入：
 quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3 输出： 30.66667 解释： 我们向 0 号工人支付
 4，向 2 号和 3 号分别支付 13.33333。   提示：  	1 ，其中 N = quality.length = wage.length 	1 	1
 	与正确答案误差在 10^-5 之内的答案将被视为正确的。
*/

 java.util.*;

public class L857Solution {
    /**
     * @param quality: 工人的工作质量
     * @param wage:    工人最低期望工资
     * @param K:       需要招募的工人数量
     * @return 最少需要的资金
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double[] ratio = new double[n];

        // 计算每个工人的工资比例
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) wage[i] / quality[i];
        }

        // 按照工资比例从小到大排序
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Double.compare(ratio[a], ratio[b]));

        // 使用最小堆维护工人质量的最大值
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(K, Comparator.reverseOrder());
        double qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = indices[i];

            // 将当前工人加入最小堆
            maxHeap.offer(quality[curr]);
            qualitySum += quality[curr];

            // 如果最小堆大小超过了K，将堆顶工人删除
            if (maxHeap.size() > K) {
                qualitySum -= maxHeap.poll();
            }

            // 如果最小堆大小等于K，计算当前组的工资总和
            if (maxHeap.size() == K) {
                double cost = qualitySum * ratio[curr];
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }
} 