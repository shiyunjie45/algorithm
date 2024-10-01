package com.sky.algorithmleetcode;

/*
一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。 给定石子的
位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能
跳跃一个单位（即只能从单元格1跳至单元格2）。 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请
注意，青蛙只能向前方（终点的方向）跳跃。 请注意：  	石子的数量 ≥ 2 且  	每一个石子的位置序号都是一个非负整数，且其 31； 	第一个石子的位置永远是
0。  示例 1:  [0,1,3,5,6,8,12,17] 总共有8个石子。 第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置, 
第三个石子在序号为3的单元格的位置， 以此定义整个数组... 最后一个石子处于序号为17的单元格的位置。 返回 true。即青蛙可以成功过河，按照如下方案跳跃：
 跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着 跳2个单位到第4块石子, 然后跳3个单位到第6块石子, 跳4个单位到第7块石子, 最后，跳5个单
位到第8个石子（即最后一块石子）。  示例 2:  [0,1,2,3,4,8,9,11] 返回 false。青蛙没有办法过河。 这是因为第5和第6个石子之间的间
距太大，没有可选的方案供青蛙跳跃过去。
*/

 class L403Solution {
    public boolean canCross(int[] stones) {
        // 使用哈希表记录每个石头可达的距离
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // 初始化数据：第一个石头只能跳1步
        map.put(0, new HashSet<>());
        map.get(0).add(1);

        // 处理每一个石头
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
            for (int j = 0; j < i; j++) {
                // 计算当前石头和前面石头的距离
                int distance = stones[i] - stones[j];
                // 判断前面石头是否可达
                if (map.containsKey(stones[j])) {
                    // 当前石头可达的距离为前面石头可达的所有距离+1、+0、-1
                    Set<Integer> set = map.get(stones[j]);
                    if (set.contains(distance - 1) || set.contains(distance) || set.contains(distance + 1)) {
                        map.get(stones[i]).add(distance);
                    }
                }
            }
        }

        // 判断最后一个石头是否可达
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
} 