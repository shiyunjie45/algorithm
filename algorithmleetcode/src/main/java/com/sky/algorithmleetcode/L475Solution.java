package com.sky.algorithmleetcode;

/*
冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。 
所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。 说明:  	给出的房屋和供暖器的数目是非负数且不会超过 25000。 	给出的房屋和供暖
器的位置均是非负数且不会超过10^9。 	只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。 	所有供暖器都遵循你的半径标准，加热的半径也一样。  
示例 1:  输入: [1,2,3],[2] 输出: 1 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。  示例 2:
  输入: [1,2,3,4],[1,4] 输出: 1 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
*/

 java.util.Arrays;

public class L475Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // 将供暖器坐标从小到大排序
        Arrays.sort(heaters);
        // 初始化最小半径为0
        int minRadius = 0;
        for (int i = 0; i < houses.length; i++) {
            // 在供暖器数组中二分查找能够覆盖当前房屋的最小半径
            int j = Arrays.binarySearch(heaters, houses[i]);
            if (j < 0) {
                j = -(j + 1);
            }
            int leftRadius = j > 0 ? houses[i] - heaters[j - 1] : Integer.MAX_VALUE;
            int rightRadius = j < heaters.length ? heaters[j] - houses[i] : Integer.MAX_VALUE;
            // 更新最小半径
            minRadius = Math.max(minRadius, Math.min(leftRadius, rightRadius));
        }
        return minRadius;
    }
} 