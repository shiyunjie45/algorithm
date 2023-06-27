package com.sky.algorithmleetcode;

/*
验证给定的字符串是否可以解释为十进制数字。 例如: "0" => true " 0.1 " => true "abc" => false "1 a" => fa
lse "2e10" => true " -90e3   " => true " 1e" => false "e3" => false " 6e-1" => t
rue " 99e2.5 " => false "53.5e93" => true " --6 " => false "-+3" => false "95a54
e53" => false 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表
：  	数字 0-9 	指数 - "e" 	正/负号 - "+"/"-" 	小数点 - "."  当然，在输入中，这些字符的上下文也很重要。 更新于 2015-
02-10: C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
*/

 class L65Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        
        int index = 0;
        int n = s.length();
        
        // remove whitespace
        while (index < n && Character.isWhitespace(s.charAt(index))) {
            index++;
        }
        // check sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            index++;
        }
        
        // check digits
        boolean hasDigit = false;
        while (index < n && Character.isDigit(s.charAt(index))) {
            index++;
            hasDigit = true;
        }
        
        // check decimal point
        if (index < n && s.charAt(index) == '.') {
            index++;
            while (index < n && Character.isDigit(s.charAt(index))) {
                index++;
                hasDigit = true;
            }
        }
        
        // check exponent
        if (index < n && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
                index++;
            }
            if (index == n || !Character.isDigit(s.charAt(index))) {
                return false;
            }
            while (index < n && Character.isDigit(s.charAt(index))) {
                index++;
            }
        }
        
        // check for trailing whitespace
        while (index < n && Character.isWhitespace(s.charAt(index))) {
            index++;
        }
        
        return hasDigit && index == n;
    }
} 