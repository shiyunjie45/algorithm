package com.sky.algorithmleetcode;

/*
给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。 返回这两个区间列表的交集。 （形式上，闭区间 [a, b]（其中 a ）表示实数 
x 的集合，而 a 。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）   示例：  输入
：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]] 输出：[[1,2
],[5,5],[8,10],[15,23],[24,24],[25,25]] 注意：输入和所需的输出都是区间对象组成的列表，而不是数组或列表。    提示： 
 	0 	0 	0
*/

 java.util.ArrayList;
import java.util.List;

public class L986Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> resultList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if (a[1] < b[0]) {
                i++;
            } else if (b[1] < a[0]) {
                j++;
            } else {
                int start = Math.max(a[0], b[0]);
                int end = Math.min(a[1], b[1]);
                resultList.add(new int[]{start, end});
                if (a[1] < b[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        int[][] resultArray = new int[resultList.size()][2];
        for (i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }
} 