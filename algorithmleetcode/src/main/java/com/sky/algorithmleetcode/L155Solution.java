package com.sky.algorithmleetcode;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。  	push(x) —— 将元素 x 推入栈中。 	pop() —— 删
除栈顶的元素。 	top() —— 获取栈顶元素。 	getMin() —— 检索栈中的最小元素。    示例: 输入： ["MinStack","push",
"push","push","getMin","pop","top","getMin"] [[],[-2],[0],[-3],[],[],[],[]] 输出： 
[null,null,null,null,-3,null,0,-2] 解释： MinStack minStack = new MinStack(); minSt
ack.push(-2); minStack.push(0); minStack.push(-3); minStack.getMin();  --> 返回 -3
. minStack.pop(); minStack.top();   --> 返回 0. minStack.getMin();  --> 返回 -2.    
提示：  	pop、top 和 getMin 操作总是在 非空栈 上调用。
*/

import java.util.Stack;

class L155Solution {
    private Stack<Integer> dataStack;//数据栈
    private Stack<Integer> minStack;//辅助栈
    
    /** initialize your data structure here. */
    public L155Solution() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /**
     * 将元素 x 推入栈中
     * @param x
     */
    public void push(int x) {
        //数据栈直接压入元素x
        dataStack.push(x);
        //如果辅助栈为空或者x比辅助栈栈顶元素小，就将x压入辅助栈
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    /**
     * 删除栈顶的元素
     */
    public void pop() {
        //如果数据栈的栈顶元素等于辅助栈的栈顶元素，就将辅助栈的栈顶元素删除
        if (dataStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    /**
     * 获取栈顶元素
     * @return
     */
    public int top() {
        return dataStack.peek();
    }
    
    /**
     * 检索栈中的最小元素
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }
} 