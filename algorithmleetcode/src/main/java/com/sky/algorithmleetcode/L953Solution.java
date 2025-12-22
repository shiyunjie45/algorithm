package com.sky.algorithmleetcode;

/*
某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。 给定一组用外星语书写的单词 words，以及其字母
表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。   示例 1： 输入：words = ["hell
o","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz" 输出：true 解释：在该语言的字母表中，'h' 位于
 'l' 之前，所以单词序列是按字典序排列的。 示例 2： 输入：words = ["word","world","row"], order = "worlda
bcefghijkmnpqstuvxyz" 输出：false 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]
，因此单词序列不是按字典序排列的。 示例 3： 输入：words = ["apple","app"], order = "abcdefghijklmnopqrs
tuvwxyz" 输出：false 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 
'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。    提示：  	1 	1 	order.length == 26 	在 
words[i] 和 order 中的所有字符都是英文小写字母。
*/

 class L953Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            int pos = order.charAt(i) - 'a'; // 获取字符在 order 中的位置
            index[pos] = i; // 该字符在当前排序中的位置为 i
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len1 = word1.length();
            int len2 = word2.length();

            for (int j = 0; j < len1 && j < len2; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    int pos1 = c1 - 'a';
                    int pos2 = c2 - 'a';
                    if (index[pos1] > index[pos2]) {
                        return false;
                    } else {
                        break;
                    }
                }

                // 如果当前位置相同，继续判断下一个位置
                if (j == len2 - 1 && len1 > len2) {
                    return false;
                }
            }
        }

        return true;
    }
} 