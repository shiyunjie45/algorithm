package com.sky.algorithmleetcode;

/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 说明: 1 ≤ m ≤ n ≤ 链表长度。 示例: 输入: 1->2->3->4->5->NULL, 
m = 2, n = 4 输出: 1->4->3->2->5->NULL
*/

 class L92Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode curr = head;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode con = prev;
        ListNode tail = curr;
        while (n > 0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            n--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;
        
        return head;
    }
} 