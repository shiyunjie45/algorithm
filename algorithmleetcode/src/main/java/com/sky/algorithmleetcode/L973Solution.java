package com.sky.algorithmleetcode;

/*
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 （这里，平面上两点之间的距离是欧几里德距离。） 你可以按
任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。   示例 1： 输入：points = [[1,3],[-2,2]], K = 1 输出：[[-2,
2]] 解释： (1, 3) 和原点之间的距离为 sqrt(10)， (-2, 2) 和原点之间的距离为 sqrt(8)， 由于 sqrt(8)  示例 2： 
输入：points = [[3,3],[5,-1],[-2,4]], K = 2 输出：[[3,3],[-2,4]] （答案 [[-2,4],[3,3]] 也会
被接受。）    提示：  	1 	-10000 	-10000
*/

 java.util.Arrays;

public class L973Solution {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        L973Solution solution = new L973Solution();
        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        int[][] res1 = solution.kClosest(points1, k1);
        System.out.println(Arrays.deepToString(res1)); // [[-2, 2]]

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        int[][] res2 = solution.kClosest(points2, k2);
        System.out.println(Arrays.deepToString(res2)); // [[3, 3], [-2, 4]]
    }

} 