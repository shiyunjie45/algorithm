package com.sky.algorithmleetcode;

/*
你需要找到由两个 n 位数的乘积组成的最大回文数。 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。 示例: 输入: 2 输出: 987 解释
: 99 x 91 = 9009, 9009 % 1337 = 987 说明: n 的取值范围为 [1,8]。
*/

 class L479Solution {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int mod = 1337;
        int max = (int) Math.pow(10, n) - 1;
        int min = (int) Math.pow(10, n - 1);
        long product = 0;
        int half = 0;
        int left = 0, right = 0;
        for (int i = max; i >= min; i--) {
            half = i;
            long tmp = product(half, max);
            product = createPalindrome(half, tmp);
            for (int j = max; j >= min; j--) {
                if (product / j > max) {
                    break;
                }
                if (product % j == 0) {
                    return (int) (product % mod);
                }
            }
        }
        return (int) (product % mod);
    }

    private long product(int half, int max) {
        StringBuilder builder = new StringBuilder(String.valueOf(half));
        builder.reverse();
        String tmp = builder.toString();
        builder.reverse().append(tmp);
        return Long.parseLong(builder.toString()) % max;
    }

    private long createPalindrome(int half, long tmp) {
        String builder = String.valueOf((half + tmp));
        StringBuilder res = new StringBuilder(builder).reverse();
        builder += res.toString();
        return Long.parseLong(builder);
    }
} 