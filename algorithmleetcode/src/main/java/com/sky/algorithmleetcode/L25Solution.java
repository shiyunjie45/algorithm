package com.sky.algorithmleetcode;

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 k 是一个正整数，它的值小于或等于链表的长度。 如果节点总数不是 k 的整数倍，那么请将最后剩
余的节点保持原有顺序。   示例： 给你这个链表：1->2->3->4->5 当 k = 2 时，应当返回: 2->1->4->3->5 当 k = 3 时，应
当返回: 3->2->1->4->5   说明：  	你的算法只能使用常数的额外空间。 	你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L25Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead, tail = dummyHead;
        while (len >= k) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
            }
            ListNode next = tail.next;
            ListNode[] reversed = reverse(prev.next, tail);
            prev.next = reversed[0];
            tail = prev.next;
            reversed[1].next = next;
            prev = reversed[1];
            len -= k;   
        }
        return dummyHead.next;
    }
    
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next, curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }
} 