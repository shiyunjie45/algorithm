package com.sky.algorithmleetcode;

/*
我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正
方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。  示例 1: rectangles = 
[  [1,1,3,3],  [3,1,4,2],  [3,2,4,4],  [1,3,2,4],  [2,3,3,4] ] 返回 true。5个矩形一起可以精
确地覆盖一个矩形区域。     示例 2: rectangles = [  [1,1,2,3],  [1,3,2,4],  [3,1,4,2],  [3,2,4
,4] ] 返回 false。两个矩形之间有间隔，无法覆盖成一个矩形。     示例 3: rectangles = [  [1,1,3,3],  [3,1,4
,2],  [1,3,2,4],  [3,2,4,4] ] 返回 false。图形顶端留有间隔，无法覆盖成一个矩形。     示例 4: rectangles 
= [  [1,1,3,3],  [3,1,4,2],  [1,3,2,4],  [2,2,4,4] ] 返回 false。因为中间有相交区域，虽然形成了矩形，
但不是精确覆盖。
*/

import java.util.*;

public class L391Solution {
    private class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Rectangle {
        Point lb, rt;
        public Rectangle(int lbX, int lbY, int rtX, int rtY) {
            lb = new Point(lbX, lbY);
            rt = new Point(rtX, rtY);
        }

        public int getArea() {
            return (rt.x - lb.x) * (rt.y - lb.y);
        }

        public boolean contains(Rectangle other) {
            return lb.x <= other.lb.x && lb.y <= other.lb.y && rt.x >= other.rt.x && rt.y >= other.rt.y;
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int area = 0;
        Set<String> set = new HashSet<>();

        for (int[] rect : rectangles) {
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            Rectangle r = new Rectangle(rect[0], rect[1], rect[2], rect[3]);
            String lbStr = r.lb.x + "," + r.lb.y, rtStr = r.rt.x + "," + r.rt.y;
            String lrtStr = r.lb.x + "," + r.rt.y, rlbStr = r.rt.x + "," + r.lb.y;

            if (!set.add(lbStr)) {
                set.remove(lbStr);
            }
            if (!set.add(rtStr)) {
                set.remove(rtStr);
            }
            if (!set.add(lrtStr)) {
                set.remove(lrtStr);
            }
            if (!set.add(rlbStr)) {
                set.remove(rlbStr);
            }
        }

        Rectangle big = new Rectangle(minX, minY, maxX, maxY);
        if (big.getArea() != area) {
            return false;
        }

        if (set.size() != 4) {
            return false;
        }

        Rectangle[] array = new Rectangle[set.size()];
        Iterator<String> it = set.iterator();
        for (int i = 0; i < array.length; i++) {
            String[] str = it.next().split(",");
            int x = Integer.parseInt(str[0]), y = Integer.parseInt(str[1]);
            array[i] = new Rectangle(x, y, x, y);
        }

        for (Rectangle r : array) {
            if (!r.contains(big)) {
                boolean flag = false;
//                for (Rectangle other : rectangles) {
//                    if (other.contains(r)) {
//                        flag = true;
//                        break;
//                    }
//                }
                if (!flag) {
                    return false;
                }
            }
        }

        return true;
    }
} 