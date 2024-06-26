package com.sky.algorithmleetcode;

/*
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至
多为 k。   示例 1: 输入: nums = [1,2,3,1], k = 3 输出: true 示例 2: 输入: nums = [1,0,1,1], k
 = 1 输出: true 示例 3: 输入: nums = [1,2,3,1,2,3], k = 2 输出: false
*/

import java.util.HashMap;

public class L219Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
} 