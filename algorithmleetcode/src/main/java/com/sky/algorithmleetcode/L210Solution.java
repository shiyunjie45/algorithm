package com.sky.algorithmleetcode;

/*
现在你总共有 n 门课需要选，记为 0 到 n-1。 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表
示他们: [0,1] 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所
有课程，返回一个空数组。 示例 1: 输入: 2, [[1,0]] 输出: [0,1] 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，
正确的课程顺序为 [0,1] 。 示例 2: 输入: 4, [[1,0],[2,0],[3,1],[3,2]] 输出: [0,1,2,3] or [0,2,1,
3] 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。    因此，一个正确的
课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。  说明:  	输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的
表示法。 	你可以假定输入的先决条件中没有重复的边。  提示:  	这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取
所有课程进行学习。 	通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 	 	拓扑排序也可以通过 B
FS 完成。
*/

import java.util.ArrayList;
 import java.util.ArrayList;
 import java.util.LinkedList;
import java.util.Queue; 

public class L210Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];    //存储每个课程的入度，即前置课程数量
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();   //邻接表，用于存储课程依赖关系
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());  //初始化邻接表
        }
        for (int[] pre : prerequisites) {
            int cur = pre[0];
            int preCourse = pre[1];
            indegrees[cur]++;   //更新入度
            adjList.get(preCourse).add(cur);  //更新邻接表
        }

        Queue<Integer> queue = new LinkedList<>();   //用于存储入度为0（即没有前置课程）的课程
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;    //记录res数组的下标
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[idx++] = cur;   //将入度为0的课程加入结果数组
            for (int next : adjList.get(cur)) { //遍历当前课程的所有后续课程
                indegrees[next]--;   //将后续课程的入度减1
                if (indegrees[next] == 0) { //如果减1后入度为0，加入队列中
                    queue.offer(next);
                }
            }
        }

        if (idx != numCourses) { //判断是否找到了拓扑排序序列
            return new int[0];
        } else {
            return res;
        }
    }
} 