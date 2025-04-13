package com.sky.algorithmleetcode;

/*
给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：  	任何左括号 ( 必须有相应的右括号 
)。 	任何右括号 ) 必须有相应的左括号 ( 。 	左括号 ( 必须在对应的右括号之前 )。 	* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字
符串。 	一个空字符串也被视为有效字符串。  示例 1:  输入: "()" 输出: True  示例 2:  输入: "(*)" 输出: True  示例 3
:  输入: "(*))" 输出: True  注意:  	字符串大小将在 [1，100] 范围内。
*/

 class L678Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1; //左括号，lo++
            hi += c != ')' ? 1 : -1; //右括号或通配符，hi--
            if (hi < 0) { //右括号或通配符比左括号多，即hi<0，则匹配不成功
                return false;
            }
            lo = Math.max(lo, 0); //防止lo变成负数
        }
        return lo == 0;//如果最后左括号可以完全匹配右括号或通配符，则lo=0
    }
} 