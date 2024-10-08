package com.sky.algorithmleetcode;

/*
给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。 进阶: 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空
间复杂度实现？ 示例:  // 初始化一个单链表 [1,2,3]. ListNode head = new ListNode(1); head.next = n
ew ListNode(2); head.next.next = new ListNode(3); Solution solution = new Soluti
on(head); // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。 solution.getRandom();
*/

import java.util.Random;

public class L382Solution {
    private ListNode head;
    private Random random;

    public L382Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode node = head;
        int count = 0;
        int result = 0;
        while (node != null) {
            count++;
            // 以1/count的概率选择当前节点
            if (random.nextInt(count) == 0) {
                result = node.val;
            }
            node = node.next;
        }
        return result;
    }
} 