package com.sky.algorithmleetcode;

/*
给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。 第 i 条边连接节点 edges[i][0] 和 edges[i][
1] 。 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。 示例 1:  输入: N = 6, edges = [[0,1],[0,2],[2,3]
,[2,4],[2,5]] 输出: [8,12,6,10,10,10] 解释: 如下为给定的树的示意图：  0 / \ 1  2  /|\  3 4 5 我们可
以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 也就是 1 + 1 + 2 + 2
 + 2 = 8。 因此，answer[0] = 8，以此类推。  说明: 1
*/

import java.util.*;

public class L834Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        //建立邻接表
        List<List<Integer>> adjacent = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjacent.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adjacent.get(edges[i][0]).add(edges[i][1]);
            adjacent.get(edges[i][1]).add(edges[i][0]);
        }
        int[] count = new int[N];//子树节点数量
        int[] ans = new int[N];//存储结果的数组
        Arrays.fill(count,1);//初始化所有子树节点数都为1
        postOrder(0,-1,adjacent,count,ans);//先处理0根节点的子树信息

        preOrder(0,-1,adjacent,count,ans);//再处理其他节点的子树信息

        return ans;

    }

    /**
     * 后序遍历计算各个子树节点数、到根节点距离之和
     * @param root  当前遍历的根节点
     * @param parent    当前遍历节点的父节点
     * @param adjacent  邻接表
     * @param count     存储各个子树的节点数量
     * @param ans       存储每个节点到其他节点的距离之和
     */
    private void postOrder(int root, int parent, List<List<Integer>> adjacent, int[] count, int[] ans){
        List<Integer> nextNodes = adjacent.get(root);

        for(int i=0;i<nextNodes.size();i++){
            int nextNode = nextNodes.get(i);
            if(nextNode==parent){//当前遍历节点已经是父节点，跳过
                continue;
            }

            postOrder(nextNode,root,adjacent,count,ans);

            count[root]+=count[nextNode];//累加子树节点数

            ans[root]+=ans[nextNode]+count[nextNode];//累加距离之和
        }
    }

    /**
     * 前序遍历计算各个节点的最终距离之和
     * @param root  当前遍历的根节点
     * @param parent    当前遍历节点的父节点
     * @param adjacent  邻接表
     * @param count     存储各个子树的节点数量
     * @param ans       存储每个节点到其他节点的距离之和
     */
    private void preOrder(int root, int parent, List<List<Integer>> adjacent, int[] count, int[] ans){
        List<Integer> nextNodes = adjacent.get(root);
        for(int i=0;i<nextNodes.size();i++){
            int nextNode = nextNodes.get(i);
            if(nextNode==parent){
                continue;
            }

            ans[nextNode] = ans[root]+(count.length-count[nextNode])-count[nextNode];
            preOrder(nextNode,root,adjacent,count,ans);
        }
    }
} 