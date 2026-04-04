package com.sky.algorithmleetcode;

/*
给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排
列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 的数字也同样不含前导零：以 arr 为
例，这意味着要么 arr == [0]，要么 arr[0] == 1。 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由
若干 0 和 1 组成的数组。   示例： 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1] 输出：[1,0,0,0,0] 解释：ar
r1 表示 11，arr2 表示 5，输出表示 16 。    提示：  	1 	1 	arr1 和 arr2 都不含前导零 	arr1[i] 为 0 或 1 
	arr2[i] 为 0 或 1
*/

 class L1073Solution {
    
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] res = new int[Math.max(n,m)+2];
        int i = n - 1, j = m - 1, k = res.length - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = (i >= 0) ? arr1[i--] : 0;
            int b = (j >= 0) ? arr2[j--] : 0;
            int sum = a + b + carry;
            res[k--] = sum & 1;
            carry = -(sum >> 1);
        }
        while (k+1 < res.length && res[k+1] == 0) k++;
        return Arrays.copyOfRange(res, k, res.length);
    }
} 