package com.sky.algorithmleetcode;

/*
如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。 给定两个字母异
位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。   示例 1： 输入：A = "ab", B = "ba" 输出：1  示例 2： 输入：A =
 "abc", B = "bca" 输出：2  示例 3： 输入：A = "abac", B = "baca" 输出：2  示例 4： 输入：A = "aabc
", B = "abca" 输出：2   提示：  	1 	A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
*/

 java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L854Solution {

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        int N = A.length();
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(A);
        seen.add(A);

        int res = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                String s = queue.poll();
                if (s.equals(B)) {
                    return res;
                }
                int i = 0;
                while (s.charAt(i) == B.charAt(i)) {
                    i++;
                }
                for (int j = i + 1; j < N; j++) {
                    if (s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j)) {
                        continue;
                    }
                    String temp = swap(s, i, j);
                    if (seen.add(temp)) {
                        queue.offer(temp);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
} 