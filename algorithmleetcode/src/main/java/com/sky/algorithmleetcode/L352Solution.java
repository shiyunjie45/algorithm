package com.sky.algorithmleetcode;

/*
给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。 例如，假设数据流中的整数为 1，3，7，2，6，…，每次
的总结为： [1, 1] [1, 1], [3, 3] [1, 1], [3, 3], [7, 7] [1, 3], [7, 7] [1, 3], [6, 7]
    进阶： 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 提示： 特别感谢 @yunhong 提供了本问题和其测试用例。
*/

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class L352Solution {

    private TreeMap<Integer, Interval> treeMap;

    public L352Solution() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int num) {
        if (treeMap.containsKey(num)) {
            return;
        }
        Integer lower = treeMap.lowerKey(num);
        Integer higher = treeMap.higherKey(num);
        if (lower != null && higher != null && treeMap.get(lower).end + 1 == num && higher == num + 1) {
            treeMap.get(lower).end = treeMap.get(higher).end;
            treeMap.remove(higher);
        } else if (lower != null && treeMap.get(lower).end + 1 >= num) {
            treeMap.get(lower).end = Math.max(treeMap.get(lower).end, num);
        } else if (higher != null && higher == num + 1) {
            treeMap.put(num, new Interval(num, treeMap.get(higher).end));
            treeMap.remove(higher);
        } else {
            treeMap.put(num, new Interval(num, num));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(treeMap.values());
    }
}

class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
} 