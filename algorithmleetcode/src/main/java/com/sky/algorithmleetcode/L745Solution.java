package com.sky.algorithmleetcode;

/*
给定多个 words，words[i] 的权重为 i 。 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, St
ring suffix)。这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。 例子:  输入: WordF
ilter(["apple"]) WordFilter.f("a", "e") // 返回 0 WordFilter.f("b", "") // 返回 -1  
注意:  	words的长度在[1, 15000]之间。 	对于每个测试用例，最多会有words.length次对WordFilter.f的调用。 	words
[i]的长度在[1, 10]之间。 	prefix, suffix的长度在[0, 10]之前。 	words[i]和prefix, suffix只包含小写字母。
*/

 java.util.HashMap;
import java.util.Map;

public class L745Solution {

    private Map<String, Integer> map;

    public L745Solution(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                for (int k = 0; k <= word.length(); k++) {
                    String key = word.substring(0, j) + "#" + word.substring(word.length() - k);
                    map.put(key, i);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "#" + suffix;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }
} 