package com.sky.algorithmleetcode;

/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 字符串只包含小写英文字母，并且字符串 s 和 p
 的长度都不超过 20100。 说明：  	字母异位词指字母相同，但排列不同的字符串。 	不考虑答案输出的顺序。  示例 1:  输入: s: "cbaebab
acd" p: "abc" 输出: [0, 6] 解释: 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。 起始索引等于 6 的子串是
 "bac", 它是 "abc" 的字母异位词。   示例 2:  输入: s: "abab" p: "ab" 输出: [0, 1, 2] 解释: 起始索引等于
 0 的子串是 "ab", 它是 "ab" 的字母异位词。 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。 起始索引等于 2 的子串是 
"ab", 它是 "ab" 的字母异位词。
*/

 java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L438Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //如果s中的字符也在p中存在则count--表示匹配的字符种类数减少了
            if (map[s.charAt(right) - 'a']-- > 0) count--;
            right++;
            //count等于0说明窗口内的所有字符都在p中出现过了，那么此时left指向的就是满足题目要求的子串的首位置
            if (count == 0) res.add(left);
            //右移左指针的过程
            if (right - left == p.length() && map[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return res;
    }
} 