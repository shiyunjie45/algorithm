package com.sky.algorithmleetcode;

/*
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。  示例： 输入：1->2->4, 1->3->4 输出：1->1-
>2->3->4->4
*/

 class L21Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // 创建哑节点，方便返回结果
        ListNode prev = dummy; // 将前驱节点指向哑节点
        while (l1 != null && l2 != null) { // 当两个链表都不为空时
            if (l1.val <= l2.val) { // 如果第一个链表的结点值小于等于第二个链表的结点值
                prev.next = l1; // 将前驱节点指向第一个链表的结点
                l1 = l1.next; // 将第一个链表的结点指针向后移动一位
            } else { // 如果第一个链表的结点值大于第二个链表的结点值
                prev.next = l2; // 将前驱节点指向第二个链表的结点
                l2 = l2.next; // 将第二个链表的结点指针向后移动一位
            }
            prev = prev.next; // 将前驱结点指针向后移动一位
        }
        prev.next = l1 != null ? l1 : l2; // 如果第一个链表指针不为空，则指向第一个链表；否则，指向第二个链表
        return dummy.next; // 返回哑节点的下一个结点
    }
} 