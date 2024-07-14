package com.sky.algorithmleetcode;

/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 例如， [2,3,4] 的中位数是 3 [2,3] 的中位数是 (2 + 3) /
 2 = 2.5 设计一个支持以下两种操作的数据结构：  	void addNum(int num) - 从数据流中添加一个整数到数据结构中。 	double 
findMedian() - 返回目前所有元素的中位数。  示例： addNum(1) addNum(2) findMedian() -> 1.5 addNum
(3) findMedian() -> 2 进阶:  	如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 	如果数据流中 99% 的整数
都在 0 到 100 范围内，你将如何优化你的算法？
*/

import java.util.PriorityQueue;

public class L295Solution {

    // minHeap存储较大的一半数，堆顶即为较大一半的最小值
    private PriorityQueue<Integer> minHeap;
    // maxHeap存储较小的一半数，堆顶即为较小一半的最大值
    private PriorityQueue<Integer> maxHeap;

    public L295Solution() {
        // 较小一半数使用大根堆，堆顶即为最大值
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // 较大一半数使用小根堆，堆顶即为最小值
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            // 当前数量为偶数，将新元素添加到较大一半的小根堆中
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                // 如果新元素小于较大一半最小值，则先将新元素添加到较小一半的大根堆中
                // 再将较大一半最小值添加到较大一半的小根堆中，再将新元素添加到较大一半的小根堆中
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                // 直接添加到较大一半的小根堆中
                minHeap.offer(num);
            }
        } else {
            // 当前数量为奇数，将新元素添加到较小一半的大根堆中
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                // 如果新元素大于较小一半最大值，则先将新元素添加到较大一半的小根堆中
                // 再将较小一半最大值添加到较小一半的大根堆中，再将新元素添加到较小一半的大根堆中
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                // 直接添加到较小一半的大根堆中
                maxHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // 当前数量为偶数，中位数为较小一半的最大值与较大一半的最小值的平均数
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // 当前数量为奇数，中位数为较小一半的最大值
            return maxHeap.peek();
        }
    }
} 