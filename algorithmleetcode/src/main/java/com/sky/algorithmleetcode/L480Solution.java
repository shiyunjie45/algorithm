package com.sky.algorithmleetcode;

/*
中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 例如：  	[2,3,4]，中位数是 3 	[2,
3]，中位数是 (2 + 3) / 2 = 2.5  给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动
 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。   示例： 给出 nums = [1,3,-1,-3,5,3,6,7
]，以及 k = 3。 窗口位置           中位数 ---------------        ----- [1 3 -1] -3 5 3 6 7 
   1 1 [3 -1 -3] 5 3 6 7   -1 1 3 [-1 -3 5] 3 6 7   -1 1 3 -1 [-3 5 3] 6 7    3 
1 3 -1 -3 [5 3 6] 7    5 1 3 -1 -3 5 [3 6 7]   6   因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5
,6]。   提示：  	你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。 	与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
*/

 java.util.Collections;
import java.util.PriorityQueue;

public class L480Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1; // 结果数组的大小
        double[] median = new double[n];
        // 初始化两个堆，存储数组中的前k个数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 将前k个数加入堆中
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        // 添加初始中位数
        if (k % 2 == 1) {
            median[0] = maxHeap.peek();
        } else {
            median[0] = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        }
        // 滑动窗口
        for (int i = k; i < nums.length; i++) {
            // 移除堆中的最左边的数
            int remove = nums[i - k];
            if (maxHeap.peek() >= remove) {
                maxHeap.remove(remove);
            } else {
                minHeap.remove(remove);
            }
            // 添加新的数
            if (maxHeap.size() - minHeap.size() >= 2) {
                minHeap.offer(maxHeap.poll());
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            // 计算中位数
            if (k % 2 == 1) {
                median[i - k + 1] = maxHeap.peek();
            } else {
                median[i - k + 1] = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
            }
        }
        return median;
    }
} 