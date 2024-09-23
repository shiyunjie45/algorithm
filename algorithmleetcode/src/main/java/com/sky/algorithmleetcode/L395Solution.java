package com.sky.algorithmleetcode;

/*
找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 示例 1:  输入: s = "aaab
b", k = 3 输出: 3 最长子串为 "aaa" ，其中 'a' 重复了 3 次。  示例 2:  输入: s = "ababbc", k = 2 输出:
 5 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
*/

 class L395Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int maxLen = 0;
        int[] count = new int[26];
        int uniqueCount = countUnique(s);
        for (int numUniqueTarget = 1; numUniqueTarget <= uniqueCount; numUniqueTarget++) {
            Arrays.fill(count, 0);
            int windowStart = 0;
            int windowEnd = 0;
            int numUnique = 0;
            int numNoLessThanK = 0;
            while (windowEnd < s.length()) {
                if (numUnique <= numUniqueTarget) {
                    int index = s.charAt(windowEnd) - 'a';
                    if (count[index] == 0) {
                        numUnique++;
                    }
                    count[index]++;
                    if (count[index] == k) {
                        numNoLessThanK++;
                    }
                    windowEnd++;
                } else {
                    int index = s.charAt(windowStart) - 'a';
                    if (count[index] == k) {
                        numNoLessThanK--;
                    }
                    count[index]--;
                    if (count[index] == 0) {
                        numUnique--;
                    }
                    windowStart++;
                }
                if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
                    maxLen = Math.max(maxLen, windowEnd - windowStart);
                }
            }
        }
        return maxLen;
    }

    private int countUnique(String s) {
        boolean[] map = new boolean[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                map[s.charAt(i) - 'a'] = true;
                count++;
            }
        }
        return count;
    }
} 