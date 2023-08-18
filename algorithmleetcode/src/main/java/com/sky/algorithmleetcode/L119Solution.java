package com.sky.algorithmleetcode;

/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。  在杨辉三角中，每个数是它左上方和右上方的数的和。 示例: 输入: 3 输出: [1,3,
3,1]  进阶： 你可以优化你的算法到 O(k) 空间复杂度吗？
*/

 class L119Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum <= rowIndex; rowNum++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j)) ;
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }
} 