package com.sky.algorithmleetcode;

/*
累加数是一个字符串，组成它的数字可以形成累加序列。 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和
。 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 0
3 或者 1, 02, 3 的情况。 示例 1: 输入: "112358" 输出: true 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 
1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8  示例 2: 输入: "199100199" 输出: true 解释: 累加序列为
: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 进阶: 你如何处理一个溢出的过大的整数输入?
*/

 class L306Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) { //枚举前两个数字长度，因为题目要求至少包含3个数，所以至少有两个数字
            if (num.charAt(0) == '0' && i > 1) { //如果第一个数字以0开头并且长度大于1，不能接受
                break;
            }
            long x1 = Long.parseLong(num.substring(0, i)); //第一个数字
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) { //j的长度小于n-i-j，保证有第三个数
                if (num.charAt(i) == '0' && j > 1) { //同理判断第二个数字以0开头
                    break;
                }
                long x2 = Long.parseLong(num.substring(i, i + j)); //第二个数字
                if (isValid(x1, x2, j + i, num)) { //从第三位开始验证是否是累加数
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(long x1, long x2, int start, String num) { //验证是否是累加数
        if (start == num.length()) { //到达字符串尾部，说明是累加数，返回true
            return true;
        }
        long sum = x1 + x2; //计算第三个数
        for (int i = start; i < num.length(); i++) { //从start开始验证
            if (num.charAt(start) == '0' && i > start) { //如果第三个数字以0开头并且长度大于1，不能接受
                break;
            }
            long cur = Long.parseLong(num.substring(start, i + 1)); //下一个数字
            if (cur == sum && isValid(x2, cur, i + 1, num)) { //如果当前数字等于sum且后面的数字也是累加数，返回true
                return true;
            }
            if (cur > sum) { //如果当前数字大于sum，退出，因为后面数字无法继续累加到sum
                break;
            }
        }
        return false;
    }
} 