package com.sky.algorithmleetcode;

/*
现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。 使用三元组表示金字塔的堆砌规则如下： 对于三元组(A, B, C) ，“C”为顶
层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。 初始时，给定金字塔的基层 
bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。 如果可以由基层一直堆到塔尖就返回 true，否
则返回 false。   示例 1: 输入: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"] 输出
: true 解析: 可以堆砌成这样的金字塔:   A  / \  G  E / \ / \ B  C  D 因为符合('B', 'C', 'G'), ('C'
, 'D', 'E') 和 ('G', 'E', 'A') 三种规则。  示例 2: 输入: bottom = "AABA", allowed = ["AAA"
, "AAB", "ABA", "ABB", "BAC"] 输出: false 解析: 无法一直堆到塔尖。 注意, 允许存在像 (A, B, C) 和 (A, 
B, D) 这样的三元组，其中 C != D。    注意：  	bottom 的长度范围在 [2, 8]。 	allowed 的长度范围在[0, 200]。 
	方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
*/

 java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L756Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // 转化allowed为Map结构，方便查询
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s.substring(2));
        }
        return pyramid(bottom, "", map);
    }

    // 递归函数，根据当前bottom和上一层top判断是否可以继续构建下一层
    private boolean pyramid(String bottom, String top, Map<String, List<String>> map) {
        // 当前已经构建了最后一层，返回true
        if (bottom.length() == 1) {
            return true;
        }
        // 如果当前的bottom已经在Map中存在，直接遍历可能的top并递归判断下一层
        if (map.containsKey(bottom)) {
            for (String s : map.get(bottom)) {
                if (pyramid(s, "", map)) {
                    return true;
                }
            }
        }
        // 否则构建当前bottom对应的top，并递归判断下一层
        else {
            for (int i = 0; i < bottom.length() - 1; i++) {
                String b = bottom.substring(i, i + 2);
                if (map.containsKey(b)) {
                    for (String s : map.get(b)) {
                        if (pyramid(bottom.substring(0, i) + s + bottom.substring(i + 2), top + bottom.charAt(i), map)) {
                            return true;
                        }
                    }
                }
            }
        }
        // 都不满足，返回false
        return false;
    }
} 