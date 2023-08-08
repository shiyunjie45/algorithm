package com.sky.algorithmleetcode;

/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 
1。 示例: 给定的有序链表： [-10, -3, 0, 5, 9], 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个
高度平衡二叉搜索树：    0   / \  -3  9  /  / -10 5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
  * Definition for a binary tree node.
  * public class TreeNode {
  *     int val;
  *     TreeNode left;
  *     TreeNode right;
  *     TreeNode(int x) { val = x; }
  * }
  */
 class L109Solution {
     public TreeNode sortedListToBST(ListNode head) {
         if (head == null) {
             return null;
         }
         return toBST(head, null);
     }
     
     private TreeNode toBST(ListNode head, ListNode tail) {
         ListNode slow = head;
         ListNode fast = head;
         if (head == tail) {
             return null;
         }
         while (fast != tail && fast.next != tail) {
             fast = fast.next.next;
             slow = slow.next;
         }
         TreeNode thead = new TreeNode(slow.val);
         thead.left = toBST(head, slow);
         thead.right = toBST(slow.next, tail);
         return thead;
     }
 } 