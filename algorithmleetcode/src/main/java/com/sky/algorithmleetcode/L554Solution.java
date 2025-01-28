package com.sky.algorithmleetcode;

/*
你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。  砖墙由行的列表表示。 每一行都是一
个代表从左至右每块砖的宽度的整数列表。  如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块
数量。  你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。     示例：  输入: [[1,2,2,1],    [3,1,2],    [1
,3,2],    [2,4],    [3,1,2],    [1,3,1,1]]  输出: 2  解释:        提示：   	每一行砖块的宽度之和应
该相等，并且不能超过 INT_MAX。 	每一行砖块的数量在 [1,10,000] 范围内， 墙的高度在 [1,10,000] 范围内， 总的砖块数量不超过 2
0,000。
*/

 java.util.*;

class L554Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // 统计每个“缝隙”的出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            // 不包括最后一个砖块
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // 找到出现次数最大的“缝隙”
        int maxCount = 0;
        for (int count : map.values()) {
            maxCount = Math.max(maxCount, count);
        }
        // 砖块的总数减去最大“缝隙”出现的次数即为穿过的砖块数量
        return wall.size() - maxCount;
    }
} 