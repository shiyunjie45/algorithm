package com.sky.algorithmleetcode;

/*
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。 找到所有出现两次的元素。 你可以不用到任何额外
空间并在O(n)时间复杂度内解决这个问题吗？ 示例：  输入: [4,3,2,7,8,2,3,1] 输出: [2,3]
*/

 java.util.ArrayList;
import java.util.List;

public class L442Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
       
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;  //利用数组下标和数组元素的映射进行匹配，获取相应下标
           
            if(nums[index] < 0){
                //nums[index]为负数说明之前已经将该位置改为负数了，说明出现了两次，添加到结果集中
                result.add(Math.abs(index + 1));
            }else{
                nums[index] = -nums[index]; //原来nums[index]不是负数，变成负数，表示该位置已经出现了一次
            }
        }
       
        return result;
    }
} 