package com.sky.algorithmleetcode;

/*
给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai 31 。 找到 ai 和aj 最大的异或 (XOR) 运算结果，其
中0 ≤ i,  j n 。 你能在O(n)的时间解决这个问题吗？ 示例:  输入: [3, 10, 5, 25, 2, 8] 输出: 28 解释: 最大的结果
是 5 ^ 25 = 28.
*/

 class L421Solution {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            insert(root, num);
        }
        int maxXOR = 0;
        for (int num : nums) {
            maxXOR = Math.max(maxXOR, findMaxXOR(root, num));
        }
        return maxXOR;
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private int findMaxXOR(TrieNode root, int num) {
        TrieNode node = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int complement = bit == 0 ? 1 : 0;
            if (node.children[complement] != null) {
                maxXOR += (1 << i);
                node = node.children[complement];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }

} 