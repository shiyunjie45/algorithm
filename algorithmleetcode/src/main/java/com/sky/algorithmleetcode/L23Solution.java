package com.sky.algorithmleetcode;

/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 示例: 输入: [   1->4->5,   1->3->4,   2->6 ] 输出:
 1->1->2->3->4->4->5->6
*/

import java.util.Comparator;
import java.util.PriorityQueue;

class L23Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(node -> node.val));

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummyHead.next;
    }
} 