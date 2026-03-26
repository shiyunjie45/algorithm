package com.sky.algorithmleetcode;

/*
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 在 S 上反复执行重复项删除操作，直到无法继续删除。 在完成所有重复项删
除操作后返回最终的字符串。答案保证唯一。   示例： 输入："abbaca" 输出："ca" 解释： 例如，在 "abbaca" 中，我们可以删除 "bb" 由
于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "
ca"。    提示：  	1 	S 仅由小写英文字母组成。
*/

 class L1047Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>(); // 建立栈
        for(char c : S.toCharArray()){ // 遍历字符串
            if(!stack.isEmpty() && stack.peek() == c){ // 如果当前字符与栈顶相同，弹出栈顶
                stack.pop();
            } else{
                stack.push(c); // 否则，将字符入栈
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){ // 遍历栈，构造最终字符串
            sb.append(stack.pop());
        }
        return sb.reverse().toString(); // 将字符串反转
    }
} 