package com.sky.algorithmleetcode;

/*
给定一个从1 到 n 排序的整数列表。 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。 第二步，在剩下的数字中，从右到左，从倒数第一个
数字开始，每隔一个数字进行删除，直到列表开头。 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。 返回长度为 n 的列表中，最后剩下的数字。
 示例：  输入: n = 9, 1 2 3 4 5 6 7 8 9 2 4 6 8 2 6 6 输出: 6
*/

import java.util.ArrayList;
import java.util.List;

public class L390Solution {
    public int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean fromLeft = true;
        while (list.size() > 1) {
            if (fromLeft) {
                for (int i = 0; i < list.size(); i += 2) {
                    list.remove(i);
                }
            } else {
                for (int i = list.size() - 1; i >= 0; i -= 2) {
                    list.remove(i);
                }
            }
            fromLeft = !fromLeft;
        }
        return list.get(0);
    }
} 