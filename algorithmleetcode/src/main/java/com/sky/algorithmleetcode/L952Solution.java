package com.sky.algorithmleetcode;

/*
给定一个由不同正整数的组成的非空数组 A，考虑下面的图：  	有 A.length 个节点，按从 A[0] 到 A[A.length - 1] 标记； 	只有当
 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i] 和 A[j] 之间才有一条边。  返回图中最大连通组件的大小。     示例 1： 输入：[4
,6,15,35] 输出：4  示例 2： 输入：[20,50,9,63] 输出：2  示例 3： 输入：[2,3,6,7,4,12,21,39] 输出：8  
  提示：  	1 	1
*/

 java.util.*;

public class L952Solution {
    public int largestComponentSize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(100001);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    uf.union(num, j);
                    uf.union(num, num / j); // 要同时将num / j加入到union中
                }
            }
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int root = uf.find(num);
            map.put(root, map.getOrDefault(root, 0) + 1);
            res = Math.max(res, map.get(root));
        }
        return res;
    }

    /**
     * 并查集类
     */
    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 合并两个节点
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }

        /**
         * 查询根节点
         */
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
} 