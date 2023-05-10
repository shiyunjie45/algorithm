package com.sky.algorithmleetcode;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 示例： 给定一个链表: 1->2->3->4->5, 和 n = 2. 当删除了倒数第二个节
点后，链表变为 1->2->3->5.  说明： 给定的 n 保证是有效的。 进阶： 你能尝试使用一趟扫描实现吗？
*/

 class L19Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        // q 先走 n 步
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        // p 和 q 同时走，直到 q 到达链表尾部
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        // 删除 p 的后一个节点
        ListNode temp = p.next;
        p.next = temp.next;
        temp.next = null;

        return dummyHead.next;
    }
} 