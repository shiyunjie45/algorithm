package com.sky.algorithmleetcode;

/*
给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。 每个人都可能不喜欢其他人，那么他们不应该属于同一组。 形式上，如果 
dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。 当可以用这种方法将每个人分进两组时，返回 true；否则返回 fal
se。     示例 1： 输入：N = 4, dislikes = [[1,2],[1,3],[2,4]] 输出：true 解释：group1 [1,4], 
group2 [2,3]  示例 2： 输入：N = 3, dislikes = [[1,2],[1,3],[2,3]] 输出：false  示例 3： 输入：
N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]] 输出：false    提示：  	1 	0 	1 	dis
likes[i][0] 	对于 dislikes[i] == dislikes[j] 不存在 i != j
*/

 L886Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] group = new int[N+1];
        List<Integer>[] dislikeList = new List[N+1];
        for(int i=1;i<=N;i++) {
            dislikeList[i] = new ArrayList<>();
        }
        for(int[] dislike: dislikes) {
            dislikeList[dislike[0]].add(dislike[1]);
            dislikeList[dislike[1]].add(dislike[0]);
        }
        for(int i=1;i<=N;i++) {
            if(group[i] == 0 && !dfs(dislikeList, group, i, 1)){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(List<Integer>[] dislikeList, int[] group, int index, int g) {
        group[index] = g;
        for(int dislike: dislikeList[index]) {
            if(group[dislike] == g) {
                return false;
            } else if(group[dislike] == 0 && !dfs(dislikeList, group, dislike, -g)) {
                return false;
            }
        }
        return true;
    }
} 