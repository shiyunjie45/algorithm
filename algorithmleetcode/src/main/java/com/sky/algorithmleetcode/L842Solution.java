package com.sky.algorithmleetcode;

/*
给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 形式上，斐波那契式序列是一个非
负整数列表 F，且满足：  	0 ，（也就是说，每个整数都符合 32 位有符号整数类型）； 	F.length >= 3； 	对于所有的0 ，都有 F[i] +
 F[i+1] = F[i+2] 成立。  另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 返回从 S 拆分出来
的所有斐波那契式的序列块，如果不能拆分则返回 []。 示例 1： 输入："123456579" 输出：[123,456,579]  示例 2： 输入: "112
35813" 输出: [1,1,2,3,5,8,13]  示例 3： 输入: "112358130" 输出: [] 解释: 这项任务无法完成。  示例 4： 输
入："0123" 输出：[] 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。  示例 5： 输入: "1101111" 输出: 
[110, 1, 111] 解释: 输出 [11,0,11,11] 也同样被接受。  提示：  	1 	字符串 S 中只含有数字。
*/

 java.util.*;

public class L842Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        dfs(S, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(String s, int start, List<Integer> path, List<Integer> res) {
        if (start == s.length() && path.size() >= 3) {
            res.addAll(path);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String tempStr = s.substring(start, i);
            if (isValid(tempStr)) {
                int temp = Integer.valueOf(tempStr);
                if (path.size() < 2 || temp == path.get(path.size() - 1) + path.get(path.size() - 2)) {
                    path.add(temp);
                    dfs(s, i, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        return Long.valueOf(s) <= Integer.MAX_VALUE;
    }
} 