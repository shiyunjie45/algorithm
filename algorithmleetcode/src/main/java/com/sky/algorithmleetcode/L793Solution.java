package com.sky.algorithmleetcode;

/*
f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1） 例如， f(3) = 0 ，因为3! = 6
的末尾没有0；而 f(11) = 2 ，因为11!= 39916800末端有2个0。给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。  示例 1
: 输入:K = 0 输出:5 解释: 0!, 1!, 2!, 3!, and 4! 均符合 K = 0 的条件。 示例 2: 输入:K = 5 输出:0 解释
:没有匹配到这样的 x!，符合K = 5 的条件。  注意：  	 	K是范围在 [0, 10^9] 的整数。
*/

 class L793Solution {
    public int preimageSizeFZF(int K) {
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            int zeros = getTrailingZeros(mid);
            if (zeros < K) {
                left = mid + 1;
            } else if (zeros > K) {
                right = mid - 1;
            } else {
                return 5;
            }
        }
        return 0;
    }

    private int getTrailingZeros(long n) {
        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
} 