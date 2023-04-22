package com.sky.algorithmleetcode;

import java.util.Random;

/**
 * @author syj
 * @version V1.0.0
 * @contact shiyunjie45@163.com
 * <ul>
 * @description 公共计时类
 * </ul>
 * @className Utils
 * @createdTime 2023/4/18 16:37
 */
public class Utils {
    long startTime = 0;
    public Utils(){
       this.startTime = System.currentTimeMillis();
    }

    public void setStartTime(){
        startTime = System.currentTimeMillis();
    }

    public void printTimeConsuming(){
        System.out.println(System.currentTimeMillis()-startTime);
    }

    // 生成指定长度、随机元素在指定范围内的整数数组
    static int[] generateRandomArray(int length, int min, int max) {
        Random random = new Random();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt((max - min + 1)>0?max - min + 1:Integer.MAX_VALUE) + min;
        }
        return nums;
    }
}
