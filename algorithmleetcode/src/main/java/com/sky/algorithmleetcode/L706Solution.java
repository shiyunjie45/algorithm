package com.sky.algorithmleetcode;

/*
不使用任何内建的哈希表库设计一个哈希映射 具体地说，你的设计应该包含以下的功能  	put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对
应的值已经存在，更新这个值。 	get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。 	remove(key)：如果映射中存在这个键，删
除这个数值对。  示例： MyHashMap hashMap = new MyHashMap(); hashMap.put(1, 1);           h
ashMap.put(2, 2);         hashMap.get(1);            // 返回 1 hashMap.get(3);    
        // 返回 -1 (未找到) hashMap.put(2, 1);         // 更新已有的值 hashMap.get(2);     
       // 返回 1 hashMap.remove(2);         // 删除键为2的数据 hashMap.get(2);           
 // 返回 -1 (未找到)   注意：  	所有的值都在 [0, 1000000]的范围内。 	操作的总数目在[1, 10000]范围内。 	不要使用内建的
哈希库。
*/

 Node {
    int key, value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class L706Solution {
    private Node[] nodes;

    /**
     * Initialize your data structure here.
     */
    public L706Solution() {
        nodes = new Node[10000];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            nodes[i] = new Node(-1, -1);
        }
        Node prev = findPrev(nodes[i], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            return -1;
        }
        Node prev = findPrev(nodes[i], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            return;
        }
        Node prev = findPrev(nodes[i], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }

    /**
     * Returns the index of the bucket for the specified key
     */
    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    /**
     * Returns the node before the node containing the specified key in the specified bucket,
     * or the dummy head node if there is no such node
     */
    private Node findPrev(Node head, int key) {
        Node prev = head;
        Node cur = head.next;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
} 