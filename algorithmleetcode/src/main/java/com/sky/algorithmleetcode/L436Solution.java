package com.sky.algorithmleetcode;

/*
给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。 对于任何区间，你需要存储
的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一
个值为存储的区间值的数组。 注意:  	你可以假设区间的终点总是大于它的起始点。 	你可以假定这些区间都不具有相同的起始点。  示例 1:  输入: [ [1,
2] ] 输出: [-1] 解释:集合中只有一个区间，所以输出-1。  示例 2:  输入: [ [3,4], [2,3], [1,2] ] 输出: [-1, 
0, 1] 解释:对于[3,4]，没有满足条件的“右侧”区间。 对于[2,3]，区间[3,4]具有最小的“右”起点; 对于[1,2]，区间[2,3]具有最小的“
右”起点。  示例 3:  输入: [ [1,4], [2,3], [3,4] ] 输出: [-1, 2, -1] 解释:对于区间[1,4]和[3,4]，没有满
足条件的“右侧”区间。 对于[2,3]，区间[3,4]有最小的“右”起点。
*/

 class L436Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        //将区间的起始点和索引存放到map中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        //将起始点进行排序，得到每一个区间对应的最小右侧区间索引
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] res = new int[n];

        //二分查找
        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1, ans = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (intervals[mid][0] >= intervals[i][1]) {
                    ans = map.get(intervals[mid][0]);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[map.get(intervals[i][0])] = ans;
        }
        return res;
    }
} 