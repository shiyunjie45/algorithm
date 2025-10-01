package com.sky.algorithmleetcode;

/*
汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 sta
tion[i][0] 英里处，并且有 station[i][1] 升汽油。 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英
里就会用掉 1 升汽油。 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目
的地，则返回 -1 。 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。   示例
 1： 输入：target = 1, startFuel = 1, stations = [] 输出：0 解释：我们可以在不加油的情况下到达目的地。  示例 2
： 输入：target = 100, startFuel = 1, stations = [[10,100]] 输出：-1 解释：我们无法抵达目的地，甚至无法到
达第一个加油站。  示例 3： 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30
,30],[60,40]] 输出：2 解释： 我们出发时有 10 升燃料。 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 
60 升。 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料）， 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。 
我们沿途在1两个加油站停靠，所以返回 2 。    提示：  	1 	0 	0
*/

 java.util.PriorityQueue;

public class L871Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // 保证只加了一次油时能到达的加油站进行第一次循环
        // 定义初始化的值 step=ans=0,i=0
        // 维护一个存储了到达加油站最多的堆 maxHeap，类似于贪心的思想，每次取出一个加油量最大的站点的油，然后跑到那个站点
        // 直到找到一个车能到达的最远的already_count的加油站或者无法到达
        // 过程中 step 记录车加油次数 ans 记录车到目前为止已加的油的总数（把已经加了的油加回去）
        int ans = 0 , i =0 , step = 0, already_count =0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        while(startFuel < target){
            while (i<stations.length&&stations[i][0]<=startFuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }
            if(maxHeap.isEmpty()) return -1;
            startFuel += maxHeap.poll();
            already_count++;
            ans += startFuel - already_count;
        }
        return step;
    }


    public static void main(String[] args) {
        L871Solution solution = new L871Solution();
        System.out.println(solution.minRefuelStops(100,1,new int[][]{{10,100}}));
        System.out.println(solution.minRefuelStops(100,10,new int[][]{{10,60},{20,30},{30,30},{60,40}}));
    }

} 