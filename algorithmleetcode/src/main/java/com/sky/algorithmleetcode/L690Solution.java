package com.sky.algorithmleetcode;

/*
给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15,
 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3
也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重
要度之和。 示例 1:  输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1 输出: 11 解释: 员工1自身的重要
度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。  注意:  	一个员工最多有一个直系领导，但是
可以有多个直系下属 	员工数量不超过2000。
*/

 java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class L690Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int result = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            result += e.importance;
            for (int subId : e.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        return result;
    }
} 