package com.sky.algorithmleetcode;

/*
给出一个区间的集合，请合并所有重叠的区间。 示例 1: 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[
15,18]] 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].  示例 2: 输入: [[1,4],[4,5]] 输出: [[1,
5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        
        // 对所有区间按起点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // 新建一个List存储合并后的区间
        List<int[]> merged = new ArrayList<>();
        // 初始化第一个区间
        merged.add(new int[]{intervals[0][0], intervals[0][1]});
        
        for(int i = 1; i < intervals.length; i++){
            int[] currInterval = intervals[i];
            int[] lastInterval = merged.get(merged.size() - 1);
            
            // 当前区间起点在上一个区间里或重叠
            if(currInterval[0] <= lastInterval[1]){
                lastInterval[1] = Math.max(currInterval[1], lastInterval[1]);
            }
            else{
                merged.add(new int[]{currInterval[0], currInterval[1]});
            }
        }
        
        // 将List转成二维数组
        int[][] result = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++){
            result[i] = merged.get(i);
        }
        
        return result;
    }
} 