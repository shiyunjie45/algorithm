package com.sky.algorithmleetcode;

/*
设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。 注意: 允许出现重复元素。  	insert(val)：向集合中插入元素 val。 	
remove(val)：当 val 存在时，从集合中移除一个 val。 	getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中
的数量呈线性相关。  示例: // 初始化一个空的集合。 RandomizedCollection collection = new RandomizedCol
lection(); // 向集合中插入 1 。返回 true 表示集合不包含 1 。 collection.insert(1); // 向集合中插入另一个 1
 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。 collection.insert(1); // 向集合中插入 2 ，返回 true 。
集合现在包含 [1,1,2] 。 collection.insert(2); // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2
 。 collection.getRandom(); // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。 collection.remov
e(1); // getRandom 应有相同概率返回 1 和 2 。 collection.getRandom();
*/

import java.util.*;

class L381Solution {
    private List<Integer> nums; // 保存插入的元素
    private Map<Integer, Set<Integer>> map; // 保存元素在nums中出现的下标集合
    private Random rand; // 用于产生随机数

    public L381Solution() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        nums.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            map.get(val).add(nums.size() - 1);
            return true;
        } else {
            map.get(val).add(nums.size() - 1);
            return false;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        int indexToRemove = map.get(val).iterator().next(); // 获取一个要删除的下标
        int lastNum = nums.get(nums.size() - 1); // 获取nums中最后一个元素
        nums.set(indexToRemove, lastNum); // 将最后一个元素移动到要删除的位置上
        map.get(lastNum).remove(nums.size() - 1); // 更新最后一个元素在map中的位置
        map.get(val).remove(indexToRemove); // 删除要删除的元素在map中的位置
        if (indexToRemove != nums.size() - 1) { // 如果删除的不是最后一个元素，那么加入到nums中的最后一个元素位置的set集合中
            map.get(lastNum).add(indexToRemove);
        }
        nums.remove(nums.size() - 1); // 删除最后一个元素
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
} 