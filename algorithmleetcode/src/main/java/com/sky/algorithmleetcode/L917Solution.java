package com.sky.algorithmleetcode;

/*
给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。     示例 1： 输入："ab-cd" 输出："d
c-ba"  示例 2： 输入："a-bC-dEf-ghIj" 输出："j-Ih-gfE-dCba"  示例 3： 输入："Test1ng-Leet=code-
Q!" 输出："Qedo1ct-eeLg=ntse-T!"    提示：  	S.length 	33   	S 中不包含 \ or "
*/

 class L917Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int l = 0, r = S.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(arr[l])) {
                l++;
            }
            while (l < r && !Character.isLetter(arr[r])) {
                r--;
            }
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
        return new String(arr);
    }
} 