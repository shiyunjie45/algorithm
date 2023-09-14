package com.sky.algorithmleetcode;

/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 获取数据 get
(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value) - 如果密钥已经存在
，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。  
 进阶: 你是否可以在 O(1) 时间复杂度内完成这两种操作？   示例: LRUCache cache = new LRUCache( 2 /* 缓存容量 *
/ ); cache.put(1, 1); cache.put(2, 2); cache.get(1);    // 返回 1 cache.put(3, 3);
  // 该操作会使得密钥 2 作废 cache.get(2);    // 返回 -1 (未找到) cache.put(4, 4);  // 该操作会使得密钥
 1 作废 cache.get(1);    // 返回 -1 (未找到) cache.get(3);    // 返回 3 cache.get(4);    
// 返回 4
*/

import java.util.HashMap;
import java.util.Map;

public class L146Solution {
    private Map<Integer, DLLNode> cache;
    private int capacity;
    private int size;
    private DLLNode head;
    private DLLNode tail;

    public L146Solution(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLLNode();
        this.tail = new DLLNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLLNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new DLLNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                DLLNode removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
        }
    }

    private void moveToHead(DLLNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLLNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLLNode removeTail() {
        DLLNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private class DLLNode {
        int key;
        int value;
        DLLNode prev;
        DLLNode next;

        public DLLNode() {
        }

        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
} 