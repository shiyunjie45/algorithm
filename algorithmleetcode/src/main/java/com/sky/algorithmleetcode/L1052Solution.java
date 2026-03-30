package com.sky.algorithmleetcode;

/*
今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结
束后离开。 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时
，那一分钟的顾客就会不满意，不生气则他们是满意的。 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 请你返回这一
天营业下来，最多有多少客户能够感到满意的数量。   示例： 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,
1,0,1,0,1], X = 3 输出：16 解释： 书店老板在最后 3 分钟保持冷静。 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 
5 = 16.    提示：  	1 	0 	0
*/

 class L1052Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int satisfied = 0; // 初始满意的客户数量
        int[] sum = new int[len + 1]; // 客户数量的前缀和
        int[] happy = new int[len]; // 生气时客户满意的前缀和
        int maxHappy = 0; // 不使用技巧时的最大客户满意数量

        // 遍历每个时刻，计算出客户数量的前缀和和不使用技巧时的最大客户满意数量
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + customers[i];
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                happy[i] = happy[i - 1] + customers[i]; // 计算不使用技巧时的生气时客户满意的前缀和
            }
            if (i < X) { // 不使用技巧时，前X个时刻就是不生气的
                maxHappy += happy[i];
            }
        }

        int tmpHappy = maxHappy;
        for (int i = X; i < len; i++) {
            tmpHappy = tmpHappy - happy[i - X] + happy[i]; // 计算使用技巧后的生气时客户满意的数量
            maxHappy = Math.max(maxHappy, tmpHappy); // 更新最大的客户满意数量
        }

        return satisfied + maxHappy; // 总客户满意数量等于不使用技巧时的满意数量和使用技巧后的满意数量之和
    }
} 