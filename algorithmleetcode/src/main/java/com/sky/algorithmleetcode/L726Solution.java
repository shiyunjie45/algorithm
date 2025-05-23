package com.sky.algorithmleetcode;

/*
给定一个化学式formula（作为字符串），返回每种原子的数量。 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。 如果数量大于 1，
原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。 两个化学式连在一起是新
的化学式。例如 H2O2He3Mg4 也是化学式。 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。 给定
一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数
量大于 1），以此类推。 示例 1:  输入: formula = "H2O" 输出: "H2O" 解释: 原子的数量是 {'H': 2, 'O': 1}。  
示例 2:  输入: formula = "Mg(OH)2" 输出: "H2MgO2" 解释: 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}
。  示例 3:  输入: formula = "K4(ON(SO3)2)2" 输出: "K4N2O14S4" 解释: 原子的数量是 {'K': 4, 'N':
 2, 'O': 14, 'S': 4}。  注意:  	所有原子的第一个字母为大写，剩余字母都是小写。 	formula的长度在[1, 1000]之间。 	f
ormula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
*/

 java.util.*;

public class L726Solution {
    public String countOfAtoms(String formula) {
        // 用TreeMap来存储所有原子及其数量，以保证字典序
        TreeMap<String, Integer> map = new TreeMap<>();
        // 将原子及其数量分别存入栈中
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        int i = 0;
        int n = formula.length();
        while (i < n) {
            char c = formula.charAt(i);
            i++;
            // 如果是左括号，将map入栈，map用于存储括号内的原子及其数量
            if (c == '(') {
                stack.push(map);
                map = new TreeMap<>();
            // 如果是右括号，将括号内的原子及其数量计算出来，乘上括号外面的数字，合并到map中
            } else if (c == ')') {
                int num = parseNum(formula, i); // 获取括号外面的数字
                i += Integer.toString(num).length();
                Map<String, Integer> tempMap = map;
                map = stack.pop();
                for (String key : tempMap.keySet()) {
                    map.put(key, tempMap.get(key) * num + map.getOrDefault(key, 0));
                }
            // 如果是大写字母，开始解析原子名称
            } else if (Character.isUpperCase(c)) {
                int j = i;
                while (j < n && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String atom = formula.substring(i - 1, j);
                i = j;
                int num = parseNum(formula, i); // 解析原子数量
                i += Integer.toString(num).length();
                map.put(atom, map.getOrDefault(atom, 0) + num);
            }
        }
        // 将map中的原子及其数量转换成字符串返回
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key);
            if (map.get(key) > 1) {
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }

    // 解析数字
    private int parseNum(String formula, int i) {
        if (i == formula.length() || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }
        int num = 0;
        while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + (formula.charAt(i) - '0');
            i++;
        }
        return num;
    }
} 