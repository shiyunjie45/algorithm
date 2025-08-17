package com.sky.algorithmleetcode;

/*
有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。 现在我们有一些工人。worker[i]是第i个工人的能力
，即该工人只能完成难度小于等于worker[i]的工作。 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。 举个例子，如果3个工人都尝试完成一份报酬
为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。 我们能得到的最大收益是多少？ 示例： 输入: difficulty = 
[2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7] 输出: 100 解释: 工人被分配的工作
难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。 提示:  	1 	1 	difficulty[i], profit[i], wor
ker[i]  的范围是 [1, 10^5]
*/

 java.util.Arrays;

public class L826Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (j1, j2) -> j1.difficulty - j2.difficulty);

        int ans = 0;
        int maxProfit = 0;
        int j = 0;
        Arrays.sort(worker);
        for (int i = 0; i < worker.length; i++) {
            while (j < n && jobs[j].difficulty <= worker[i]) {
                maxProfit = Math.max(maxProfit, jobs[j].profit);
                j++;
            }
            ans += maxProfit;
        }
        return ans;
    }

    private static class Job {
        int difficulty;
        int profit;

        public Job(int diff, int pro) {
            this.difficulty = diff;
            this.profit = pro;
        }
    }
} 