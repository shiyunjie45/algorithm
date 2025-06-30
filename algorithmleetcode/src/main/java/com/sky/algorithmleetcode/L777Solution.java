package com.sky.algorithmleetcode;

/*
在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用
一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回Tru
e。   示例 : 输入: start = "RXXLRXRXL", end = "XRLXXRRLX" 输出: True 解释: 我们可以通过以下几步将sta
rt转换成end: RXXLRXRXL -> XRXLRXRXL -> XRLXRXRXL -> XRLXXRRXL -> XRLXXRRLX    提示：  
	1 。 	start和end中的字符串仅限于'L', 'R'和'X'。
*/

 class L777Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        int len = start.length();
        while (p1 < len && p2 < len) {
            while (p1 < len && start.charAt(p1) == 'X') {
                p1++;
            }
            while (p2 < len && end.charAt(p2) == 'X') {
                p2++;
            }
            if (p1 == len && p2 == len) {
                return true;
            }
            if (p1 == len || p2 == len) {
                return false;
            }
            if (start.charAt(p1) != end.charAt(p2)) {
                return false;
            }
            if (start.charAt(p1) == 'L' && p1 < p2) {
                return false;
            }
            if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }
} 