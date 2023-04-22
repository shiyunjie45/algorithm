package com.sky.algorithmleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 提示：

 0 <= s.length <= 5 * 104
 s 由英文字母、数字、符号和空格组成
 Related Topics
 哈希表
 字符串
 滑动窗口

 */
public class L3Solution {

    public static int lengthOfLongestSubstring1(String str,int preLen){
        HashSet hashSet=new HashSet<>();
        int len = 0;
        if(preLen>str.length()){
            return preLen;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!hashSet.contains(str.charAt(i))){
                len++;
                hashSet.add(str.charAt(i));
                if(len>preLen){
                    preLen=len;
                }
            }else {
                if(len>preLen){
                    preLen=len;
                } else if (str.length()<=1) {
                    return preLen;
                }
                return lengthOfLongestSubstring1(str.substring(1,str.length()),preLen);
            }
        }
        return preLen;
    }

    public static int lengthOfLongestSubstring2(String str){
        int length = str.length();
        int maxLength = 0;
        int x = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (x < length) {
            if(length-x>maxLength){
                for (int i = x; i < length; i++) {
                    char ch = str.charAt(i);
                    if (map.containsKey(ch)) {
                        if (map.size() > maxLength) {
                            maxLength = map.size();
                        }
                        x = map.get(ch) + 1;
                        map.clear();
                        break;
                    }
                    map.put(ch, i);
                }
            }else {
                break;
            }
        }

        return maxLength;
    }
    //
    public static int lengthOfLongestSubstring3(String str){
        int i = 0 ;
        int left = 0 ;
        //用来记录字符串s中最长的无重复子串的长度
        int maxlength = 0 ;
        //用来记录当前无重复子串的长度
        int arrlength = 0;
        //简单来说就是找字符串中出现重复的最近的一个
        while(i<str.length()) {
            //flag用来记录当前位置字符，从当前子串开始位置到第i个字符的位置这一段中第一次出现该字符的位置
            int flag = str.indexOf(str.charAt(i),left);
            //flag<i说明当前子串中存在与该处字符重复的字符
            if(flag<i) {
                if(arrlength>maxlength) {
                    maxlength = arrlength ;
                }
                //无重复子串的起始位置就是从重复字符的下一个字符的位置（即flag+1）到当前位置（即i）
                arrlength = i-flag-1;
                left = flag+1;
            }
            arrlength++;
            i++;
        }
        //返回最长子串的长度
        return arrlength>maxlength?arrlength:maxlength;
    }

    public static void main(String[] args){
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            //生成随机字符串,可能重复
            strings.add(Utils.generateRandomString(i));
            //生成不重复长度字符串
            strings.add(Utils.generateRandomNonRepeatingString(i));
        }
        Utils utils = new Utils();
        //方法1使用了递归的方法,次数多了以后会报错
//        for (int i = 0; i < strings.size(); i++) {
//            lengthOfLongestSubstring1(strings.get(i),0);
//        }
//        utils.printTimeConsuming();

        for (int i = 0; i < strings.size(); i++) {
            lengthOfLongestSubstring2(strings.get(i));
        }
        utils.printTimeConsuming();

        for (int i = 0; i < strings.size(); i++) {
            lengthOfLongestSubstring3(strings.get(i));
        }
        utils.printTimeConsuming();
    }
}
