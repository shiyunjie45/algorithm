package com.sky.algorithmleetcode;

/*
城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些
建筑物形成的天际线（图B）。    每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，
Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的
完美矩形。 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
 。 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点
是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。 说
明:  	任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。 	输入列表已经按左 x 坐标 Li  进行升序排列。 	输出列表必须按 x 位排序。
 	输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条
高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
*/

import java.util.*;

public class L218Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>(); // 保存天际线的结果集
        List<int[]> height = new ArrayList<>(); // 保存每个建筑物的左右边缘和高度信息
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]}); // 左边缘
            height.add(new int[]{b[1], b[2]}); // 右边缘
        }
        // 按照横坐标排序
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a); // 保存每个建筑物的高度信息
        queue.offer(0); // 先加入 ground 情况，方便代码实现

        int preMaxHeight = 0; // 记录前一次的最大高度
        for (int[] h : height) {
            if (h[1] < 0) { // 左边缘，高度为负
                queue.offer(-h[1]); // 加入高度信息
            } else { // 右边缘，高度为正
                queue.remove(h[1]); // 移除高度信息
            }

            int currMaxHeight = queue.peek(); // 当前最大高度
            if (currMaxHeight != preMaxHeight) { // 高度有变化，需要更新结果集合
                List<Integer> point = new ArrayList<>();
                point.add(h[0]);
                point.add(currMaxHeight);
                res.add(point);
                preMaxHeight = currMaxHeight; // 更新前一次最大高度值
            }
        }
        return res;
    }
} 