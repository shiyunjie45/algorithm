package com.sky.algorithmleetcode;

/*
给定两个数组，编写一个函数来计算它们的交集。 示例 1: 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2]  示例 2:
 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [9,4] 说明:  	输出结果中的每个元素一定是唯一的。 	我们可
以不考虑输出结果的顺序。
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L349Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        // 将nums1中的元素存入set1中
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // 将nums2中与set1中相同的元素存入set2中
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        // 将set2中的元素放入List中，返回数组类型
        List<Integer> list = new ArrayList<>();
        for (int num : set2) {
            list.add(num);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

} 