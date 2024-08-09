package com.sky.algorithmleetcode;

/*
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK
（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。 说明:  	如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JF
K", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前 	所有的机场都用三个大写字母表示（机场代码）。 	假定所有机票至少存在一种合理的
行程。  示例 1: 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]] 
输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]  示例 2: 输入: [["JFK","SFO"],["JFK","ATL"],
["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]] 输出: ["JFK","ATL","JFK","SFO","ATL","S
FO"] 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
*/

import java.util.*;

class L332Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>(); // 创建哈希表，key为起点，value为优先队列（按字典序）存放所有可达的下一站

    LinkedList<String> list = new LinkedList<>(); // 记录结果

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).offer(to); // 添加到优先队列
        }
        dfs("JFK"); // 从 JFK 出发开始遍历
        return list;
    }

    void dfs(String curr) {
        // 如果哈希表中存在key为当前点的站
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String next = map.get(curr).poll(); // 取出字典序最小的站
            dfs(next); // 继续遍历下一站
        }
        list.addFirst(curr); // 所有相邻的点都已遍历，将自己插入到结果的最前面
    }
} 