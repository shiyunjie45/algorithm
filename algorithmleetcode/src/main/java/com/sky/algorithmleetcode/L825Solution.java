package com.sky.algorithmleetcode;

/*
人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。 当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友
请求：  	age[B]  	age[B] > age[A] 	age[B] > 100 && age[A]   否则，A 可以给 B 发送好友请求。 注意如果
 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。  求总共会发出多少份好友请求?   示例 1: 输入: [1
6,16] 输出: 2 解释: 二人可以互发好友申请。  示例 2: 输入: [16,17,18] 输出: 2 解释: 好友请求可产生于 17 -> 16, 1
8 -> 17. 示例 3: 输入: [20,30,100,110,120] 输出: 3 解释: 好友请求可产生于 110 -> 100, 120 -> 110
, 120 -> 100.    说明:  	1 . 	1 .
*/

 java.util.Arrays;

public class L825Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (ages[i] > 14) { // 年龄大于14的才有资格发好友请求
                int left = binarySearch(ages, (int) (ages[i] * 0.5 + 7)); // 年龄下限
                int right = i; // 年龄上限
                res += right - left - 1; // 可以互发的好友请求数量
            }
        }
        return res;
    }

    private int binarySearch(int[] ages, int target) {
        int l = 0, r = ages.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ages[mid] == target) return mid;
            else if (ages[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return l; // 返回插入位置
    }
} 