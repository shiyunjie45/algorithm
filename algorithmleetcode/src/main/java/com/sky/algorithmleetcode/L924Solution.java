package com.sky.algorithmleetcode;

/*
在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另一个节点 j。 一些节点 initial 最初被恶意软件感染。只要两个节
点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。 假设 M(i
nitial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。 我们可以从初始列表中删除一个节点。如果移除这一节点将最小化 M(initial)
， 则返回该节点。如果有多个节点满足条件，就返回索引最小的节点。 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后可能仍然因恶意软件传播
而受到感染。     示例 1： 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1] 输出：0  示例 
2： 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2] 输出：0  示例 3： 输入：graph = 
[[1,1,1],[1,1,1],[1,1,1]], initial = [1,2] 输出：1    提示：  	1 	0 	graph[i][i] == 1 
	1 	0
*/

 class L924Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length, res = initial[0];
        boolean[] visited = new boolean[n];
        int[] malwareCount = new int[n]; // 统计被感染的节点数量
        Arrays.sort(initial);

        for (int i : initial) {
            Arrays.fill(visited, false); // 重置标记数组
            visited[i] = true;
            dfs(graph, visited, i, malwareCount);
        }

        int max = 0;
        for (int i : initial) {
            if (malwareCount[i] > max || (malwareCount[i] == max && i < res)) {
                max = malwareCount[i];
                res = i;
            }
        }

        return res;
    }

    private void dfs(int[][] graph, boolean[] visited, int curr, int[] malwareCount) {
        for (int i = 0; i < graph[curr].length; i++) {
            if (graph[curr][i] == 1 && !visited[i]) {
                visited[i] = true;
                malwareCount[i]++;
                dfs(graph, visited, i, malwareCount);
            }
        }
    }
} 