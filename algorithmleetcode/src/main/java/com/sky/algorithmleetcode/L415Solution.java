package com.sky.algorithmleetcode;

/*
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 注意：  	num1 和num2 的长度都小于 5100. 	num1 和num2 都只包
含数字 0-9. 	num1 和num2 都不包含任何前导零。 	你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
*/

 class L415Solution {
    /**
     * 计算两个字符串形式的非负整数的和
     *
     * @param num1 字符串形式的非负整数1
     * @param num2 字符串形式的非负整数2
     * @return 两个字符串形式的非负整数的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder(); // 用StringBuilder来保存结果
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0; // 进位
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0; // 如果i已经过了num1的最左边（即num1已经加完了），则x取0，否则取num1当前的数值
            int y = j >= 0 ? num2.charAt(j) - '0' : 0; // 如果j已经过了num2的最左边（即num2已经加完了），则y取0，否则取num2当前的数值
            int sum = x + y + carry; // 计算两个数之和以及进位
            sb.append(sum % 10); // 将个位上的数值添加到结果中
            carry = sum / 10; // 更新进位值
            i--; // 从右往左处理num1和num2的每一位
            j--;
        }
        if (carry != 0) { // 如果最后还有进位，把进位也加到结果里
            sb.append(carry);
        }
        return sb.reverse().toString(); // 最后将结果倒转一下返回
    }
} 