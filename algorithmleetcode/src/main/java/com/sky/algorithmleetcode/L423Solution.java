package com.sky.algorithmleetcode;

/*
给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。 注意:  	输入只包含小写英文字母。 	输入保证合法并可以转换为原始
的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。 	输入字符串的长度小于 50,000。  示例 1:  输入: "owoztneoer
" 输出: "012" (zeroonetwo)  示例 2:  输入: "fviefuro" 输出: "45" (fourfive)
*/

 java.util.HashMap;
import java.util.Map;

public class L423Solution {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[] nums = new int[10];
        nums[0] = count['z' - 'a'];
        nums[2] = count['w' - 'a'];
        nums[4] = count['u' - 'a'];
        nums[6] = count['x' - 'a'];
        nums[8] = count['g' - 'a'];
        nums[3] = count['h' - 'a'] - nums[8];
        nums[5] = count['f' - 'a'] - nums[4];
        nums[7] = count['v' - 'a'] - nums[5];
        nums[1] = count['o' - 'a'] - nums[0] - nums[2] - nums[4];
        nums[9] = count['i' - 'a'] - nums[5] - nums[6] - nums[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
} 