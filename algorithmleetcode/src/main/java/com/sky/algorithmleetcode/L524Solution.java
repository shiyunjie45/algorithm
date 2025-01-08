package com.sky.algorithmleetcode;

/*
给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。
如果答案不存在，则返回空字符串。 示例 1:  输入: s = "abpcplea", d = ["ale","apple","monkey","plea"] 
输出: "apple"  示例 2:  输入: s = "abpcplea", d = ["a","b","c"] 输出: "a"  说明:  	所有输入的字符
串只包含小写字母。 	字典的大小不会超过 1000。 	所有输入的字符串长度不会超过 1000。
*/

 java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L524Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String str : d) {
            if(isSubsequence(str, s)) {
                if(str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 0)) {
                    result = str;
                }
            }
        }
        return result;
    }
    
    private boolean isSubsequence(String target, String s) {
        int i = 0, j = 0;
        while(i < target.length() && j < s.length()) {
            if(target.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == target.length();
    }
    
    public static void main(String[] args) {
        L524Solution solution = new L524Solution();
        String s = "abpcplea";
        List<String> d = new ArrayList<String>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        String result = solution.findLongestWord(s, d);
        System.out.println(result);
        
        s = "abpcplea";
        d.clear();
        d.add("a");
        d.add("b");
        d.add("c");
        result = solution.findLongestWord(s, d);
        System.out.println(result);
    }
} 