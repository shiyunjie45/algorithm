package com.sky.algorithmleetcode;

/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 示例 1: 输入: 1->2->3->3->4->4->5 输出: 1-
>2->5  示例 2: 输入: 1->1->1->2->3 输出: 2->3
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L82Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null) {
            boolean dup = false;
            while(curr.next != null && curr.next.val == curr.val) {
                dup = true;
                curr = curr.next;
            }
            if(dup) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
} 