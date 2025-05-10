package com.sky.algorithmleetcode;

/*
给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。 对它进行优化使其尽量少调用系统方法 Ma
th.random() 。 提示:  	1 	0 	[0, N) 不包含 N，详细参见 interval notation 。  示例 1:  输入: ["So
lution","pick","pick","pick"] [[1,[]],[],[],[]] 输出: [null,0,0,0]  示例 2:  输入: ["S
olution","pick","pick","pick"] [[2,[]],[],[],[]] 输出: [null,1,1,1]  示例 3:  输入: ["
Solution","pick","pick","pick"] [[3,[1]],[],[],[]] Output: [null,0,0,2]  示例 4:  
输入: ["Solution","pick","pick","pick"] [[4,[2]],[],[],[]] 输出: [null,1,3,1]  输入语法说
明： 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N 和黑名单 B。pick 没有参数，输入参数是一个列表，即使参数为空，
也会输入一个 [] 空列表。
*/

 java.util.*;
public class L710Solution {
    private int n;
    private HashMap<Integer, Integer> map;
    private Random rand;
    
    public L710Solution(int N, int[] blacklist) {
        n = N;
        map = new HashMap<>();
        for (int b: blacklist) {
            map.put(b, -1); //将黑名单中的数值标记为-1
        }
        int blackSize = blacklist.length;
        int whiteSize = n - blackSize;
        for (int b: blacklist) {
            if (b < whiteSize) {
                //每次将映射到白名单中的数值与最后一个白名单数值交换，最后一个白名单数值变为黑名单数值
                while (map.containsKey(whiteSize - 1)) {
                    whiteSize--;
                }
                map.put(b, whiteSize - 1);
                whiteSize--;
            }
        }
        rand = new Random();
    }
    
    public int pick() {
        int num = rand.nextInt(n);
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return num;
    }
} 