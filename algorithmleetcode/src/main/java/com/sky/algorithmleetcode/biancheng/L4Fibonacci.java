package com.sky.algorithmleetcode.biancheng;

/**
 * @author syj
 * @version V1.0.0
 * @contact jiejie12530@163.com
 * <ul>
 * @description 生成斐波那契数列的函数
 * </ul>
 * @className Fibonacci
 * @createdTime 2023/4/25 0:11
 */
public class L4Fibonacci {
    static int fibonacci(int num1,int num2){
        if (num1+num2>10000000){
            return 0;
        }else{
            if (num2==1){
                System.out.print(num1+" ");
                System.out.print(num2+" ");
            }
            else{
                System.out.print(num2+" ");
            }
            fibonacci(num2,num1+num2);
        }
        return 0;
    }

    // n 表示求数列中第 n 个位置上的数的值
    public static int fibonacci(int n) {
        // 设置结束递归的限制条件
        if (n == 1 || n == 2) {
            return 1;
        }
        // F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        fibonacci(1,1);
        System.out.println();
        // 输出前 9 个数
        for (int i = 1; i <= 9; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
