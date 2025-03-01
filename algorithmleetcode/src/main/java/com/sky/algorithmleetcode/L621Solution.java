package com.sky.algorithmleetcode;

/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可
以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至
少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 你需要计算完成所有任务所需要的最短时间。   示例 ： 输入：tasks = ["A",
"A","A","B","B","B"], n = 2 输出：8 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B. 
  在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。    提示：  	任
务的总个数为 [1, 10000]。 	n 的取值范围为 [0, 100]。
*/

 java.util.*;

public class L621Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequency = new int[26];
        for (char task : tasks) {
            taskFrequency[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int frequency : taskFrequency) {
            if (frequency > 0) {
                maxHeap.offer(frequency);
            }
        }

        int totalTime = 0;
        while (!maxHeap.isEmpty()) {
            int interval = n + 1;
            List<Integer> temp = new ArrayList<>();

            // 从堆中取出最多 interval 个任务，维护剩余任务数量后再入堆
            for (int i = 0; i < interval; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll() - 1);
                } else {
                    break;
                }
            }

            // 实际执行的任务数量
            int executedTasks = temp.size();

            // 将操作完的任务重新入堆
            for (int k = 0; k < temp.size(); k++) {
                if (temp.get(k) > 0) {
                    maxHeap.offer(temp.get(k));
                }
            }

            totalTime += executedTasks;

            // 如果堆非空，说明还有任务待执行
            if (!maxHeap.isEmpty()) {
                // 当前格执行的任务数量比 interval 少，说明会有 interval 时间的等待
                totalTime += interval - executedTasks;
            }
        }

        return totalTime;
    }
} 