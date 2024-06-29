package com.sky.algorithmleetcode;

/*
编写一个程序判断给定的数是否为丑数。 丑数就是只包含质因数 2, 3, 5 的正整数。 示例 1: 输入: 6 输出: true 解释: 6 = 2 × 3 示
例 2: 输入: 8 输出: true 解释: 8 = 2 × 2 × 2  示例 3: 输入: 14 输出: false 解释: 14 不是丑数，因为它包含了
另外一个质因数 7。 说明：  	1 是丑数。 	输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
*/

 class L263Solution {
    public boolean isUgly(int num) {
        // 小于等于0的数不是丑数
        if (num <= 0) {
            return false;
        }
        // 如果num对2取余等于0，则一直除以2
        while (num % 2 == 0) {
            num /= 2;
        }
        // 如果num对3取余等于0，则一直除以3
        while (num % 3 == 0) {
            num /= 3;
        }
        // 如果num对5取余等于0，则一直除以5
        while (num % 5 == 0) {
            num /= 5;
        }
        // 如果num最终结果为1，则为丑数
        return num == 1;
    }
} 