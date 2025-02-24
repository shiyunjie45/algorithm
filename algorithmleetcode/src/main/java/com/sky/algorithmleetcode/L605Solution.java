package com.sky.algorithmleetcode;

/*
假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 给定一个花坛（表示为一个数组包含0
和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。 示例 1:  
输入: flowerbed = [1,0,0,0,1], n = 1 输出: True  示例 2:  输入: flowerbed = [1,0,0,0,1],
 n = 2 输出: False  注意:  	数组内已种好的花不会违反种植规则。 	输入的数组长度范围为 [1, 20000]。 	n 是非负整数，且不会超过
输入数组的大小。
*/

 class L605Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true; // 如果不需要种花，直接返回true
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // 如果该位置为空地，判断其左右是否为空地，如果是则可以种花
                if ((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                    count++;
                    flowerbed[i] = 1; // 标记该位置已经种花
                    if (count == n) {
                        return true; // 如果种花数量达到n，直接返回true
                    }
                }
            }
        }
        return false; // 如果最后还不能满足种花数量，返回false
    }
} 