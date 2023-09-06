package com.sky.algorithmleetcode;

/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 要求返回这个链表的 深拷贝。  我们用一个由 n 个节点组成的链表来
表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：  	val：一个表示 Node.val 的整数。 	random_ind
ex：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。    示例 1：  输入：head = [[7,null],[
13,0],[11,4],[10,2],[1,0]] 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]  示例 2：  输入：h
ead = [[1,1],[2,1]] 输出：[[1,1],[2,1]]  示例 3：  输入：head = [[3,null],[3,0],[3,null]]
 输出：[[3,null],[3,0],[3,null]]  示例 4： 输入：head = [] 输出：[] 解释：给定的链表为空（空指针），因此返回 nul
l。    提示：  	-10000 	Node.random 为空（null）或指向链表中的节点。 	节点数目不超过 1000 。
*/

/**
 * Definition for a Node.
 * public class Node {
 *     int val;
 *     Node next;
 *     Node random;
 *
 *     public Node(int val) {
 *         this.val = val;
 *         this.next = null;
 *         this.random = null;
 *     }
 * }
 */
public class L138Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一步：在每个原节点后面拷贝出一个新节点
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        // 第二步：为新节点的 random 指针复制
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        // 第三步：拆分原链表和新链表
        node = head;
        Node newHead = head.next;
        Node newNode = newHead;
        while (node != null) {
            node.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
            node = node.next;
            newNode = newNode.next;
        }

        return newHead;
    }
} 