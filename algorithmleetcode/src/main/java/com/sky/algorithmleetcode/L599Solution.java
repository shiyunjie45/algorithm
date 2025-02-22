package com.sky.algorithmleetcode;

/*
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。 你需要帮助他们用最少的索引和找出他们共同喜爱
的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。 示例 1: 输入: ["Shogun", "Tapioca Expre
ss", "Burger King", "KFC"] ["Piatti", "The Grill at Torrey Pines", "Hungry Hunte
r Steakhouse", "Shogun"] 输出: ["Shogun"] 解释: 他们唯一共同喜爱的餐厅是“Shogun”。  示例 2: 输入: ["S
hogun", "Tapioca Express", "Burger King", "KFC"] ["KFC", "Shogun", "Burger King"
] 输出: ["Shogun"] 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。  提示:  	两个列表的长度范围
都在 [1, 1000]内。 	两个列表中的字符串的长度将在[1，30]的范围内。 	下标从0开始，到列表的长度减1。 	两个列表都没有重复的元素。
*/

 java.util.*;

public class L599Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return new String[0];
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;

        List<String> list = new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if(sum == minSum) {
                    list.add(list2[i]);
                } else if(sum < minSum) {
                    list = new ArrayList<>();
                    list.add(list2[i]);
                    minSum = sum;
                }
            }
        }

        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        L599Solution l599Solution = new L599Solution();
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] res1 = l599Solution.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(res1));

        String[] list3 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list4 = new String[]{"KFC", "Shogun", "Burger King"};
        String[] res2 = l599Solution.findRestaurant(list3, list4);
        System.out.println(Arrays.toString(res2));
    }
} 