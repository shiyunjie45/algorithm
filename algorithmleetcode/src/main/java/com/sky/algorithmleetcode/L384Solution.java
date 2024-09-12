package com.sky.algorithmleetcode;

/*
打乱一个没有重复元素的数组。   示例: // 以数字集合 1, 2 和 3 初始化数组。 int[] nums = {1,2,3}; Solution sol
ution = new Solution(nums); // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。 soluti
on.shuffle(); // 重设数组到它的初始状态[1,2,3]。 solution.reset(); // 随机返回数组[1,2,3]打乱后的结果。 s
olution.shuffle();
*/

import java.util.Random;

public class L384Solution {
    private int[] original;
    private int[] array;
    private Random random;

    public L384Solution(int[] nums) {
        original = nums;
        array = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(array, i, j);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
} 