package com.sky.algorithmleetcode;

import com.sky.algorithmleetcode.utils.Utils;

import java.util.*;

/**
 *给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * Related Topics
 * 数组
 * 哈希表
 */
class L1Solution {
    public static int[] twoSum1(int[] nums,int target){
    for (int i = 0; i < nums.length; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                if (nums[i]+nums[i1]==target){
                    return new int[]{i,i1};
                }
            }
        }
        return new int[]{};
    }

    static Map<Integer, Integer> map = new HashMap<>();
    public static int[] twoSum2(int[] nums, int target) {
        map.clear();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
        // 生成随机数组和目标值
        int length = 6000;
        int[] numArr = Utils.generateRandomArray(length, 0, Integer.MAX_VALUE);
        List<Integer> targetList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numArr.length; i++) {
            targetList.add(random.nextInt(Integer.MAX_VALUE));
        }
        Utils utils = new Utils();
        for (int i = 0; i < targetList.size(); i++) {
            twoSum1(numArr,targetList.get(i));
        }
        utils.printTimeConsuming();
        for (int i = 0; i < targetList.size(); i++) {
            twoSum2(numArr,targetList.get(i));
        }
        utils.printTimeConsuming();
    }
}