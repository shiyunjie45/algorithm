package com.sky.algorithmleetcode;

/*
一个已排序好的表 A，其包含 1 和其他一些素数.  当列表中的每一个 p 那么第 k 个最小的分数是多少呢?  以整数数组的形式返回你的答案, 这里 answ
er[0] = p 且 answer[1] = q. 示例: 输入: A = [1, 2, 3, 5], K = 3 输出: [2, 5] 解释: 已构造好的分
数,排序后如下所示: 1/5, 1/3, 2/5, 1/2, 3/5, 2/3. 很明显第三个最小的分数是 2/5. 输入: A = [1, 7], K = 1
 输出: [1, 7]  注意:  	A 长度的取值范围在 2 — 2000. 	每个 A[i] 的值在 1 —30000. 	K 取值范围为 1 —A.len
gth * (A.length - 1) / 2
*/

 class L786Solution {
    private static class Fraction {
        private int p;
        private int q;

        public Fraction(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public double getValue() {
            return (double) p / q;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Fraction> pq = new PriorityQueue<>(Comparator.comparingDouble(Fraction::getValue));
        for (int i = 1; i < A.length; i++) {
            pq.offer(new Fraction(A[0], A[i]));
        }
        for (int i = 0; i < K - 1; i++) {
            Fraction f = pq.poll();
            if (f == null) {
                return null;
            }
            if (f.q != A[A.length - 1]) {
                pq.offer(new Fraction(f.p, A[getIndex(A, f.q) + 1]));
            }
        }
        Fraction ans = pq.poll();
        return ans != null ? new int[]{ans.p, ans.q} : null;
    }

    private int getIndex(int[] A, int target) {
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
} 