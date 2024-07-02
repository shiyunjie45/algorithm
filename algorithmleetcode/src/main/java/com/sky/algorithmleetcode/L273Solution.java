package com.sky.algorithmleetcode;

/*
将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。 示例 1: 输入: 123 输出: "One Hundred Twenty Thre
e"  示例 2: 输入: 12345 输出: "Twelve Thousand Three Hundred Forty Five" 示例 3: 输入: 123
4567 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 示例 4: 输入: 1234567891 输出: "One Billion Two Hundred Thirty Four Million Five Hund
red Sixty Seven Thousand Eight Hundred Ninety One"
*/

 class L273Solution {
    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        }
        else if (num < 20) {
            return ones[num] + " ";
        }
        else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        }
        else {
            return ones[num / 100] + " Hundred " + helper(num % 100);
        }
    }
} 