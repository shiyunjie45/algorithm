package com.sky.algorithmleetcode;

/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 你可以假设除了数字 0 之外
，这两个数字都不会以零开头。   进阶： 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。   示例： 输入：(7 -> 2 -> 4 
-> 3) + (5 -> 6 -> 4) 输出：7 -> 8 -> 0 -> 7
*/

 class L445Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || sum > 0) {
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            sum /= 10;
        }
        return head;
    }
} 