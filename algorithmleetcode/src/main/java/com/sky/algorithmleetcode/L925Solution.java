package com.sky.algorithmleetcode;

/*
你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 你将会检查键盘输入的字符 typed。
如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。   示例 1： 输入：name = "alex", typed = "aal
eex" 输出：true 解释：'alex' 中的 'a' 和 'e' 被长按。  示例 2： 输入：name = "saeed", typed = "ssaa
edd" 输出：false 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。  示例 3： 输入：name = "leelee", typ
ed = "lleeelee" 输出：true  示例 4： 输入：name = "laiden", typed = "laiden" 输出：true 解释：长
按名字中的字符并不是必要的。    提示：  	name.length 	typed.length 	name 和 typed 的字符都是小写字母。
*/

 class L925Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i =0, j=0;
        while(i<name.length() && j<typed.length()){
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if(c1==c2){
                i++;
                j++;
            }else if(j>0 && c2==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        return i==name.length();
    }
} 