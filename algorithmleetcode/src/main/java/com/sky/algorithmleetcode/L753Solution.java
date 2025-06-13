package com.sky.algorithmleetcode;

/*
有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。 你可以随意输入密码，保险箱会自动记住
最后 n 位输入，如果匹配，则能够打开保险箱。 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符. 请返回一个
能打开保险箱的最短字符串。   示例1: 输入: n = 1, k = 2 输出: "01" 说明: "10"也可以打开保险箱。    示例2: 输入: n =
 2, k = 2 输出: "00110" 说明: "01100", "10011", "11001" 也能打开保险箱。    提示：  	n 的范围是 [1,
 4]。 	k 的范围是 [1, 10]。 	k^n 最大可能为 4096。
*/

 java.util.Arrays;

public class L753Solution {
    public String crackSafe(int n, int k) {
        int total = (int) Math.pow(k, n);
        char[] password = new char[n];
        Arrays.fill(password, '0');
        StringBuilder sb = new StringBuilder();
        sb.append(new String(password));
        boolean[] visited = new boolean[total];
        visited[0] = true;
        dfs(password, visited, sb, total, k);
        return sb.toString();
    }

    private boolean dfs(char[] password, boolean[] visited, StringBuilder sb, int total, int k) {
        if (sb.length() == total) {
            return true;
        }
        String suffix = sb.substring(sb.length() - password.length + 1);
        for (int i = 0; i < k; i++) {
            char nextChar = (char) (i + '0');
            String nextStr = suffix + nextChar;
            int index = Integer.parseInt(nextStr, k);
            if (!visited[index]) {
                visited[index] = true;
                password[sb.length() % password.length] = nextChar;
                sb.append(nextChar);
                if (dfs(password, visited, sb, total, k)) {
                    return true;
                }
                visited[index] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
} 