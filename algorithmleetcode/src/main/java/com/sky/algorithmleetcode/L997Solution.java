package com.sky.algorithmleetcode;

/*
在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。 如果小镇的法官真的存在，那么：  	小镇的法官不相信任何人。 	每
个人（除了小镇法官外）都信任小镇的法官。 	只有一个人同时满足属性 1 和属性 2 。  给定数组 trust，该数组由信任对 trust[i] = [a, b
] 组成，表示标记为 a 的人信任标记为 b 的人。 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。   示例 1： 输入：N
 = 2, trust = [[1,2]] 输出：2  示例 2： 输入：N = 3, trust = [[1,3],[2,3]] 输出：3  示例 3： 输入
：N = 3, trust = [[1,3],[2,3],[3,1]] 输出：-1  示例 4： 输入：N = 3, trust = [[1,2],[2,3]]
 输出：-1  示例 5： 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]] 输出：3   提示：  	1 	
trust.length 	trust[i] 是完全不同的 	trust[i][0] != trust[i][1] 	1
*/

package com.algorithm.leetcode;

/**
 * @author
 * @description #997 找到小镇的法官
 * @create 2021-07-12 21:47
 **/
public class L997Solution {

    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        // 统计每个人的出度和入度
        for (int[] edge : trust) {
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        // 一个人既不信任任何人，又被其它N-1个人信任，那么这个人就是法官
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust1 = new int[][]{{1, 2}};
        int[][] trust2 = new int[][]{{1, 3}, {2, 3}};
        int[][] trust3 = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        int[][] trust4 = new int[][]{{1, 2}, {2, 3}};
        int[][] trust5 = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        L997Solution solution = new L997Solution();
        System.out.println(solution.findJudge(2, trust1));
        System.out.println(solution.findJudge(3, trust2));
        System.out.println(solution.findJudge(3, trust3));
        System.out.println(solution.findJudge(3, trust4));
        System.out.println(solution.findJudge(4, trust5));
    }

}

 