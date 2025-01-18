package com.sky.algorithmleetcode;

/*
给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。  示例 1： 输入: ["23:59","00:00"] 输
出: 1  备注:  	列表中时间数在 2~20000 之间。 	每个时间取值在 00:00~23:59 之间。
*/

 java.util.*;

class L539Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) return 0; // 超过一天的时间点，最小时间差一定为0
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = convertToMinutes(timePoints.get(i)); // 转换成分钟表示的时间点
        }
        Arrays.sort(times);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int diff = times[(i + 1) % n] - times[i]; // 计算当前时间点和下一个时间点的时间差
            if (diff < 0) diff += 1440; // 当跨越了一天时，需要加上1440分钟
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    private int convertToMinutes(String s) {
        String[] parts = s.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
} 