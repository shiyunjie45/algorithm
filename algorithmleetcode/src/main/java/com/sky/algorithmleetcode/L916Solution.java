package com.sky.algorithmleetcode;

/*
我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子
集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 
中的单词 a 是通用的。 你可以按任意顺序以列表形式返回 A 中所有的通用单词。     示例 1： 输入：A = ["amazon","apple","fac
ebook","google","leetcode"], B = ["e","o"] 输出：["facebook","google","leetcode"]  
示例 2： 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"] 输出
：["apple","google","leetcode"]  示例 3： 输入：A = ["amazon","apple","facebook","googl
e","leetcode"], B = ["e","oo"] 输出：["facebook","google"]  示例 4： 输入：A = ["amazon",
"apple","facebook","google","leetcode"], B = ["lo","eo"] 输出：["google","leetcode"
]  示例 5： 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc
","ceo"] 输出：["facebook","leetcode"]    提示：  	1 	1 	A[i] 和 B[i] 只由小写字母组成。 	A[i] 中
所有的单词都是独一无二的，也就是说不存在 i != j 使得 A[i] == A[j]。
*/

 java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L916Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] maxTimes = new int[26]; // 统计 B 中每个字母出现的最大次数
        for (String b : B) {
            int[] times = new int[26];
            for (int i = 0; i < b.length(); i++) {
                times[b.charAt(i) - 'a']++;
                maxTimes[b.charAt(i) - 'a'] = Math.max(maxTimes[b.charAt(i) - 'a'], times[b.charAt(i) - 'a']);
            }
        }
        for (String a : A) {
            int[] times = new int[26];
            for (int i = 0; i < a.length(); i++) {
                times[a.charAt(i) - 'a']++;
            }
            boolean isUniversal = true; // 判断 a 是否是通用单词
            for (int i = 0; i < 26; i++) {
                if (maxTimes[i] > times[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(a);
            }
        }
        return result;
    }
} 