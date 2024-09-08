package com.sky.algorithmleetcode;

/*
设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。  	insert(val)：当元素 val 不存在时，向集合中插入该项。 	remove
(val)：元素 val 存在时，从集合中移除该项。 	getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。  示例 :  // 初始
化一个空的集合。 RandomizedSet randomSet = new RandomizedSet(); // 向集合中插入 1 。返回 true 表示 
1 被成功地插入。 randomSet.insert(1); // 返回 false ，表示集合中不存在 2 。 randomSet.remove(2); //
 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。 randomSet.insert(2); // getRandom 应随机返回 1 或 2
 。 randomSet.getRandom(); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。 randomSet.remove(1)
; // 2 已在集合中，所以返回 false 。 randomSet.insert(2); // 由于 2 是集合中唯一的数字，getRandom 总是返回 
2 。 randomSet.getRandom();
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class L380Solution {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public L380Solution() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
} 