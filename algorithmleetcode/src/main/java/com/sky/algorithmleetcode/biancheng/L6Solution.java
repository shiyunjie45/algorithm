package com.sky.algorithmleetcode.biancheng;

import com.sky.algorithmleetcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;

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

    //时间复杂度0(n),空间复杂度0(1),算了n-1次
    static int getMax(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

    //时间复杂度o(n),空间复杂度不清楚,估算为o(n)如有误请指正,执行了3*n/2-2次次
    public static int get_max(int [] arr,int left,int right) {
        //如果数组不存在或者数组内没有元素
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //如果查找范围中仅有 2 个数字，则直接比较即可
        if(right - left <=1) {
            if(arr[left] >= arr[right]) {
                return arr[left];
            }
            return arr[right];
        }
        //等量划分成 2 个区域
        int middle = (right-left)/2 + left;
        int max_left = get_max(arr,left,middle);
        int max_right = get_max(arr,middle+1,right);
        if(max_left >= max_right) {
            return max_left;
        }else {
            return max_right;
        }
    }

    public static void main(String[] args) {
//        int[] arr = Utils.generateRandomArray(500,0,Integer.MAX_VALUE);
//        getMinAndMax(arr);
//
//        int max = get_max(arr,0,arr.length-1);
//        System.out.println("max:"+max);


        //说是求最大值最小值,实际只求了最大值
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(Utils.generateRandomArray(50,0,Integer.MAX_VALUE));
        }
        Utils utils = new Utils();
        for (int i = 0; i < list.size(); i++) {
            getMax(list.get(i));
        }
        utils.printTimeConsuming();
        for (int i = 0; i < list.size(); i++) {
            get_max(list.get(i),0,list.get(i).length-1);
        }
        utils.printTimeConsuming();
        //根据推论和实际测试可知分治算法性能并不比迭代好,
        //但是分治算法可以用上多线程,所以也有适合使用的场景
    }
}
