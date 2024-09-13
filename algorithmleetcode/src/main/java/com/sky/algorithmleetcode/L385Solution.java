package com.sky.algorithmleetcode;

/*
给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。 列表中的每个元素只可能是整数或整数嵌套列表 提示：你可以假定这些字符串都是格式良好的：  	
字符串非空 	字符串不包含空格 	字符串只包含数字0-9, [, - ,, ]    示例 1：  给定 s = "324", 你应该返回一个 NestedIn
teger 对象，其中只包含整数值 324。    示例 2：  给定 s = "[123,[456,[789]]]", 返回一个 NestedInteger 
对象包含一个有两个元素的嵌套列表： 1. 一个 integer 包含值 123 2. 一个包含两个元素的嵌套列表：   i. 一个 integer 包含值 45
6   ii. 一个包含一个元素的嵌套列表     a. 一个 integer 包含值 789
*/

import java.util.Stack;

public class L385Solution {
    public NestedInteger deserialize(String s) {
        if (s.length() == 0) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = null;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
                l = r + 1;
            } else if (ch == ']') {
                String numStr = s.substring(l, r);
                if (numStr.length() > 0) {
                    cur.add(new NestedInteger(Integer.parseInt(numStr)));
                }
                if (!stack.isEmpty()) {
                    NestedInteger prev = stack.pop();
                    prev.add(cur);
                    cur = prev;
                }
                l = r + 1;
            } else if (ch == ',') {
                if (s.charAt(r-1) != ']') {
                    String numStr = s.substring(l, r);
                    cur.add(new NestedInteger(Integer.parseInt(numStr)));
                }
                l = r + 1;
            }
        }
        return cur;
    }

    private class NestedInteger {
        public NestedInteger(int i) {
        }
        public NestedInteger() {
        }

        public void add(NestedInteger nestedInteger) {
        }
    }
}
