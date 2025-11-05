package com.sky.algorithmleetcode;

/*
如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 
[L, R] 中的超级回文数的数目。   示例： 输入：L = "4", R = "1000" 输出：4 解释： 4，9，121，以及 484 是超级回文数。 
注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。   提示：  	1 	1 	L 和 R 是表示 [1, 10^18) 
范围的整数的字符串。 	int(L)
*/

 class L906Solution {
    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        int cnt = 0;
        for (long i = 1; i <= 9; i++) {
            if (i >= l && i <= r && isPalindrome(i * i)) {
                cnt++;
            }
        }
        for (long i = 1; i <= 10000; i++) {
            String s = Long.toString(i);
            String t = new StringBuilder(s).reverse().toString();
            long x = Long.parseLong(s + t);
            long y = x * x;
            if (y > r) {
                break;
            }
            if (y >= l && isPalindrome(y)) {
                cnt++;
            }
        }
        for (long i = 1; i <= 10000; i++) {
            String s = Long.toString(i);
            String t = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            long x = Long.parseLong(s + t);
            long y = x * x;
            if (y > r) {
                break;
            }
            if (y >= l && isPalindrome(y)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPalindrome(long n) {
        return n == reverse(n);
    }

    public long reverse(long n) {
        long x = 0;
        while (n != 0) {
            x = x * 10 + n % 10;
            n /= 10;
        }
        return x;
    }
} 