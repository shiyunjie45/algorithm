package com.sky.algorithmleetcode;

/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 你应当保留两个分区中每个节点的初始相对位置。 示例: 输
入: head = 1->4->3->2->5->2, x = 3 输出: 1->2->2->4->3->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class L86Solution {
    public ListNode partition(ListNode head, int x) {
        // 定义两个虚拟头结点
        ListNode sHead = new ListNode(-1);  // 小于x的头结点
        ListNode bHead = new ListNode(-1);  // 大于等于x的头结点
        
        // 定义两个工作指针
        ListNode sCur = sHead;  // 小于x的工作指针
        ListNode bCur = bHead;  // 大于等于x的工作指针
        
        ListNode cur = head;    // 原链表的工作指针
        while(cur != null){
            if(cur.val < x){
                sCur.next = cur;
                sCur = sCur.next;
            }else{
                bCur.next = cur;
                bCur = bCur.next;
            }
            cur = cur.next;
        }
        // 注意要将尾结点置空，否则会出现环
        bCur.next = null;
        
        // 将两个链表拼接
        sCur.next = bHead.next;
        return sHead.next;
    }
} 