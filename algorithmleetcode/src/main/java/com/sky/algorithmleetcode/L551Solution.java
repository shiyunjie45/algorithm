package com.sky.algorithmleetcode;

/*
给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：  	'A' : Absent，缺勤 	'L' : Late，迟到 	'P' : Prese
nt，到场  如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 你需要根据这个学生的出勤记录判断他是否
会被奖赏。 示例 1: 输入: "PPALLP" 输出: True  示例 2: 输入: "PPALLL" 输出: False
*/

 class L551Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0; // 缺勤次数
        int lateConsecutiveCount = 0; // 连续迟到次数

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'A') {
                absentCount++;
                if(absentCount > 1) {
                    return false;
                }
                lateConsecutiveCount = 0; // 缺勤次数超过1，连续迟到次数清零
            } else if(c == 'L') {
                lateConsecutiveCount++;
                if(lateConsecutiveCount > 2) {
                    return false;
                }
            } else { // P，到场
                lateConsecutiveCount = 0; // 到场，连续迟到次数清零
            }
        }
        return true;
    }
} 