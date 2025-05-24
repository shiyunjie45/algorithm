package com.sky.algorithmleetcode;

/*
自除数 是指可以被它包含的每一位数除尽的数。 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。 
还有，自除数不允许包含 0 。 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。 示例 1：  输入： 上边界left = 1,
 下边界right = 22 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]  注意：  	每个输入参数的边界满
足 1 。
*/

 java.util.ArrayList;
import java.util.List;

public class L728Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (check(num)) {
                ans.add(num);
            }
        }
        return ans;
    }

    public boolean check(int num) {
        int n = num;
        while (n > 0) {
            int d = n % 10;
            if (d == 0 || num % d != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
} 