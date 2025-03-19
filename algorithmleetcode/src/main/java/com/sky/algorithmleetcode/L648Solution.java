package com.sky.algorithmleetcode;

/*
在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随
着单词 other(其他)，可以形成新的单词 another(另一个)。 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
如果继承词有许多可以形成它的词根，则用最短的词根替换它。 你需要输出替换之后的句子。   示例： 输入：dict(词典) = ["cat", "bat", "r
at"] sentence(句子) = "the cattle was rattled by the battery" 输出："the cat was rat 
by the bat"    提示：  	输入只包含小写字母。 	1 	1 	1 	1
*/

 java.util.*;

class L648Solution {
    public String replaceWords(List<String> dict, String sentence) {
        // 先将dict中的所有词根排序
        Collections.sort(dict);
        
        // 按空格将sentence分割成单词数组
        String[] words = sentence.split(" ");
        
        // 依次处理每个单词
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean replaced = false; // 标记是否已经替换成功
            // 对于每个单词，找到可能的最短词根
            for (String root : dict) {
                if (word.startsWith(root)) {
                    words[i] = root;
                    replaced = true;
                    break;
                }
            }
            // 如果无法找到词根，则不替换该单词
            if (!replaced) {
                words[i] = word;
            }
        }
        
        // 拼接替换后的单词数组，生成新的句子
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1); // 删除最后一个空格
        return sb.toString();
    }
} 