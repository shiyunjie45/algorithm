package com.sky.algorithmleetcode;

/*
给定一个字符串数组 A，找到以 A 中每个字符串作为子字符串的最短字符串。 我们可以假设 A 中没有字符串是 A 中另一个字符串的子字符串。   示例 1： 输
入：["alex","loves","leetcode"] 输出："alexlovesleetcode" 解释："alex"，"loves"，"leetcode
" 的所有排列都会被接受。 示例 2： 输入：["catg","ctaagt","gcta","ttca","atgcatc"] 输出："gctaagttcat
gcatc"   提示：  	1 	1
*/

 String shortestSuperstring(String[] A) {
    // 预处理字符串数组，去除相同的字符串，按长度由小到大排序
    String[] rest = new String[A.length - 1];
    for (int i = 1; i < A.length; i++) {
        if (A[i].equals(A[i - 1])) {
            A[i] = "";
        } else {
            rest[i - 1] = A[i];
        }
    }
    Arrays.sort(rest, Comparator.comparingInt(String::length)); // 按长度排序
    
    // 拼接字符串
    String result = A[0];
    for (String str : rest) {
        if (str != null && str.length() > 0) {
            result = merge(result, str);
        }
    }
    return result;
}

// 拼接两个字符串，使得 str2 包含 str1，返回最短的字符串
private String merge(String str1, String str2) {
    int maxPrefix = 0; // 所有公共前缀的长度之和
    for (int i = 1; i <= str1.length(); i++) {
        if (str2.endsWith(str1.substring(0, i))) { // 如果存在以 str1 为前缀的字符串，则更新 maxPrefix
            maxPrefix = i;
        }
    }
    return str2 + str1.substring(maxPrefix); // 拼接字符串
} 