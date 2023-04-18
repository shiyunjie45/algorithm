package com.sky.algorithmleetcode;

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
}
