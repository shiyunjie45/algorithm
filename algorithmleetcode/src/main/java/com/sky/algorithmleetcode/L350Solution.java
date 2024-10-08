package com.sky.algorithmleetcode;

/*
给定两个数组，编写一个函数来计算它们的交集。 示例 1: 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2]  示例 
2: 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9] 说明：  	输出结果中每个元素出现的次数，应与元素在
两个数组中出现的次数一致。 	我们可以不考虑输出结果的顺序。  进阶:  	如果给定的数组已经排好序呢？你将如何优化你的算法？ 	如果 nums1 的大小比 n
ums2 小很多，哪种方法更优？ 	如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
*/

import java.util.*;

public class L350Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);  // 统计 nums1 中每个数字出现的次数
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);  // 获取 nums2 中每个数字在 nums1 中出现的次数
            if (count > 0) {
                list.add(num);
                map.put(num, count - 1);  // 将 nums1 中该数字出现次数减 1
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
} 