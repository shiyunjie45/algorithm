package com.sky.algorithmleetcode;

/*
请判断一个链表是否为回文链表。 示例 1: 输入: 1->2 输出: false 示例 2: 输入: 1->2->2->1 输出: true  进阶： 你能否用
 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
*/

 class L234Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        // 将链表分成两部分
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        // 反转后半部分链表
        ListNode prev = null;
        while(head2 != null){
            ListNode temp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp;
        }
        // 比较前半部分链表和反转后的后半部分链表是否相等
        while(prev != null && head != null){
            if(prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
} 