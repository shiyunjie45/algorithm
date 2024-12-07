package com.sky.algorithmleetcode;

/*
对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。 以字符串的形式给出 n, 以字符串的形式返回 n
 的最小好进制。   示例 1：  输入："13" 输出："3" 解释：13 的 3 进制是 111。  示例 2：  输入："4681" 输出："8" 解释：
4681 的 8 进制是 11111。  示例 3：  输入："1000000000000000000" 输出："999999999999999999" 解释：
1000000000000000000 的 999999999999999999 进制是 11。    提示：  	n的取值范围是 [3, 10^18]。 	输
入总是有效且没有前导 0。
*/

 class L483Solution {
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int maxK = (int) (Math.log(nVal) / Math.log(2)); // k的最大值取对数后向下取整
        for (int k = maxK; k >= 2; k--) { // k从大到小枚举
            long left = 2, right = (long) Math.pow(nVal, 1.0 / (k - 1)) + 1;
            while (left < right) { // 二分搜索
                long mid = left + (right - left) / 2;
                long sum = 0;
                for (int i = 0; i < k; i++) {
                    sum = sum * mid + 1;
                }
                if (sum == nVal) {
                    return String.valueOf(mid);
                } else if (sum < nVal) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return String.valueOf(nVal - 1); // 出现意外的情况，返回 n-1
    }
} 