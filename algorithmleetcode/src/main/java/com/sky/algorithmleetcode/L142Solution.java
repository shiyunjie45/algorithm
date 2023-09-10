package com.sky.algorithmleetcode;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索
引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 说明：不允许修改给定的链表。   示例 1： 输入：head = [3,2,0,-4], po
s = 1 输出：tail connects to node index 1 解释：链表中有一个环，其尾部连接到第二个节点。   示例 2： 输入：head =
 [1,2], pos = 0 输出：tail connects to node index 0 解释：链表中有一个环，其尾部连接到第一个节点。   示例 3：
 输入：head = [1], pos = -1 输出：no cycle 解释：链表中没有环。     进阶： 你是否可以不用额外空间解决此题？
*/

 class L142Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 判断链表是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 有环，找到环中的起点
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null; // 无环
    }

} 