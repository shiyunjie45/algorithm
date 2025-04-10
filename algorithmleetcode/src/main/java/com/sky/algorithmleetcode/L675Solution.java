package com.sky.algorithmleetcode;

/*
你被请来给一个要举办高尔夫比赛的树林砍树. 树林由一个非负的二维数组表示， 在这个数组中：  	0 表示障碍，无法触碰到. 	1 表示可以行走的地面. 	比 1
 大的数 表示一颗允许走过的树的高度.  每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。 你被要
求按照树的高度从低向高砍掉所有的树，每砍过一颗树，树的高度变为 1 。 你将从（0，0）点开始工作，你应该返回你砍完所有树需要走的最小步数。 如果你无法砍完所有
的树，返回 -1 。 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。   示例 1: 输入: [ [1,2,3], [0,0,4], [7,
6,5] ] 输出: 6  示例 2: 输入: [ [1,2,3], [0,0,0], [7,6,5] ] 输出: -1  示例 3: 输入: [ [2,3,4
], [0,0,5], [8,7,6] ] 输出: 6 解释: (0,0) 位置的树，你可以直接砍去，不用算步数    提示：  	1 	1 	0
*/

 java.util.*;

public class L675Solution {

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = forest.get(i).get(j);
                if (v > 1) trees.add(new int[]{v, i, j});
            }
        }
        Collections.sort(trees, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int[] cur = new int[]{0, 0};
        for (int[] tree : trees) {
            int step = bfs(forest, cur, tree, m, n);
            if (step == -1) return -1;
            ans += step;
            cur[0] = tree[1];
            cur[1] = tree[2];
            forest.get(cur[0]).set(cur[1], 1);
        }
        return ans;
    }

    private int bfs(List<List<Integer>> forest, int[] a, int[] b, int m, int n) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(a);
        visited[a[0]][a[1]] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == b[0] && cur[1] == b[1]) return step;
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || forest.get(x).get(y) == 0) continue;
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }
} 