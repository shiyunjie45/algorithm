package com.sky.algorithmleetcode;

/*
在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。 输入一个有向图，
该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u and v和顶点的边，其中父节点u是子节点v的一个父节点
。 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 示例 1:  输入: [[1,2], [1,3], 
[2,3]] 输出: [2,3] 解释: 给定的有向图如下:  1 / \ v  v 2-->3  示例 2:  输入: [[1,2], [2,3], [3,4
], [4,1], [1,5]] 输出: [4,1] 解释: 给定的有向图如下: 5 2   ^  |   |  v   4  注意:  	二维数组大小的在3到
1000范围内。 	二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
*/

 L685Solution {
    
    Map<Integer, Integer> parent = new HashMap<>(); // 节点i的父节点
    int[] ufRank; // 带权并查集，用来判断是否出现环
    
    // 初始化并查集和parent
    public void init(int n) {
        ufRank = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ufRank[i] = 1;
            parent.put(i, i);
        }
    }
    
    // 查找节点的根节点
    public int find(int x) {
        while (x != parent.get(x)) {
            x = parent.get(x);
        }
        return x;
    }
    
    // 合并两个集合
    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) { // 出现环
            return;
        }
        if (ufRank[rootX] > ufRank[rootY]) {
            parent.put(rootY, rootX);
            ufRank[rootX] += ufRank[rootY];
        } else {
            parent.put(rootX, rootY);
            ufRank[rootY] += ufRank[rootX];
        }
    }
    
    // 判断是否是合法有根树
    public boolean isValidTree(int[][] edges, int rmEdge) {
        int n = parent.size() - 1; // 点的总数
        init(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (edge != edges[rmEdge]) { // 跳过待删除的边
                merge(u, v);
            }
        }
        // 判断是否是单独的一棵树
        int root = find(1);
        for (int i = 2; i <= n; i++) {
            if (find(i) != root) {
                return false;
            }
        }
        return true;
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length; // 边的总数
        int indegree[] = new int[n+1]; // 入度数组
        int flag = -1; // 有两个节点指向一个节点的标志
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            indegree[v]++;
            if (indegree[v] == 2) { // 出现两个节点指向v的情况
                flag = i;
            }
        }
        if (flag == -1) { // 不存在两个节点指向同一个节点的情况
            for (int i = n-1; i >= 0; i--) { // 倒序遍历edges
                if (isValidTree(edges, i)) {
                    return edges[i];
                }
            }
        } else { // 存在两个节点指向同一个节点的情况
            int x = edges[flag][0], y = edges[flag][1];
            if (isValidTree(edges, flag)) { // 如果删除边flag后仍是合法有根树，则边flag为答案
                return edges[flag];
            } else { // 如果删除边flag后不是合法有根树，则边flag不能为答案，需要判断哪一个边可以使剩余部分成为合法有根树
                for (int i = 0; i < n; i++) {
                    if (i != flag && edges[i][1] == y) { // 如果存在另一条边的终点也是y，则选择另一条边
                        if (isValidTree(edges, i)) {
                            return edges[i];
                        }
                    }
                }
                return edges[flag]; // 否则删除flag
            }
        }
        return new int[0]; // 没有找到答案，返回空数组
    }
} 