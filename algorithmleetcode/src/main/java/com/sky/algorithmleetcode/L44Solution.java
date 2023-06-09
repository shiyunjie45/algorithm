package com.sky.algorithmleetcode;

/*
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 '?' 可以匹配任何单个字符。 '*' 可以匹配任意字符串（
包括空字符串）。  两个字符串完全匹配才算匹配成功。 说明:  	s 可能为空，且只包含从 a-z 的小写字母。 	p 可能为空，且只包含从 a-z 的小写字母
，以及字符 ? 和 *。  示例 1: 输入: s = "aa" p = "a" 输出: false 解释: "a" 无法匹配 "aa" 整个字符串。 示例 2
: 输入: s = "aa" p = "*" 输出: true 解释: '*' 可以匹配任意字符串。  示例 3: 输入: s = "cb" p = "?a" 
输出: false 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。  示例 4: 输入: s = "adceb" p = "*a*b"
 输出: true 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".  示例 5: 输入: s = "acdcb" p 
= "a*c?b" 输入: false
*/

 class L44Solution {
    public boolean isMatch(String s, String p) {
        //定义二维数组，用来记录匹配结果，默认全部赋值为false
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //当s和p都为空字符串时，匹配结果为true
        dp[0][0] = true;
        //先处理第一列情况，因为第一列最多只有一个'*'
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 1];
            }
        }
        //开始处理剩余行列的情况
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                //下面的情况有几种可能
                //1. s[i]和p[j]匹配成功，或者p[j]是'?'
                //2. p[j]是'*'，此时有两种情况: a.用'*'匹配空字符串; b.用'*'匹配一个或多个字符
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*'){
                    //通过递推公式计算dp[i][j]的值
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else{
                    dp[i][j] = false;
                }
            }
        }
        //返回最终结果
        return dp[s.length()][p.length()];
    }
} 