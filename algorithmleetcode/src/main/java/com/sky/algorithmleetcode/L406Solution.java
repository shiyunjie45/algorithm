package com.sky.algorithmleetcode;

/*
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建
这个队列。 注意： 总人数少于1100人。 示例  输入: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]] 输出: [[5
,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

 java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L406Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 将people按身高降序排列，若身高相同则按前面人数升序排列
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });

        // 将排序后的people插入到list中
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        // 将list转换成数组返回
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
} 