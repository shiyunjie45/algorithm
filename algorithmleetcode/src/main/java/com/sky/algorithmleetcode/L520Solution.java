package com.sky.algorithmleetcode;

/*
给定一个单词，你需要判断单词的大写使用是否正确。 我们定义，在以下情况时，单词的大写用法是正确的：  	全部字母都是大写，比如"USA"。 	单词中所有字母都不
是大写，比如"leetcode"。 	如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。  否则，我们定义这个单词没有正确使用大写字母。 示例
 1:  输入: "USA" 输出: True  示例 2:  输入: "FlaG" 输出: False  注意: 输入是由大写和小写拉丁字母组成的非空单词。
*/

 class L520Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }
        if (Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        boolean flag = Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1));
        for (int i = 2; i < n; i++) {
            if (flag && Character.isLowerCase(word.charAt(i))) {
                return false;
            }
            if (!flag && Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
} 