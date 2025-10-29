package com.sky.algorithmleetcode;

/*
给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。 在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在
字符串的末尾。 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。   示例 1： 输入：S = "cba", K = 1 输出："acb" 解
释： 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。 
 示例 2： 输入：S = "baaca", K = 3 输出："aaabc" 解释： 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aaca
b”。 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。    提示：  	1 	S 只由小写字母组成。
*/

 java.util.Arrays;

public class L899Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        } else {
            String res = s;
            for (int i = 1; i < s.length(); i++) {
                String cur = s.substring(i) + s.substring(0, i);
                if (cur.compareTo(res) < 0) {
                    res = cur;
                }
            }
            return res;
        }
    }
} 