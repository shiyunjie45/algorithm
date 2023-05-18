package com.sky.algorithmleetcode;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。  示例: 输入："2
3" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].  说明: 尽管上面的答案是按字典序排
列的，但是你可以任意选择答案输出的顺序。
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        dfs(digits, map, 0, sb, res);
        return res;
    }

    private void dfs(String digits, Map<Character, String> map, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, map, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
} 