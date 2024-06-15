package com.sky.algorithmleetcode;

/*
使用栈实现队列的下列操作：  	push(x) -- 将一个元素放入队列的尾部。 	pop() -- 从队列首部移除元素。 	peek() -- 返回队列首部的
元素。 	empty() -- 返回队列是否为空。  示例: MyQueue queue = new MyQueue(); queue.push(1); que
ue.push(2);  queue.peek(); // 返回 1 queue.pop();  // 返回 1 queue.empty(); // 返回 fa
lse 说明:  	你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 
操作是合法的。 	你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 	假设所有操作都是有效的
 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
*/

import java.util.Stack;

class L232Solution {
    //定义两个栈用于实现队列
    Stack<Integer> inputStack = new Stack<>();
    Stack<Integer> outputStack = new Stack<>();

    //构造函数
    public L232Solution() {

    }

    //将元素放入队列尾部
    public void push(int x) {
        while (!outputStack.isEmpty()){  //将原有元素全部压到inputStack
            inputStack.push(outputStack.pop());
        }
        inputStack.push(x);
    }

    //从队列首部移除元素
    public int pop() {
        peek(); //先调用peek函数将元素倒回outputStack
        return outputStack.pop();
    }

    //返回首部元素
    public int peek() {
        if (outputStack.isEmpty()){
            while (!inputStack.isEmpty()){ //将inputStack中的元素全部倒回outputStack
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    //返回队列是否为空
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
} 