package com.sky.algorithmleetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

 算法的时间复杂度应该为 O(log (m+n)) 。

 示例 1：

 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2
 示例 2：

 输入：nums1 = [1,2], nums2 = [3,4]
 输出：2.50000
 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 提示：

 nums1.length == m
 nums2.length == n
 0 <= m <= 1000
 0 <= n <= 1000
 1 <= m + n <= 2000
 -106 <= nums1[i], nums2[i] <= 106
 Related Topics
 数组
 二分查找
 分治

 👍 6453
 👎 0

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
        String str = "abcdefghijklmnopqrstuvwxyz0.123456789/*-+~!@#$%^&*()_+";
        Utils utils = new Utils();
        System.out.println(lengthOfLongestSubstring1(str,0));
        utils.printTimeConsuming();

        utils.setStartTime();
        System.out.println(lengthOfLongestSubstring2(str));
        utils.printTimeConsuming();

        utils.setStartTime();
        System.out.println(lengthOfLongestSubstring3(str));
        utils.printTimeConsuming();
    }
}
