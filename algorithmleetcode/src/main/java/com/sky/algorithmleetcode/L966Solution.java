package com.sky.algorithmleetcode;

/*
在给定单词列表 wordlist 的情况下，我们希望实现一个拼写检查器，将查询单词转换为正确的单词。 对于给定的查询单词 query，拼写检查器将会处理两类拼写
错误：  	大小写：如果查询匹配单词列表中的某个单词（不区分大小写），则返回的正确单词与单词列表中的大小写相同。 	 		例如：wordlist = ["yel
low"], query = "YellOw": correct = "yellow" 		例如：wordlist = ["Yellow"], query = 
"yellow": correct = "Yellow" 		例如：wordlist = ["yellow"], query = "yellow": corre
ct = "yellow" 	 	 	元音错误：如果在将查询单词中的元音（‘a’、‘e’、‘i’、‘o’、‘u’）分别替换为任何元音后，能与单词列表中的单词匹配
（不区分大小写），则返回的正确单词与单词列表中的匹配项大小写相同。 	 		例如：wordlist = ["YellOw"], query = "yollow"
: correct = "YellOw" 		例如：wordlist = ["YellOw"], query = "yeellow": correct = ""
 （无匹配项） 		例如：wordlist = ["YellOw"], query = "yllw": correct = "" （无匹配项） 	 	  此外，
拼写检查器还按照以下优先级规则操作：  	当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。 	当查询匹配到大小写问题的单词时，您应该返回单
词列表中的第一个这样的匹配项。 	当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。 	如果该查询在单词列表中没有匹配项，则应返回空字符串
。  给出一些查询 queries，返回一个单词列表 answer，其中 answer[i] 是由查询 query = queries[i] 得到的正确单词。 
  示例： 输入：wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiT
e","Hare","HARE","Hear","hear","keti","keet","keto"] 输出：["kite","KiTe","KiTe","H
are","hare","","","KiTe","","KiTe"]   提示：  	1 	1 	1 	1 	wordlist 和 queries 中的所有字
符串仅由英文字母组成。
*/

 java.util.*;

class L966Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseCache = new HashMap<>();
        Map<String, String> vowelCache = new HashMap<>();
        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (words.contains(query)) {
                result[i] = query;
                continue;
            }

            String queryLowerCase = query.toLowerCase();
            if (caseCache.containsKey(queryLowerCase)) {
                result[i] = caseCache.get(queryLowerCase);
                continue;
            }

            String queryNoVowel = removeVowel(queryLowerCase);
            if (vowelCache.containsKey(queryNoVowel)) {
                result[i] = vowelCache.get(queryNoVowel);
                continue;
            }

            for (String word : words) {
                if (query.equalsIgnoreCase(word)) {
                    result[i] = word;
                    caseCache.put(queryLowerCase, word);
                    break;
                }

                String wordLowerCase = word.toLowerCase();
                if (queryLowerCase.equals(wordLowerCase)) {
                    result[i] = word;
                    caseCache.put(queryLowerCase, word);
                    break;
                }

                String wordNoVowel = removeVowel(wordLowerCase);
                if (queryNoVowel.equals(wordNoVowel)) {
                    result[i] = word;
                    vowelCache.put(queryNoVowel, word);
                    break;
                }
            }
        }

        return result;
    }

    private String removeVowel(String string) {
        return string.replaceAll("[aeiou]", "_");
    }
} 