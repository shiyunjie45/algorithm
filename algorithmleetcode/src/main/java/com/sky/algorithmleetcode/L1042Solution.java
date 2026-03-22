package com.sky.algorithmleetcode;

/*
有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。 paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。 另外
，没有花园有 3 条以上的路径可以进入或者离开。 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。 以数组形式返回选择的方案作为
答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。   示例 1
： 输入：N = 3, paths = [[1,2],[2,3],[3,1]] 输出：[1,2,3]  示例 2： 输入：N = 4, paths = [[1,
2],[3,4]] 输出：[1,2,1,2]  示例 3： 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[
2,4]] 输出：[1,2,3,4]    提示：  	1 	0 	不存在花园有 4 条或者更多路径可以进入或离开。 	保证存在答案。
*/

 class L1042Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        //建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

        //染色，初始化为0，表示没种花
        int[] result = new int[N];
        int[] used = new int[5];

        for (int i = 1; i <= N; i++) {
            //遍历周围的花园，记录已经用过的花的种类
            Arrays.fill(used, 0);
            for (int neighbor : graph.get(i)) {
                used[result[neighbor-1]] = 1;
            }
            for (int j = 1; j <= 4; j++) {
                if (used[j] == 0) {
                    result[i-1] = j;  //染上一种没用过的花
                    break;
                }
            }
        }

        return result;
    }
} 