package com.sky.algorithmleetcode;

/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 示例 1:  输入: "Let's take LeetCode cont
est" 输出: "s'teL ekat edoCteeL tsetnoc"   注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
*/

 class L557Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" "); // 按照空格将字符串分割为单词数组
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word)).append(" "); // 将每个单词翻转并添加到 StringBuilder 中
        }
        sb.deleteCharAt(sb.length() - 1); // 删除最后一个空格
        return sb.toString();
    }

    private String reverse(String word) {
        char[] arr = word.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
} 