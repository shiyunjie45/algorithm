package com.sky.algorithmleetcode;

/*
给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵
循如下规则：  	每次转换只能改变一个字母。 	转换过程中的中间单词必须是字典中的单词。  说明:  	如果不存在这样的转换序列，返回一个空列表。 	所有单词具
有相同的长度。 	所有单词只由小写字母组成。 	字典中不存在重复的单词。 	你可以假设 beginWord 和 endWord 是非空的，且二者不相同。  示例
 1: 输入: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
"log","cog"] 输出: [  ["hit","hot","dot","dog","cog"],   ["hit","hot","lot","log",
"cog"] ]  示例 2: 输入: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","d
og","lot","log"] 输出: [] 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class L126Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList); // 将wordList转化成set, 利于判断元素是否存在
        if (!dict.contains(endWord)) { // 如果结束单词不在dict中，说明不能转换，返回空list
            return res;
        }
        // 利用BFS找到最短转换序列
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        dict.remove(beginWord); // 将beginWord从dict中删除，避免重复搜索

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Set<String> visitedLevel = new HashSet<>(); // 这个set记录一下当前层已经访问的元素，避免重复访问
            for (int i = 0; i < levelSize; i++) {
                List<String> p = queue.poll();
                String last = p.get(p.size() - 1);
                List<String> neighbors = getNeighbors(last, dict);
                for (String neighbor : neighbors) {
                    if (visitedLevel.contains(neighbor)) continue; 
                    List<String> tmp = new ArrayList<>(p);
                    tmp.add(neighbor); // 将当前路径加入到tmp中
                    if (neighbor.equals(endWord)) { 
                        res.add(tmp); // 如果找到了endWord，将这个路径加入到结果中
                    } else {
                        queue.add(tmp);
                        visitedLevel.add(neighbor); // 将当前层已经访问的元素加入到visitedLevel中，避免重复访问
                    }
                }
            }
            dict.removeAll(visitedLevel); // 将visitedLevel去除元素，保证上一层访问过的元素不再访问
        }
        return res;
    }

    /**
     * 获取一个单词的所有可能的变换
     */
    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue; // 如果当前变换字符等于原字符，则跳过
                arr[i] = c;
                String neighbor = new String(arr);
                if (dict.contains(neighbor)) {
                    res.add(neighbor); // 如果字典中包含变换后的字符，则加入可以变换的邻居
                }
            }
            arr[i] = old; // 将字符变换回来
        }
        return res;
    }
} 