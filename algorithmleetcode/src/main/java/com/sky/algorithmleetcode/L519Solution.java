package com.sky.algorithmleetcode;

/*
题中给出一个 n_rows 行 n_cols 列的二维矩阵，且所有值被初始化为 0。要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，并返回该值
的位置下标 [row_id,col_id]；同样编写一个 reset 函数，将所有的值都重新置为 0。尽量最少调用随机函数 Math.random()，并且优化
时间和空间复杂度。 注意:  	1 	0 	当矩阵中没有值为 0 时，不可以调用 flip 函数 	调用 flip 和 reset 函数的次数加起来不会超过 1
000 次  示例 1： 输入: ["Solution","flip","flip","flip","flip"] [[2,3],[],[],[],[]] 输出
: [null,[0,1],[1,2],[1,0],[1,1]]  示例 2： 输入: ["Solution","flip","flip","reset","f
lip"] [[1,2],[],[],[],[]] 输出: [null,[0,0],[0,1],null,[0,0]] 输入语法解释： 输入包含两个列表：被调用
的子程序和他们的参数。Solution 的构造函数有两个参数，分别为 n_rows 和 n_cols。flip 和 reset 没有参数，参数总会以列表形式给出
，哪怕该列表为空
*/

import java.util.*;

public class L519Solution {

    private int rows;
    private int cols;
    private int total;
    private Map<Integer, Integer> map; // 将矩阵的下标用一个数表示，用 map 记录哪些位置已经翻转成 1 了

    public L519Solution(int n_rows, int n_cols) {
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
        map = new HashMap<>();
    }

    public int[] flip() {
        int rand = (int) (Math.random() * (total - map.size())); // 随机生成一个在范围内的数
        if (map.containsKey(rand)) { // 如果已经翻过了，就递归调用 flip 方法，直到找到没有翻转过的位置
            int index = map.get(rand);
            int[] res = flip();
            map.put(rand, res[0] * cols + res[1]);
            return res;
        } else {
            map.put(rand, rand);
            return new int[] { rand / cols, rand % cols };
        }
    }

    public void reset() {
        map.clear();
    }
} 