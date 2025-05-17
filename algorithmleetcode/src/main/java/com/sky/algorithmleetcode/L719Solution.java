package com.sky.algorithmleetcode;

/*
给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。 示例 1:  输入： nums = [
1,3,1] k = 1 输出：0 解释： 所有数对如下： (1,3) -> 2 (1,1) -> 0 (3,1) -> 2 因此第 1 个最小距离的数对是 (
1,1)，它们之间的距离为 0。  提示:  	2 . 	0 . 	1 .
*/

 java.util.Arrays;

public class L719Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); //对数组进行排序
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0]; //左右端点初始化
        while (left <= right) {
            int cnt = 0, j = 0, mid = left + (right - left) / 2; //cnt：距离不大于mid的数对的数量，j：记录当前位置前有多少个数对
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) { //统计距离不大于mid的数对数量
                    j++;
                }
                cnt += j - i - 1; //减1是为了避免统计到nums[i]与nums[j]的距离
            }
            if (cnt < k) { //距离不大于mid的数对数量小于k，则第k小的数对距离一定大于mid
                left = mid + 1;
            } else { //距离不大于mid的数对数量大于或等于k，则第k小的数对距离一定小于或等于mid
                right = mid - 1;
            }
        }
        return left;
    }
} 