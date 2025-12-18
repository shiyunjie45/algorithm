package com.sky.algorithmleetcode;

/*
给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 
（午夜）开始算起，过得越久，时间越大。 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。   示例 1： 输入：[1,2,3,4] 输出：
"23:41"  示例 2： 输入：[5,5,5,5] 输出：""    提示：  	A.length == 4 	0
*/

 java.util.*;

public class L949Solution {
    public String largestTimeFromDigits(int[] A) {
        List<String> result = new ArrayList<>(); // 存储符合条件的时间字符串
        boolean[] visited = new boolean[A.length]; // 标记每个数字是否已经被使用过
        backtrack(A, "", result, visited); // 回溯求解
        if (result.size() == 0) { // 如果没有符合条件的结果，则返回空字符串
            return "";
        }
        // 将符合条件的时间字符串按照时间大小排序，取最大值
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

    // 回溯求解符合条件的时间字符串
    private void backtrack(int[] A, String currTime, List<String> result, boolean[] visited) {
        if (currTime.length() == 4) { // 如果已经组成了4个数字，则判断是否符合条件
            if (isValidTime(currTime)) {
                result.add(convertToTime(currTime));
            }
            return;
        }
        for (int i = 0; i < A.length; i++) { // 枚举每一个数字
            if (!visited[i]) { // 如果当前数字未被使用过，则继续使用
                visited[i] = true;
                backtrack(A, currTime + A[i], result, visited); // 继续回溯
                visited[i] = false; // 回溯后需要释放当前数字
            }
        }
    }

    // 判断给定的字符串是否符合时间的格式且在0 ~ 23:59之间
    private boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(2));
        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }

    // 将给定的字符串转换成时间的格式
    private String convertToTime(String time) {
        return time.substring(0, 2) + ":" + time.substring(2);
    }
} 