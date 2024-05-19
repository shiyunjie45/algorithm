package com.sky.algorithmleetcode;

/*
给定两个字符串 s 和 t，判断它们是否是同构的。 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 所有出现的字符都必须用另一个字符替换，同
时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 示例 1: 输入: s = "egg", t = "add" 输出: true  示
例 2: 输入: s = "foo", t = "bar" 输出: false 示例 3: 输入: s = "paper", t = "title" 输出: t
rue 说明: 你可以假设 s 和 t 具有相同的长度。
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class L205Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(); //用于存储字符对应关系的map
        Set<Character> set = new HashSet<>(); //用于存储出现过的字符的set
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar)) { //如果已经有对应关系了
                if (map.get(sChar).equals(tChar)) { //如果对应的字符相等，不用再加对应关系
                    continue;
                } else { //如果对应的字符不相等，说明不符合要求
                    return false;
                }
            } else { //如果还没有对应关系
                if (set.contains(tChar)) { //如果这个字符已经被其他字符映射过，那么就不符合要求
                    return false;
                } else {
                    map.put(sChar, tChar);
                    set.add(tChar);
                }
            }
        }
        return true;
    }
} 