package com.sky.algorithmleetcode;

/*
给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或
是其他列表。   示例 1: 输入: [[1,1],2,[1,1]] 输出: [1,1,2,1,1] 解释: 通过重复调用 next 直到 hasNext 返回
 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 示例 2: 输入: [1,[4,[6]]] 输出: [1,4,6] 解释: 通过重复
调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
*/

import java.util.*;

public class L341Solution {
    private Deque<Iterator<NestedInteger>> stack;
    private Integer next;

    public L341Solution(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        stack.push(nestedList.iterator());
    }

    public Integer next() {
        if (hasNext()) {
            Integer res = next;
            next = null;
            return res;
        }
        return null;
    }

    public boolean hasNext() {
        while (!stack.isEmpty() && next == null) {
            Iterator<NestedInteger> it = stack.peek();
            if (it.hasNext()) {
                NestedInteger ni = it.next();
                if (ni.isInteger()) {
                    next = ni.getInteger();
                } else {
                    stack.push(ni.getList().iterator());
                }
            } else {
                stack.pop();
            }
        }
        return next != null;
    }

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
}