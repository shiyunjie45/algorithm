package com.sky.algorithmleetcode;

/*
我们有一组包含1和0的网格；其中1表示砖块。 当且仅当一块砖直接连接到网格的顶部，或者它至少有一块相邻（4 个方向之一）砖块不会掉落时，它才不会落下。 我们会依
次消除一些砖块。每当我们消除 (i, j) 位置时， 对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这个消除而落下。 返回一个数组表示每次消除操作对应落
下的砖块数目。 示例 1： 输入： grid = [[1,0,0,0],[1,1,1,0]] hits = [[1,0]] 输出: [2] 解释: 如果我们消除
(1, 0)位置的砖块, 在(1, 1) 和(1, 2) 的砖块会落下。所以我们应该返回2。 示例 2： 输入： grid = [[1,0,0,0],[1,1,
0,0]] hits = [[1,1],[1,0]] 输出：[0,0] 解释： 当我们消除(1, 0)的砖块时，(1, 1)的砖块已经由于上一步消除而消失了。所
以每次消除操作不会造成砖块落下。注意(1, 0)砖块不会记作落下的砖块。 注意:  	网格的行数和列数的范围是[1, 200]。 	消除的数字不会超过网格的区域
。 	可以保证每次的消除都不相同，并且位于网格的内部。 	一个消除的位置可能没有砖块，如果这样的话，就不会有砖块落下。
*/

 L803Solution {
    private int rows;
    private int cols;

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;

        // 将所有需要敲掉的砖块敲掉，记录下这个网格数组中砖块的状态
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            copy[i] = grid[i].clone();
        }
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        // 构建并查集，将顶部的每个砖块和砖块相邻的砖块合并
        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size + 1);
        for (int i = 0; i < cols; i++) {
            if (copy[0][i] == 1) {
                unionFind.union(i, size);
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionFind.union(getIndex(i, j - 1), getIndex(i, j));
                    }
                }
            }
        }

        int hitsLen = hits.length;
        int[] res = new int[hitsLen];
        for (int i = hitsLen - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 0) {
                continue;
            }

            int origin = unionFind.getSize(size);
            if (x == 0) {
                unionFind.union(y, size);
            }

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValid(newX, newY) && copy[newX][newY] == 1) {
                    unionFind.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            int current = unionFind.getSize(size);
            res[i] = Math.max(0, current - origin - 1);
            copy[x][y] = 1;
        }

        return res;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }
}

class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getParent(int x) {
        if (parent[x] != x) {
            parent[x] = getParent(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = getParent(x);
        int rootY = getParent(y);

        if (rootX == rootY) {
            return;
        }

        parent[rootX] = rootY;
        size[rootY] += size[rootX];
    }

    public boolean isConnected(int x, int y) {
        return getParent(x) == getParent(y);
    }

    public int getSize(int x) {
        return size[getParent(x)];
    }
} 