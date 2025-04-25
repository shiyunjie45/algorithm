package com.sky.algorithmleetcode;

/*
给一非空的单词列表，返回前 k 个出现次数最多的单词。 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 示例 1：  
输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2 输出: ["i", "love"] 解析
: "i" 和 "love" 为出现次数最多的两个单词，均为2次。   注意，按字母顺序 "i" 在 "love" 之前。    示例 2：  输入: ["th
e", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4 输出: [
"the", "is", "sunny", "day"] 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，   出现
次数依次为 4, 3, 2 和 1 次。    注意：  	假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 	输入的单词均由小写字母组成。    扩展练习
：  	尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
*/

 java.util.*;

public class L692Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 统计每个单词的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 使用小根堆存储k个出现次数最多的单词
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.count.equals(o2.count)) { // 出现次数相同按字典序倒序
                    return o2.word.compareTo(o1.word);
                } else { // 出现次数不同按次数正序
                    return o1.count - o2.count;
                }
            }
        });

        // 遍历统计结果
        for (String key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key))); // 加入小根堆
            if (pq.size() > k) { // 小根堆中保留k个出现次数最多的单词
                pq.poll();
            }
        }

        // 把小根堆中的单词转换为List并翻转，使单词出现次数由高到低排序
        LinkedList<Pair> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.addFirst(pq.poll());
        }

        // 只保留前k个出现次数最多的单词
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).word);
        }
        return result;
    }

    class Pair {
        String word;
        Integer count;

        Pair(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
} 