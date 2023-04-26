package com.sky.algorithmleetcode.biancheng;

/**
 * @author syj
 * @version V1.0.0
 * @contact jiejie12530@163.com
 * <ul>
 * @description 汉诺塔问题
 * </ul>
 * @className L7Solution
 * @createdTime 2023/4/26 1:19
 */
public class L7Solution {
    // 统计移动次数
    public static int i = 1;
    public static void hanoi(int num, char source, char target, char auxiliary) {
        // 如果圆盘数量仅有 1 个，则直接从起始柱移动到目标柱
        if (num == 1) {
            System.out.println("第" + i + "次:从" + source + "移动到" + target);
            i++;
        } else {
            // 递归调用 hanoi() 函数，将 num-1 个圆盘从起始柱移动到辅助柱上
            hanoi(num - 1, source, auxiliary, target);
            // 将起始柱上剩余的最后一个大圆盘移动到目标柱上
            System.out.println("第" + i + "次:从" + source + "移动到" + target);
            i++;
            // 递归调用 hanoi() 函数，将辅助柱上的 num-1 圆盘移动到目标柱上
            hanoi(num - 1, auxiliary, target, source);
        }
    }

    public static void main(String[] args) {
        // 以移动 3 个圆盘为例，起始柱、目标柱、辅助柱分别用 A、B、C 表示
        hanoi(10, 'A', 'B', 'C');
    }
}
