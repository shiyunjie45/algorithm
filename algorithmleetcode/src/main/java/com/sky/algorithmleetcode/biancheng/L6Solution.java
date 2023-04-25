package com.sky.algorithmleetcode.biancheng;

import com.sky.algorithmleetcode.utils.Utils;

/**
 * @author syj
 * @version V1.0.0
 * @contact jiejie12530@163.com
 * <ul>
 * @description 求数组最大值和最小值
 * </ul>
 * @className L6Solution
 * @createdTime 2023/4/25 21:29
 */
public class L6Solution {
    static int getMinAndMax(int[] arr){
        int max=arr[0],min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }else if(min>arr[i]){
                min = arr[i];
            }
        }
        System.out.println("max:"+max+"min:"+min);
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = Utils.generateRandomArray(500,0,Integer.MAX_VALUE);
        getMinAndMax(arr);
    }
}
