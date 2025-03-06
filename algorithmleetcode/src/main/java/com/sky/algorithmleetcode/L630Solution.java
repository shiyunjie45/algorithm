package com.sky.algorithmleetcode;

/*
这里有 n 门不同的在线课程，他们按从 1 到 n 编号。每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。一门课要持续学习 t 天直到第 
d 天时要完成，你将会从第 1 天开始。 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。   示例：  输入: [[100, 2
00], [200, 1300], [1000, 1250], [2000, 3200]] 输出: 3 解释: 这里一共有 4 门课程, 但是你最多可以修 3 
门: 首先, 修第一门课时, 它要耗费 100 天，你会在第 100 天完成, 在第 101 天准备下门课。 第二, 修第三门课时, 它会耗费 1000 天，所
以你将在第 1100 天的时候完成它, 以及在第 1101 天开始准备下门课程。 第三, 修第二门课时, 它会耗时 200 天，所以你将会在第 1300 天时完
成它。 第四门课现在不能修，因为你将会在第 3300 天完成它，这已经超出了关闭日期。   提示:  	整数 1 	你不能同时修两门课程。
*/

 java.util.*;

public class L630Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // 排序
        int n = courses.length;
        int time = 0; // 记录当前时间
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 大根堆存储持续时间

        for (int i = 0; i < n; i++) {
            int t = courses[i][0], d = courses[i][1];
            if (time + t <= d) { // 能选则选
                pq.offer(t);
                time += t;
            } else if (!pq.isEmpty() && pq.peek() > t) { // 不能选则替换堆顶最长的课程
                time += t - pq.poll();
                pq.offer(t);
            }
        }
        return pq.size();
    }
} 