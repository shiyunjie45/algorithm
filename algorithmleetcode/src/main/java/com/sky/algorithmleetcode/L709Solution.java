package com.sky.algorithmleetcode;

/*
实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。   示例 1：  输入: 
"Hello" 输出: "hello" 示例 2：  输入: "here" 输出: "here" 示例 3：  输入: "LOVELY" 输出: "lovely
"
*/

 class L709Solution {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('A' <= arr[i] && arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] - 'A' + 'a');
            }
        }
        return new String(arr);
    }
} 