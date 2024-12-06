package com.sky.algorithmleetcode;

/*
有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。 给你一个数字 K，请你重新格式化字符串，除
了第一个分组以外，每个分组要包含 K 个字符；而第一个分组中，至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字
母。 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。   示例 1： 输入：S = "5F3Z-2e-9-w", K = 4 输出："5F3Z-
2E9W" 解释：字符串 S 被分成了两个部分，每部分 4 个字符；    注意，两个额外的破折号需要删掉。  示例 2： 输入：S = "2-5g-3-J",
 K = 2 输出："2-5G-3J" 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
    提示:  	S 的长度可能很长，请按需分配大小。K 为正整数。 	S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-' 	S 非空
*/

 class L482Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "").toUpperCase(); //去掉破折号，将字符串转化为大写字母
        int len = S.length();
        if (len <= K) {
            return S; //若字符串长度小于等于K，则不需要分组，直接返回字符串
        }
        int firstSegLen = len % K; //第一组长度
        StringBuilder sb = new StringBuilder();
        if (firstSegLen != 0) {
            sb.append(S.substring(0, firstSegLen)).append("-"); //加入第一组
        }
        for (int i = firstSegLen; i < len; i += K) { //循环加入剩余分组
            sb.append(S.substring(i, i + K)).append("-");
        }
        sb.deleteCharAt(sb.length() - 1); //删除最后一个分隔符
        return sb.toString();
    }
} 