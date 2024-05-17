package com.sky.algorithmleetcode;

/*
删除链表中等于给定值 val 的所有节点。 示例: 输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
*/

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class L203Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) { // 处理头节点等于给定值的情况
            head = head.next;
        }

        if (head == null) { // 处理链表为空的情况
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) { // 遍历链表删除节点
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
} 