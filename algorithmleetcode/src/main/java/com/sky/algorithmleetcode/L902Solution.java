package com.sky.algorithmleetcode;

/*
我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。） 现在
，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这
样的数字。 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。   示例 1： 输入：D = ["1","3","5","7"], N = 100 
输出：20 解释： 可写出的 20 个数字是： 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 
57, 71, 73, 75, 77.  示例 2： 输入：D = ["1","4","9"], N = 1000000000 输出：29523 解释： 我们可
以写 3 个一位数字，9 个两位数字，27 个三位数字， 81 个四位数字，243 个五位数字，729 个六位数字， 2187 个七位数字，6561 个八位数字
和 19683 个九位数字。 总共，可以使用D中的数字写出 29523 个整数。   提示：  	D 是按排序顺序的数字 '1'-'9' 的子集。 	1
*/

public class L902Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String strN = String.valueOf(N);
        int n = strN.length();
        // 用digitCount[i]存储i位数中可以使用D中数字组成的数的个数
        int[] digitCount = new int[n+1];
        digitCount[0] = 1;
        // pre表示之前位数的组合数
        int pre = 1;
        for(int i = 1; i <= n; i++){
            int num = strN.charAt(i-1) - '0';
            // 找到最后一个小于等于num的数字的下标index
            int index = binarySearch(D, num);
            if(index < D.length && D[index].charAt(0) == num){
                // D中存在当前数字num，则在之前位数的组合中随意选择，再乘上D中当前数字的组合数
                digitCount[i] = pre * D.length + digitCount[i-1];
            }else{
                // D中不存在当前数字num，则只能在之前位数的组合中选择
                digitCount[i] = pre * index + digitCount[i-1];
            }
            pre = digitCount[i];
        }
        return digitCount[n] - 1; // 减去0的情况
    }
    
    // 二分查找找到最后一个小于等于num的数字的下标
    private int binarySearch(String[] D, int num){
        int left = 0, right = D.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(Integer.parseInt(D[mid]) == num){
                return mid;
            }else if(Integer.parseInt(D[mid]) < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
} 