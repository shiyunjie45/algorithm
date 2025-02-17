package com.sky.algorithmleetcode;

/*
给定一个表示代码片段的字符串，你需要实现一个验证器来解析这段代码，并返回它是否合法。合法的代码片段需要遵守以下的所有规则：  	代码必须被合法的闭合标签包围。否
则，代码是无效的。 	闭合标签（不一定合法）要严格符合格式：TAG_CONTENT。其中，是起始标签，是结束标签。起始和结束标签中的 TAG_NAME 应当相同
。当且仅当 TAG_NAME 和 TAG_CONTENT 都是合法的，闭合标签才是合法的。 	合法的 TAG_NAME 仅含有大写字母，长度在范围 [1,9] 
之间。否则，该 TAG_NAME 是不合法的。 	合法的 TAG_CONTENT 可以包含其他合法的闭合标签，cdata （请参考规则7）和任意字符（注意参考规
则1）除了不匹配的、不匹配的起始和结束标签、不匹配的或带有不合法 TAG_NAME 的闭合标签。否则，TAG_CONTENT 是不合法的。 	一个起始标签，如果
没有具有相同 TAG_NAME 的结束标签与之匹配，是不合法的。反之亦然。不过，你也需要考虑标签嵌套的问题。 	一个，如果你找不到一个后续的>与之匹配，是不合法
的。并且当你找到一个或时，所有直到下一个>的前的字符，都应当被解析为 TAG_NAME（不一定合法）。 	cdata 有如下格式：。CDATA_CONTENT 
的范围被定义成  和后续的第一个 ]]>之间的字符。 	CDATA_CONTENT 可以包含任意字符。cdata 的功能是阻止验证器解析CDATA_CONTEN
T，所以即使其中有一些字符可以被解析为标签（无论合法还是不合法），也应该将它们视为常规字符。  合法代码的例子:  输入: "This is the first
 line ]]>" 输出: True 解释:  代码被包含在了闭合的标签内： 和 。 TAG_NAME 是合法的，TAG_CONTENT 包含了一些字符和 c
data 。  即使 CDATA_CONTENT 含有不匹配的起始标签和不合法的 TAG_NAME，它应该被视为普通的文本，而不是标签。 所以 TAG_CONT
ENT 是合法的，因此代码是合法的。最终返回True。  输入: ">> ![cdata[]] ]>]]>]]>>]" 输出: True 解释: 我们首先将代码
分割为： start_tag|tag_content|end_tag 。 start_tag -> "" end_tag -> "" tag_content 也
可被分割为： text1|cdata|text2 。 text1 -> ">> ![cdata[]] " cdata -> "]>]]>" ，其中 CDATA_
CONTENT 为 "]>" text2 -> "]]>>]"  start_tag 不是 ">>" 的原因参照规则 6 。 cdata 不是 "]>]]>]]
>" 的原因参照规则 7 。  不合法代码的例子:  输入: "   " 输出: False 解释: 不合法。如果 "" 是闭合的，那么 "" 一定是不匹配的，
反之亦然。 输入: " div tag is not closed " 输出: False 输入: " unmatched " 输出: False 输入: " 
closed tags with invalid tag name 123 " 输出: False 输入: " unmatched tags with inva
lid tag name  and  " 输出: False 输入: " unmatched start tag  and unmatched end tag 
 " 输出: False  注意:  	为简明起见，你可以假设输入的代码（包括提到的任意字符）只包含数字, 字母, ','>','/','!','[',']'和
' '。
*/

 java.util.Stack;

public class L591Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>(); // 使用栈来对标签进行匹配
        for (int i = 0; i < code.length(); ) {
            if (i > 0 && stack.isEmpty()) { // 判断代码是否被合法的闭合标签包围
                return false;
            }
            if (code.startsWith("<![CDATA[", i)) { // 处理CDATA部分
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i == -1) {
                    return false;
                }
                i += 3;
            } else if (code.startsWith("</", i)) { // 处理结束标签
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i == -1) {
                    return false;
                }
                String tag = code.substring(j, i);
                if (stack.isEmpty() || !stack.pop().equals(tag)) {
                    return false;
                }
            } else if (code.startsWith("<", i)) { // 处理起始标签
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i == -1) {
                    return false;
                }
                String tag = code.substring(j, i);
                if (!isValidTag(tag)) {
                    return false;
                }
                stack.push(tag);
            } else {
                i++;
            }
        }
        return stack.isEmpty(); // 判断是否所有起始标签都能被匹配到结束标签，同时检查是否有多余的结束标签
    }

    private boolean isValidTag(String tag) {
        if (tag.length() < 1 || tag.length() > 9) { // TAG_NAME 应当在范围 [1,9] 之间
            return false;
        }
        for (char c : tag.toCharArray()) {
            if (!Character.isUpperCase(c)) { // TAG_NAME 必须全部是大写字母
                return false;
            }
        }
        return true;
    }
} 