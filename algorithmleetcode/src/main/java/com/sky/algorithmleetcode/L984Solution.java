package com.sky.algorithmleetcode;

/*
给定两个整数 A 和 B，返回任意字符串 S，要求满足：  	S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母； 	子串 'a
aa' 没有出现在 S 中； 	子串 'bbb' 没有出现在 S 中。    示例 1： 输入：A = 1, B = 2 输出："abb" 解释："abb", 
"bab" 和 "bba" 都是正确答案。  示例 2： 输入：A = 4, B = 1 输出："aabaa"   提示：  	0 	0 	对于给定的 A 和 
B，保证存在满足要求的 S。
*/

 class L984Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        char a = 'a';
        char b = 'b';
        int countA = A;
        int countB = B;
        
        if (A < B) {
            a = 'b';
            b = 'a';
            countA = B;
            countB = A;
        }
        
        while (countA > 0 || countB > 0) {
            if (countA > 0) {
                sb.append(a);
                countA--;
            }
            if (countA > countB) {
                sb.append(a);
                countA--;
            }
            if (countB > 0) {
                sb.append(b);
                countB--;
            }
        }
        
        for (int i = 2; i < sb.length(); i++) {
            if (sb.charAt(i - 2) == sb.charAt(i - 1) && sb.charAt(i - 1) == sb.charAt(i)) {
                if (sb.charAt(i - 1) == 'a') {
                    sb.deleteCharAt(i);
                    countA++;
                } else {
                    sb.deleteCharAt(i);
                    countB++;
                }
            }
        }
        
        while (countA > 0 || countB > 0) {
            if (countA > 0) {
                sb.insert(0, a);
                countA--;
            }
            if (countB > 0) {
                sb.insert(0, b);
                countB--;
            }
        }
        
        return sb.toString();
    }
} 