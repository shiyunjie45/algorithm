package com.sky.algorithmleetcode;

/*
给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。   示
例 1： 输入： A = "ab", B = "ba" 输出： true  示例 2： 输入： A = "ab", B = "ab" 输出： false  示例
 3: 输入： A = "aa", B = "aa" 输出： true  示例 4： 输入： A = "aaaaaaabc", B = "aaaaaaacb" 
输出： true  示例 5： 输入： A = "", B = "aa" 输出： false    提示：  	0 	0 	A 和 B 仅由小写字母构成。
*/

 class L859Solution {
    public boolean buddyStrings(String A, String B) {
        // 如果两个字符串长度不相等，必然无法通过交换得到相等结果，返回false
        if (A.length() != B.length()) {
            return false;
        }

        // 如果两个字符串完全相等，且其中存在重复字母，那么将它们交换得到相等结果，返回true
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char c : A.toCharArray()) {
                if (set.contains(c)) {
                    return true;
                }
                set.add(c);
            }
            return false;
        }

        // 如果两个字符串有且仅有两个字符不同，且这两个字符相互交换后能够得到相等结果，返回true
        int first = -1, second = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
    }
} 