package com.sky.algorithmleetcode;

/*
在本问题中, 树指的是一个连通且无环的无向图。 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的
两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u ，表示连接顶点u 和
v的无向图的边。 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 
u 。 示例 1： 输入: [[1,2], [1,3], [2,3]] 输出: [2,3] 解释: 给定的无向图为:  1 / \ 2 - 3  示例 2： 输
入: [[1,2], [2,3], [3,4], [1,4], [1,5]] 输出: [1,4] 解释: 给定的无向图为: 5 - 1 - 2   |  |  
 4 - 3  注意:  	输入的二维数组大小在 3 到 1000。 	二维数组中的整数在1到N之间，其中N是输入数组的大小。  更新(2017-09-26):
 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
*/

 java.util.*;

public class L684Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int x = edges[i][0], y = edges[i][1];
            int parentX = find(parent, x), parentY = find(parent, y);
            if (parentX == parentY) {
                return edges[i];
            } else {
                parent[parentX] = parentY;
            }
        }
        return new int[]{-1, -1};
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
} 