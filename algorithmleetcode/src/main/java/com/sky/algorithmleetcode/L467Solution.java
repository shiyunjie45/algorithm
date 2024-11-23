package com.sky.algorithmleetcode;

/*
把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmno
pqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".  现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个
唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。  注意: p 仅由小写的英文字母组成，p 的大小
可能超过 10000。   示例 1:  输入: "a" 输出: 1 解释: 字符串 S 中只有一个"a"子字符。    示例 2:  输入: "cac" 输出
: 2 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.    示例 3:  输入: "zab" 输出: 6 解释: 在字符串 S 中有六
个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
*/

 java.util.HashSet;

public class L467Solution {
    public static int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0) {
            return 0;
        }

        int[] count = new int[26];
        int maxLength = 1; // 包含p.charAt(0)的最长连续子串长度

        count[p.charAt(0) - 'a'] = 1;
        for(int i = 1; i < p.length(); i++) {
            int curChar = p.charAt(i) - 'a';
            int preChar = p.charAt(i - 1) - 'a';
            if(curChar == preChar + 1 || curChar == preChar - 25) { // 连续字符
                maxLength++;
            } else { // 非连续字符
                maxLength = 1;
            }
            count[curChar] = Math.max(count[curChar], maxLength);
        }

        int result = 0;
        for(int i = 0; i < 26; i++) {
            result += count[i];
        }

        return result;
    }

    public static void main(String[] args) {
        // 示例 1
        String p1 = "a";
        System.out.println("示例 1 结果：" + findSubstringInWraproundString(p1)); // 1

        // 示例 2
        String p2 = "cac";
        System.out.println("示例 2 结果：" + findSubstringInWraproundString(p2)); // 2

        // 示例 3
        String p3 = "zab";
        System.out.println("示例 3 结果：" + findSubstringInWraproundString(p3)); // 6
    }
} 