package com.sky.algorithmleetcode;

/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。   示例
: matrix = [  [ 1, 5, 9],  [10, 11, 13],  [12, 13, 15] ], k = 8, 返回 13。    提示： 你
可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
*/

import java.util.PriorityQueue;

public class L378Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        for(int j=0; j<n; j++){
            queue.offer(new Tuple(0,j,matrix[0][j]));
        }
        for(int i=0; i<k-1; i++){
            Tuple tuple = queue.poll();
            if(tuple.x == n-1) continue;
            queue.offer(new Tuple(tuple.x+1, tuple.y, matrix[tuple.x+1][tuple.y]));
        }
        return queue.peek().val;
    }

    class Tuple implements Comparable<Tuple>{
        int x,y,val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        public int compareTo(Tuple o){
            return this.val - o.val;
        }
    }
} 