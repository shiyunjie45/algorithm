package com.sky.algorithmleetcode;

/*
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋
友。所谓的朋友圈，是指所有朋友的集合。 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个
学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。 示例 1:  输入: [[1,1,0], [1,1,0], [0,0,1]] 输出: 
2 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。 第2个学生自己在一个朋友圈。所以返回2。  示例 2:  输入: [[1,1,0], [1,1,1],
 [0,1,1]] 输出: 1 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。  注意
：  	N 在[1,200]的范围内。 	对于所有学生，有M[i][i] = 1。 	如果有M[i][j] = 1，则有M[j][i] = 1。
*/

 class L547Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n]; // 记录每个学生是否被访问过
        int count = 0; // 记录朋友圈数量

        for (int i = 0; i < n; i++) { // 遍历每个学生
            if (!visited[i]) { // 如果该学生没有被访问过
                dfs(M, i, visited); // 开始访问该学生所在的朋友圈
                count++; // 朋友圈数量 +1
            }
        }

        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true; // 将该学生标记为已访问

        for (int j = 0; j < M.length; j++) { // 遍历该学生的所有好友
            if (M[i][j] == 1 && !visited[j]) { // 如果该好友与该学生是朋友，并且该好友未被访问过
                dfs(M, j, visited); // 开始访问该好友所在的朋友圈
            }
        }
    }
} 