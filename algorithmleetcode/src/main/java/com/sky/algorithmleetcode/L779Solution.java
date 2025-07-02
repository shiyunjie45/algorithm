package com.sky.algorithmleetcode;

/*
在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）  例
子: 输入: N = 1, K = 1 输出: 0 输入: N = 2, K = 1 输出: 0 输入: N = 2, K = 2 输出: 1 输入: N = 
4, K = 5 输出: 1 解释: 第一行: 0 第二行: 01 第三行: 0110 第四行: 01101001  注意：  	N 的范围 [1, 30]. 
	K 的范围 [1, 2^(N-1)].
*/

 class L779Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        
        // 定位目标数字所在的行
        int row = 1;
        while (K > Math.pow(2, row - 1)) {
            row++;
        }
        
        // 计算目标数字在上一行的索引位置
        int index = K - (int)Math.pow(2, row - 2);
        
        // 递归获取上一行对应位置上的数字
        int parent = kthGrammar(N - 1, index);
        
        // 根据上一行的数字得到目标数字
        if (parent == 0) {
            return (K % 2 == 0) ? 1 : 0;
        } else {
            return (K % 2 == 0) ? 0 : 1;
        }
    }
} 