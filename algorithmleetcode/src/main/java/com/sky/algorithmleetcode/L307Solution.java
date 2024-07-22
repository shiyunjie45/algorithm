package com.sky.algorithmleetcode;

/*
给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。 update(i, val) 函数可以通
过将下标为 i 的数值更新为 val，从而对数列进行修改。 示例: Given nums = [1, 3, 5] sumRange(0, 2) -> 9 upd
ate(1, 2) sumRange(0, 2) -> 8  说明:  	数组仅可以在 update 函数下进行修改。 	你可以假设 update 函数与 su
mRange 函数的调用次数是均匀分布的。
*/

 class L307Solution {
    
    int[] nums;
    int[] tree;
    int n;

    public L307Solution(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            updateTree(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        updateTree(i, diff);
    }
    
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
    
    private void updateTree(int i, int diff) {
        i++;
        while (i <= n) {
            tree[i] += diff;
            i += lowbit(i);
        }
    }
    
    private int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }
    
    private int lowbit(int i) {
        return i & (-i);
    }
} 