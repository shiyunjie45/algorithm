package com.sky.algorithmleetcode;

/*
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 示例 1: 输入: 1->1->2 输出: 1->2  示例 2: 输入: 1->1->2->3
->3 输出: 1->2->3
*/

 ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class L83Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
} 