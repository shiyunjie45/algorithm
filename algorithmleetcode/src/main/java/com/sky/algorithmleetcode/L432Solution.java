package com.sky.algorithmleetcode;

/*
请你实现一个数据结构支持以下操作：  	Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。 
	Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事
情。key 保证不为空字符串。 	GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。 	GetMinKey
() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。    挑战： 你能够以 O(1) 的时间复杂度实现所有操作吗？
*/

 java.util.*;

class L432Solution {

    private Map<String, Integer> keyToValue;
    private Map<Integer, LinkedHashSet<String>> valueToKeys;
    private int minVal;
    private int maxVal;

    /** Initialize your data structure here. */
    public L432Solution() {
        keyToValue = new HashMap<>();
        valueToKeys = new HashMap<>();
        minVal = Integer.MAX_VALUE;
        maxVal = Integer.MIN_VALUE;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int newVal = keyToValue.getOrDefault(key, 0) + 1;
        keyToValue.put(key, newVal);

        //update min and max values
        minVal = Math.min(minVal, newVal);
        maxVal = Math.max(maxVal, newVal);

        //update valueToKeys
        valueToKeys.computeIfAbsent(newVal, k -> new LinkedHashSet<>()).add(key);

        //if the previous value of the key was not 0, then remove it from the corresponding valueToKeys set
        if (newVal > 1) {
            valueToKeys.get(newVal - 1).remove(key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyToValue.containsKey(key)) {
            return;
        }

        int oldVal = keyToValue.get(key);
        if (oldVal == 1) {
            keyToValue.remove(key);
            valueToKeys.get(1).remove(key);
        } else {
            int newVal = oldVal - 1;
            keyToValue.put(key, newVal);

            //update min and max values
            minVal = Math.min(minVal, newVal);
            maxVal = Math.max(maxVal, newVal);

            //update valueToKeys
            valueToKeys.computeIfAbsent(newVal, k -> new LinkedHashSet<>()).add(key);
            valueToKeys.get(oldVal).remove(key);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (valueToKeys.isEmpty()) {
            return "";
        }
        LinkedHashSet<String> set = valueToKeys.get(maxVal);
        return set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (valueToKeys.isEmpty()) {
            return "";
        }
        LinkedHashSet<String> set = valueToKeys.get(minVal);
        return set.iterator().next();
    }
} 