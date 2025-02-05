package com.sky.algorithmleetcode;

/*
给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。 “最近的”定义为两个整数差的绝对值最小。 示例 1:  输入: "123" 输出: "121" 
 注意:  	n 是由字符串表示的正整数，其长度不超过18。 	如果有多个结果，返回最小的那个。
*/

 java.math.BigInteger;

public class L564Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean isOdd = (len % 2 == 1);
        String left = n.substring(0, (len + 1) / 2);
        BigInteger num = new BigInteger(left);
        BigInteger inc = BigInteger.ONE;

        // 1. 根据左半部分，生成回文数
        BigInteger palindromic = generatePalindromic(num, isOdd);

        // 2. 左边部分 + 1 生成回文数
        BigInteger leftInc = generatePalindromic(num.add(inc), isOdd);

        // 3. 左边部分 - 1 生成回文数
        BigInteger leftDec = generatePalindromic(num.subtract(inc), isOdd);

        // 4. 如果n是回文数，比较n左边较小和右边较大的
        if (palindromic.equals(new BigInteger(n))) {
            return leftDec.compareTo(num) == -1 ? leftDec.toString() : left.compareTo(num.subtract(BigInteger.ONE)) == -1 ? left : leftInc.toString();
        }

        BigInteger diff1 = palindromic.subtract(new BigInteger(n)).abs();
        BigInteger diff2 = leftInc.subtract(new BigInteger(n)).abs();
        BigInteger diff3 = leftDec.subtract(new BigInteger(n)).abs();

        // 5. 找三者差值最小的
        if (diff2.compareTo(diff1) == -1 || (diff2.compareTo(diff1) == 0 && left.compareTo(num.subtract(BigInteger.ONE)) == -1)) {
            return leftInc.toString();
        } else if (diff1.compareTo(diff3) == -1 || (diff1.compareTo(diff3) == 0 && left.compareTo(num.subtract(BigInteger.ONE)) == -1)) {
            return palindromic.toString();
        } else {
            return leftDec.toString();
        }
    }

    // 生成回文数
    private BigInteger generatePalindromic(BigInteger num, boolean isOdd) {
        String str = num.toString();
        StringBuilder sb = new StringBuilder(str);
        if (isOdd) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String reversed = sb.reverse().toString();
        BigInteger result = new BigInteger(str + reversed);
        return result;
    }
} 