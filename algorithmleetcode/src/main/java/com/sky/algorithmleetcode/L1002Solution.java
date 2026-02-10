package com.sky.algorithmleetcode;

/*
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 
4 次，则需要在最终答案中包含该字符 3 次。 你可以按任意顺序返回答案。   示例 1： 输入：["bella","label","roller"] 输出：[
"e","l","l"]  示例 2： 输入：["cool","lock","cook"] 输出：["c","o"]    提示：  	1 	1 	A[i][j
] 是小写字母
*/

import java.util.*;

public class L1002Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);

        for (String str : A) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++)
                count[str.charAt(i) - 'a']++;
            for (int i = 0; i < 26; i++)
                freq[i] = Math.min(freq[i], count[i]);
        }

        for (int i = 0; i < 26; i++)
            for (int j = 0; j < freq[i]; j++)
                result.add(String.valueOf((char) ('a' + i)));

        return result;
    }
} 