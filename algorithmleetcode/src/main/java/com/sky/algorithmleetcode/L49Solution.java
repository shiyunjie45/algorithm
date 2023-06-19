package com.sky.algorithmleetcode;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 示例: 输入: ["eat", "tea", "tan", "ate",
 "nat", "bat"] 输出: [  ["ate","eat","tea"],  ["nat","tan"],  ["bat"] ] 说明：  	所有输入
均为小写字母。 	不考虑答案输出的顺序。
*/

import java.util.*;

public class L49Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 定义一个map用于存储结果
        Map<String, List<String>> map = new HashMap<>();
        // 遍历字符串数组
        for (String str : strs) {
            // 将字符串转为字符数组并进行排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // 将排好序的字符数组转为字符串作为key
            String key = new String(charArray);
            // 如果map中不存在该key，则新建一个List保存该key对应的字符串
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将字符串加入到对应的List中
            map.get(key).add(str);
        }
        // 将map中所有的List作为结果返回
        return new ArrayList<>(map.values());
    }
} 