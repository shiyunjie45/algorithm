package com.sky.algorithmleetcode;

/*
我们给出了一个（轴对齐的）矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形 i
 左下角的坐标，（x2，y2）是该矩形右上角的坐标。 找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，请返回它对 10 ^ 9 + 7 取模的结果。 
 示例 1： 输入：[[0,0,2,2],[1,0,2,3],[1,0,3,1]] 输出：6 解释：如图所示。  示例 2： 输入：[[0,0,10000000
00,1000000000]] 输出：49 解释：答案是 10^18 对 (10^9 + 7) 取模的结果， 即 (10^9)^2 → (-7)^2 = 49 
。  提示：  	1 	rectanges[i].length = 4 	0 	矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位
有符号整数来保存面积结果。
*/

 class L850Solution {

    private static final int MOD = 1000000007;

    public int rectangleArea(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            return 0;
        }
        List<int[]> coordinates = new ArrayList<>();
        for (int[] rect : rectangles) {
            coordinates.add(new int[]{rect[0], rect[1], 0});
            coordinates.add(new int[]{rect[0], rect[3], 1});
            coordinates.add(new int[]{rect[2], rect[1], 2});
            coordinates.add(new int[]{rect[2], rect[3], 3});
        }
        Collections.sort(coordinates, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        TreeMap<Integer, Integer> yMap = new TreeMap<>();
        int prevX = coordinates.get(0)[0];
        int prevY = coordinates.get(0)[1];
        yMap.put(prevY, 1);
        long area = 0;
        for (int i = 1; i < coordinates.size(); i++) {
            int[] cur = coordinates.get(i);
            int curX = cur[0];
            int curY = cur[1];
            int type = cur[2];
            int width = curX - prevX;
            int height = 0;
            if (!yMap.isEmpty()) {
                height = yMap.lastKey() - yMap.firstKey();
            }
            area += (long) width * height;
            area %= MOD;
            if (type == 0) {
                yMap.put(curY, yMap.getOrDefault(curY, 0) + 1);
            } else if (type == 1) {
                yMap.put(curY, yMap.get(curY) - 1);
                if (yMap.get(curY) == 0) {
                    yMap.remove(curY);
                }
            } else if (type == 2) {
                yMap.remove(curY);
            } else {
                yMap.put(curY, yMap.getOrDefault(curY, 0) + 1);
            }
            prevX = curX;
        }
        return (int) area;
    }
} 