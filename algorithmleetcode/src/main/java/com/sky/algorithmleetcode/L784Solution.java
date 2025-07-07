package com.sky.algorithmleetcode;

/*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。  示例: 输入: S = "a1b2" 输出
: ["a1b2", "a1B2", "A1b2", "A1B2"] 输入: S = "3z4" 输出: ["3z4", "3Z4"] 输入: S = "123
45" 输出: ["12345"]  注意：  	S 的长度不超过12。 	S 仅由数字和字母组成。
*/

 java.util.ArrayList;
import java.util.List;

public class L784Solution {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s.toCharArray(), 0);
        return result;
    }

    private void backtrack(List<String> result, char[] s, int index) {
        if (index == s.length) {
            result.add(new String(s));
            return;
        }
        if (s[index] >= '0' && s[index] <= '9') { // 数字
            backtrack(result, s, index + 1);
        } else { // 字母
            // 转换为小写字母
            s[index] = Character.toLowerCase(s[index]);
            backtrack(result, s, index + 1);
            // 转换为大写字母
            s[index] = Character.toUpperCase(s[index]);
            backtrack(result, s, index + 1);
        }
    }

    public static void main(String[] args) {
        L784Solution solution = new L784Solution();

        String s1 = "a1b2";
        System.out.println(solution.letterCasePermutation(s1)); // [a1b2, a1B2, A1b2, A1B2]

        String s2 = "3z4";
        System.out.println(solution.letterCasePermutation(s2)); // [3z4, 3Z4]

        String s3 = "12345";
        System.out.println(solution.letterCasePermutation(s3)); // [12345]
    }
} 