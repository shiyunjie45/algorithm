package com.sky.algorithmleetcode.utils;

import java.util.*;

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
        System.out.println("耗时:"+(System.currentTimeMillis()-startTime));
        this.startTime = System.currentTimeMillis();
    }

    public void printTimeConsuming(String prefix) {
        System.out.println(prefix+(System.currentTimeMillis()-startTime));
        this.startTime = System.currentTimeMillis();
    }

    // 生成指定长度、随机元素在指定范围内的整数数组

    /**
     *生成随机数组
     * @param length 数组长度
     * @param min 数组中元素的最小值
     * @param max 数组中元素的最大值
     * @return
     */
    public static int[] generateRandomArray(int length, int min, int max) {
        Random random = new Random();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt((max - min + 1)>0?max - min + 1:Integer.MAX_VALUE) + min;
        }
        return nums;
    }

    /**
     * 生成正序的数组
     * @param size 数组长度
     * @param min 数组中元素的最小值
     * @param max 数组中元素的最大值
     * @return
     */
    public static int[] generateRandomSortedArray(int size, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt((max - min + 1)>0?max - min + 1:Integer.MAX_VALUE) + min;
            arr[i] = num;
        }
        Arrays.sort(arr);
        return arr;
    }

    /**
     * 将整型数组转成字符串形式
     * @param nums
     * @return
     */
    public static String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+-=[]{}|;':\",./<>?";

    /**
     * 生成一个包含中文,数字,符号,字幕的随机字符串的代码
     * @param length
     * @return
     */
    public static String generateRandomString(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (rand.nextBoolean()) {
                char c = CHARACTERS.charAt(rand.nextInt(CHARACTERS.length()));
                sb.append(c);
            } else {
                char c = (char) (0x4e00 + rand.nextInt(0x9fa5 - 0x4e00 + 1));
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 生成指定长度不重复的字符串
     * @param length
     * @return
     */
    public static String generateRandomNonRepeatingString(int length) {
        if (length < 0 || length > CHARACTERS.length() + (0x9fa5 - 0x4e00 + 1)) {
            throw new IllegalArgumentException("Length must be between 0 and the maximum number of unique characters");
        }
        Random rand = new Random();
        List<Character> characters = new ArrayList<>();
        for (char c : CHARACTERS.toCharArray()) {
            characters.add(c);
        }
        for (int i = 0x4e00; i <= 0x9fa5; i++) {
            characters.add((char) i);
        }
        Collections.shuffle(characters, rand);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.get(i));
        }
        return sb.toString();
    }
}
