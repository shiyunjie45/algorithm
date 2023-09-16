package com.sky.algorithmleetcode;

/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 示例 1: 输入: 4->2->1->3 输出: 1->2->3->4  示例 2:
 输入: -1->5->3->4->0 输出: -1->0->3->4->5
*/

 class L148Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if(left != null) {
            curr.next = left;
        } else if(right != null) {
            curr.next = right;
        }

        return dummy.next;
    }
} 