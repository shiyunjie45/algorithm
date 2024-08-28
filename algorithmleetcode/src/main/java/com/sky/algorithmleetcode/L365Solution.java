package com.sky.algorithmleetcode;

/*
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？ 如果可以，最后请用以上水壶中的一或两个来盛
放取得的 z升 水。 你允许：  	装满任意一个水壶 	清空任意一个水壶 	从一个水壶向另外一个水壶倒水，直到装满或者倒空  示例 1: (From the f
amous "Die Hard" example) 输入: x = 3, y = 5, z = 4 输出: True  示例 2: 输入: x = 2, y =
 6, z = 5 输出: False
*/

 class L365Solution {

    private boolean flag = false; // 用于判断是否找到符合条件的解

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (z == 0) return true;

        // 使用DFS深度优先搜索寻找符合条件的解
        dfs(x, y, z, new HashSet<>(), 0, 0);
        return flag;
    }

    // 深度优先搜索
    private void dfs(int x, int y, int z, Set<Pair<Integer, Integer>> set, int curX, int curY) {
        if (flag) return;
        if (curX == z || curY == z || curX + curY == z) {
            flag = true;
            return;
        }
        if (set.contains(new Pair<>(curX, curY))) return;
        set.add(new Pair<>(curX, curY));

        // 倒满x
        dfs(x, y, z, set, x, curY);
        // 倒满y
        dfs(x, y, z, set, curX, y);
        // 清空x
        dfs(x, y, z, set, 0, curY);
        // 清空y
        dfs(x, y, z, set, curX, 0);
        // 从x向y倒水
        int moveXY = Math.min(x - curX, curY);
        dfs(x, y, z, set, curX + moveXY, curY - moveXY);
        // 从y向x倒水
        int moveYX = Math.min(y - curY, curX);
        dfs(x, y, z, set, curX - moveYX, curY + moveYX);
    }
} 