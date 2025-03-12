package com.sky.algorithmleetcode;

/*
一条包含字母 A-Z 的消息通过以下的方式进行了编码： 'A' -> 1 'B' -> 2 ... 'Z' -> 26  除了上述的条件以外，现在加密字符串可以
包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。 同时，由于结果值可能会相当的
大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出） 示例 1 : 输入: "*" 输出: 9 解释: 加密的信息可以被解密为: "A
", "B", "C", "D", "E", "F", "G", "H", "I".  示例 2 : 输入: "1*" 输出: 9 + 9 = 18（翻译者标注
：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）  说明 :  	输入的字符串长度范围是 [1, 105]。 	输入的字符串只会包含字符
 '*' 和 数字'0' - '9'。
*/

 class L639Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int mod = 1000000007;
        long[] dp = new long[len + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        char prev = s.charAt(0);
        for (int i = 2; i <= len; i++) {
            char c = s.charAt(i - 1);
            if (c == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if (c > '0') {
                dp[i] += dp[i - 1];
            }
            if (prev == '*') {
                if (c == '*') {
                    dp[i] += 15 * dp[i - 2];
                } else if (c <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (prev == '1' || prev == '2') {
                if (c == '*') {
                    if (prev == '1') {
                        dp[i] += 9 * dp[i - 2];
                    } else {
                        dp[i] += 6 * dp[i - 2];
                    }
                } else if ((prev - '0') * 10 + (c - '0') <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= mod;
            prev = c;
        }
        return (int) dp[len];
    }
} 