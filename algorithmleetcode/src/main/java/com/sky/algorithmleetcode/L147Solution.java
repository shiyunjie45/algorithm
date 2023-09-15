package com.sky.algorithmleetcode;

/*
对链表进行插入排序。  插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 每次迭代时，从输入数据中移除一个元素（用红色表示
），并原地将其插入到已排好序的链表中。   插入排序算法：  	插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 	每次迭代中，插
入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 	重复直到所有输入数据插入完为止。    示例 1： 输入: 4->2->1-
>3 输出: 1->2->3->4  示例 2： 输入: -1->5->3->4->0 输出: -1->0->3->4->5
*/



public class L147Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0); // 哨兵节点，方便插入到已排序部分的头部
        dummy.next = head;
        ListNode lastSorted = head; // 已排序部分的尾部
        ListNode cur = head.next; // 当前待排序节点
        while(cur != null) {
            if(lastSorted.val <= cur.val) {
                // 如果待排序节点大于等于已排序部分的尾部，则直接加入到已排序部分
                lastSorted = lastSorted.next;
            } else {
                // 找到待排序节点合适的位置
                ListNode p = dummy;
                while(p.next.val <= cur.val) {
                    p = p.next;
                }
                // 在合适位置插入待排序节点
                lastSorted.next = cur.next;
                cur.next = p.next;
                p.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
} 