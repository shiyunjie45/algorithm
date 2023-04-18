package com.sky.algorithmleetcode;

import java.math.BigInteger;

/**
 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 请你将两个数相加，并以相同形式返回一个表示和的链表。
 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 示例 1：
 2 4 3
 5 6 4
 结果
 7 0 8
 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807.
 示例 2：
 输入：l1 = [0], l2 = [0]
 输出：[0]
 示例 3：
 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 输出：[8,9,9,9,0,0,0,1]
 提示：
 每个链表中的节点数在范围 [1, 100] 内
 0 <= Node.val <= 9
 题目数据保证列表表示的数字不含前导零
 Related Topics
 递归
 链表
 数学
 */
public class L2Solution {
    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


      public static ListNode addTwoNumbers1(ListNode l1,ListNode l2){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(l1.val);
        while(null!=l1.next){
            l1 = l1.next;
            stringBuffer.append(l1.val);
        }
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(l2.val);
        while(null!=l2.next){
            l2 = l2.next;
            stringBuffer1.append(l2.val);
        }
        String value = String.valueOf(new BigInteger(stringReversalRecursion(stringBuffer.toString())).add(new BigInteger(stringReversalRecursion(stringBuffer1.toString()))).toString());
        stringBuffer.delete(0,stringBuffer.length());
        stringBuffer1.delete(0,stringBuffer1.length());
        ListNode resultNode = new ListNode(Integer.valueOf(value.substring(value.length()-1,value.length())));
        value = value.substring(0,value.length()-1);
        ListNode firstNode = resultNode;
        while(value.length()>0){
            resultNode.next = new ListNode(Integer.valueOf(value.substring(value.length()-1,value.length())));
            value = value.substring(0,value.length()-1);
            resultNode = resultNode.next;
        }
        return firstNode;
      }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int N1 = 0;
        int N2 = 0;
        ListNode cur = l1;
        while (cur != null){
            N1++;//统计N1长度
            cur = cur.next;
        }
        cur = l2;
        while (cur != null){
            N2++;//统计N2长度
            cur = cur.next;
        }

        //遍历俩链表，放入数组
        int[] a = new int[N1];
        int[] b = new int[N2];
        cur = l1;
        int index = 0;
        while (cur != null){
            a[index++] = cur.val;//转移
            cur = cur.next;
        }
        cur = l2;
        index = 0;
        while (cur != null){
            b[index++] = cur.val;//转移
            cur = cur.next;
        }

        //可以玩加法了
        int c = 0;//进位
        index = 0;
        int N = N1>N2?N1+1:N2+1;//最大就是结果--多备份一个位置，万一是进位多出来了呢
        int[] ans = new int[N];//结果
        for (; index < N1 && index < N2; index++) {
            //最多不会超短的长度
            int tmp = a[index] + b[index] + c;//带进位加法
            c = tmp/10;//把最高位拿下来11/10=1,进位，11%10模取余是1,这个是加法之后的非进位数
            ans[index] = tmp % 10;
        }
        //把剩余的转移到ans中，把最高位那个进位带上
        for (; index < N - 1; index++) {//多备份那个位置不管
            //转移余下的数--看是谁长，加谁，a长转移a的，b长转移b的
            int tmp = (N1 >= N2 ? a[index] : b[index]) + c;//带进位加法
            c = tmp/10;//把最高位拿下来11/10=1,进位，11%10模取余是1,这个是加法之后的非进位数
            ans[index] = tmp % 10;
        }
        //注意，可能最后还有一个c=1呢，要加上,c是0就算了
        ans[N - 1] = c != 0 ? c : 0;
        //然后把数组整为链表
        ListNode head = new ListNode(ans[0]);//头
        cur = head;
        for (int i = 1; i < N; i++) {
            if (i == N -1 && ans[i] == 0) break;//最后那个位置是0就算了
            ListNode newNode = new ListNode(ans[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        return head;//挺复杂的哇
    }

    public static String stringReversalRecursion(String str){
        if (str == null || str.length() <= 1) {
            return str;
        }
        return stringReversalRecursion(str.substring(1)) + str.charAt(0);
    }

    public static ListNode arrToListNode(int[] arr){
        ListNode listNode = null;
        ListNode firstNode = null;
        for (int i = 0; i < arr.length; i++) {
            if (0==i){
                listNode = new ListNode(arr[i]);
                firstNode = listNode;
            }else{
                listNode.next = new ListNode(arr[i]);
                listNode = listNode.next;
            }
        }
        return firstNode;
    }

    public static void main(String[] args){
        int[] arr1 = {8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,0,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8};
        int[] arr2 = {6,7,8,0,8,5,8,9,7,6,5,3,8,4,5,6,7,8,9,0,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8,8,6,5,6,8,3,5,7,8,9,1,2,3,4,5,6,7,8};
        ListNode listNode1 = arrToListNode(arr1);
        ListNode listNode2 = arrToListNode(arr2);
        ListNode firstListNode1 = listNode1;
        ListNode firstListNode2 = listNode2;
        long startTime = System.currentTimeMillis();
        ListNode listNode = addTwoNumbers1(firstListNode1,firstListNode2);
        System.out.print(listNode.val);
        while (listNode.next!=null){
            listNode = listNode.next;
            System.out.print(listNode.val);
        }
        System.out.println();
        System.out.println("addTwoNumbers1耗时:"+(System.currentTimeMillis()-startTime));

        startTime = System.currentTimeMillis();
        listNode = addTwoNumbers2(firstListNode1,firstListNode2);
        System.out.print(listNode.val);
        while (listNode.next!=null){
            listNode = listNode.next;
            System.out.print(listNode.val);
        }
        System.out.println();
        System.out.println("addTwoNumbers2耗时:"+(System.currentTimeMillis()-startTime));
    }


}
