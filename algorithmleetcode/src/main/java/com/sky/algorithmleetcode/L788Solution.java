package com.sky.algorithmleetcode;

/*
我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。 如果一个数的每位
数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋
转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。 现在我们有一个正整数 N, 计算从 1 到 N 中有
多少个数 X 是好数？   示例： 输入: 10 输出: 4 解释: 在[1, 10]中有四个好数： 2, 5, 6, 9。 注意 1 和 10 不是好数, 因
为他们在旋转之后不变。    提示：  	N 的取值范围是 [1, 10000]。
*/

 class L788Solution {
    public int rotatedDigits(int N) {
        int count = 0;//计数器，记录好数的个数
        for (int i = 1; i <= N; i++) {//从1到N的遍历
            if (isGoodNumber(i)) {//如果i是好数，则计数器+1
                count++;
            }
        }
        return count;//返回计数器的值
    }
    
    private boolean isGoodNumber(int n) {//判断是否是好数的方法
        boolean isGood = false;//标志位，初始值为false
        while (n > 0) {//遍历n的每一位数字
            int digit = n % 10;//获取n的个位数字
            if (digit == 3 || digit == 4 || digit == 7) {//如果digit是3、4或7，则n不是好数
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {//如果digit是2、5、6或9，则n是好数
                isGood = true;
            }
            n /= 10;//去掉n的个位数字
        }
        return isGood;//返回标志位的值
    }
} 