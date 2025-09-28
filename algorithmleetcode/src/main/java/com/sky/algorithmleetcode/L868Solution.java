package com.sky.algorithmleetcode;

/*
给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。  如果没有两个连续的 1，返回 0 。     示例 1： 输入：22 输出
：2 解释： 22 的二进制是 0b10110 。 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。 第一对连续的 1 中，两个 1 之间的距离为 
2 。 第二对连续的 1 中，两个 1 之间的距离为 1 。 答案取两个距离之中最大的，也就是 2 。  示例 2： 输入：5 输出：2 解释： 5 的二进制是
 0b101 。  示例 3： 输入：6 输出：1 解释： 6 的二进制是 0b110 。  示例 4： 输入：8 输出：0 解释： 8 的二进制是 0b100
0 。 在 8 的二进制表示中没有连续的 1，所以返回 0 。    提示：  	1
*/

public class L868Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n); // 将整数转化为字符串
        int maxDistance = 0; // 记录最大距离
        int lastOneIndex = -1; // 记录上一个1的位置
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (lastOneIndex != -1) {
                    maxDistance = Math.max(maxDistance, i - lastOneIndex); // 更新最大距离
                }
                lastOneIndex = i; // 更新上一个1的位置
            }
        }
        return maxDistance;
    }
} 