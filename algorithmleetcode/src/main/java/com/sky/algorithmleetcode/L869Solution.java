package com.sky.algorithmleetcode;

/*
给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 f
alse。     示例 1： 输入：1 输出：true  示例 2： 输入：10 输出：false  示例 3： 输入：16 输出：true  示例 4： 输
入：24 输出：false  示例 5： 输入：46 输出：true    提示：  	1
*/

 java.util.Arrays;

public class L869Solution {
    public boolean reorderedPowerOf2(int N) {
        // 生成所有2的幂数，转成字符数组排序
        String[] pow2Str = new String[31];
        for (int i = 0; i < 31; i++) {
            pow2Str[i] = sort(String.valueOf(1 << i));
        }
        // 排序N的字符数组
        String nStr = sort(String.valueOf(N));
        // 在所有2的幂数中查找
        for (int i = 0; i < 31; i++) {
            if (pow2Str[i].equals(nStr)) {
                return true;
            }
        }
        return false;
    }

    // 将字符串排序
    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
} 