package com.sky.algorithmleetcode;

/*
设计实现双端队列。 你的实现需要支持以下操作：  	MyCircularDeque(k)：构造函数,双端队列的大小为k。 	insertFront()：将一个元
素添加到双端队列头部。 如果操作成功返回 true。 	insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 	deleteFr
ont()：从双端队列头部删除一个元素。 如果操作成功返回 true。 	deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 	
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 	getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -
1。 	isEmpty()：检查双端队列是否为空。 	isFull()：检查双端队列是否满了。  示例： MyCircularDeque circularDeq
ue = new MycircularDeque(3); // 设置容量大小为3 circularDeque.insertLast(1);			    // 返
回 true circularDeque.insertLast(2);			    // 返回 true circularDeque.insertFront(3
);			    // 返回 true circularDeque.insertFront(4);			    // 已经满了，返回 false circula
rDeque.getRear(); 				// 返回 2 circularDeque.isFull();				    // 返回 true circular
Deque.deleteLast();			    // 返回 true circularDeque.insertFront(4);			    // 返回 t
rue circularDeque.getFront();				// 返回 4     提示：  	所有值的范围为 [1, 1000] 	操作次数的范围为 [
1, 1000] 	请不要使用内置的双端队列库。
*/

 MyCircularDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        data = new int[k];
        front = 0;
        rear = 0;
        size = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
} 