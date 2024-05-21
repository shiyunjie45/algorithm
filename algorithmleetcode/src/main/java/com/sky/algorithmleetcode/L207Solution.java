package com.sky.algorithmleetcode;

/*
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要
先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？   示例 1: 输入: 2, [[
1,0]] 输出: true 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 示例 2: 输入: 2, [[1,0],[0
,1]] 输出: false 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的
。   提示：  	输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 	你可以假定输入的先决条件中没有重复的边。 	1
*/

import java.util.*;

public class L207Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 用数组记录每个课程的后继课程，即邻接表
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // 用数组记录每个课程的前驱课程数量
        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course1 = pair[1];
            int course2 = pair[0];
            adjList.get(course1).add(course2);
            inDegree[course2]++;
        }
        // 宽度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0; // 记录已完成学习的课程数量
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            count++;
            for (int nextCourse : adjList.get(curCourse)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return count == numCourses;
    }
} 