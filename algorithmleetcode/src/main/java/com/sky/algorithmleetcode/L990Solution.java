package com.sky.algorithmleetcode;

/*
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b
"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 fals
e。      示例 1： 输入：["a==b","b!=a"] 输出：false 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无
法满足第二个方程。没有办法分配变量同时满足这两个方程。  示例 2： 输出：["b==a","a==b"] 输入：true 解释：我们可以指定 a = 1 且 
b = 1 以满足满足这两个方程。  示例 3： 输入：["a==b","b==c","a==c"] 输出：true  示例 4： 输入：["a==b","b!
=c","c==a"] 输出：false  示例 5： 输入：["c==c","b==d","x!=z"] 输出：true    提示：  	1 	equati
ons[i].length == 4 	equations[i][0] 和 equations[i][3] 是小写字母 	equations[i][1] 要么是
 '='，要么是 '!' 	equations[i][2] 是 '='
*/

class L990Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;  // 初始化，每个点的父节点是它自己
        }

        // 先遍历等式，将相等的式子合并
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                int root1 = findRoot(parent, index1);
                int root2 = findRoot(parent, index2);
                parent[root1] = root2;
            }
        }

        // 再遍历不等式，判断是否不等式两边有相同祖先，如果有，则不满足等式的要求
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                int root1 = findRoot(parent, index1);
                int root2 = findRoot(parent, index2);
                if (root1 == root2) {
                    return false;
                }
            }
        }

        return true;
    }

    private int findRoot(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];  // 压缩路径，使每个节点的父节点都是根节点
            index = parent[index];
        }
        return index;
    }
} 