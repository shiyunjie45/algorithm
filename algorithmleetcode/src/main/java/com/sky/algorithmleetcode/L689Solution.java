package com.sky.algorithmleetcode;

/*
给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。 每个子数组的长度为k，我们要使这3*k个项的和最大化。 返回每个区间起始索引的列表（索引从
 0 开始）。如果有多个结果，返回字典序最小的一个。 示例:  输入: [1,2,1,2,6,7,5,1], 2 输出: [0, 3, 5] 解释: 子数组 [
1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。 我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
  注意:  	nums.length的范围在[1, 20000]之间。 	nums[i]的范围在[1, 65535]之间。 	k的范围在[1, floor(n
ums.length / 3)]之间。
*/

 java.util.ArrayList;
import java.util.List;

public class L689Solution {
    public List<Integer> maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] sums = new int[nums.length + 1];
        int[] posLeft = new int[nums.length];
        int[] posRight = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = k, maxLeft = sums[k] - sums[0]; i < nums.length; i++) {
            if (sums[i + 1] - sums[i + 1 - k] > maxLeft) {
                maxLeft = sums[i + 1] - sums[i + 1 - k];
                posLeft[i] = i + 1 - k;
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }
        for (int i = nums.length - k - 1, maxRight = sums[nums.length] - sums[nums.length - k]; i >= 0; i--) {
            if (sums[i + k] - sums[i] >= maxRight) {
                maxRight = sums[i + k] - sums[i];
                posRight[i] = i;
            } else {
                posRight[i] = posRight[i + 1];
            }
        }
        int maxSum = 0;
        for (int i = k; i <= nums.length - 2 * k; i++) {
            int leftIdx = posLeft[i - 1], rightIdx = posRight[i + k];
            int sum = (sums[i + k] - sums[i]) + (sums[leftIdx + k] - sums[leftIdx]) + (sums[rightIdx + k] - sums[rightIdx]);
            if (sum > maxSum) {
                maxSum = sum;
                res.clear();
                res.add(leftIdx);
                res.add(i);
                res.add(rightIdx);
            }
        }
        return res;
    }
} 