package com.sky.algorithmleetcode;

/*
对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
   示例： 输入: 28 输出: True 解释: 28 = 1 + 2 + 4 + 7 + 14    提示： 输入的数字 n 不会超过 100,000,0
00. (1e8)
*/

 class L507Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=1){ //1不是完美数
            return false;
        }
        int sum = 1; //num除以它本身一定为1，先计入总和中
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                sum += i; //加上因子i
                if(i!=num/i){ //避免重复加相同因子
                    sum += num/i; //加上因子num/i
                }
            }
        }
        return sum==num; //判断总和是否等于num
    }
} 