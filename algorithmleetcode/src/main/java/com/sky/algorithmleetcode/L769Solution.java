package com.sky.algorithmleetcode;

/*
数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的
结果和按升序排序后的原数组相同。 我们最多能将数组分成多少块？ 示例 1: 输入: arr = [4,3,2,1,0] 输出: 1 解释: 将数组分成2块或者更
多块，都无法得到所需的结果。 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。  示例 2: 输入:
 arr = [1,0,2,3,4] 输出: 4 解释: 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。 然而，分成 [1, 0], [2],
 [3], [4] 可以得到最多的块数。  注意:  	arr 的长度在 [1, 10] 之间。 	arr[i]是 [0, 1, ..., arr.length
 - 1]的一种排列。
*/

 class L769Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            minRight[i] = Math.min(minRight[i + 1], arr[i]);
        }
        int ans = 1;
        for (int i = 0; i < n - 1; ++i) {
            if (maxLeft[i] <= minRight[i + 1]) { //当前区间可以成为一个块
                ++ans;
            }
        }
        return ans;
    }
} 