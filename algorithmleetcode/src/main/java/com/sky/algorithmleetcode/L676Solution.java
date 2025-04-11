package com.sky.algorithmleetcode;

/*
实现一个带有buildDict, 以及 search方法的魔法字典。 对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。 对于search方
法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。 示例 1:  Input: buildDic
t(["hello", "leetcode"]), Output: Null Input: search("hello"), Output: False Inp
ut: search("hhllo"), Output: True Input: search("hell"), Output: False Input: se
arch("leetcoded"), Output: False  注意:  	你可以假设所有输入都是小写字母 a-z。 	为了便于竞赛，测试所用的数据量很小。
你可以在竞赛结束后，考虑更高效的算法。 	请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多
详情。
*/

 java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L676Solution {
    private Map<Integer, List<String>> dict;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        dict = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            int len = word.length();
            if (!this.dict.containsKey(len)) {
                this.dict.put(len, new ArrayList<>());
            }
            this.dict.get(len).add(word);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        int len = word.length();
        if (!this.dict.containsKey(len)) {
            return false;
        }
        for (String w : this.dict.get(len)) {
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (w.charAt(i) != word.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
} 