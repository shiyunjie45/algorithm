package com.sky.algorithmleetcode;

/*
回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。 每一次，你可以从手里的球选一
个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有
的球都被移除。 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。  示例: 输入: "WRRBBW", "RB" 输出:
 -1 解释: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW （翻译者标注：手上球已经用完，桌上还剩两个球无法消除，
返回-1） 输入: "WWRRBBWW", "WRBRW" 输出: 2 解释: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWB
B[B]WW -> WWWW -> empty 输入:"G", "GGGGG" 输出: 2 解释: G -> G[G] -> GG[G] -> empty  输
入: "RBYYBBRRB", "YRBGB" 输出: 3 解释: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -
> B -> B[B] -> BB[B] -> empty  标注:  	你可以假设桌上一开始的球中，不会有三个及三个以上颜色相同且连着的球。 	桌上的球不会超
过20个，输入的数据中代表这些球的字符串的名字是 "board" 。 	你手中的球不会超过5个，输入的数据中代表这些球的字符串的名字是 "hand"。 	输入的
两个字符串均为非空字符串，且只包含字符 'R','Y','B','G','W'。
*/

 java.util.*;
public class L488Solution {
    public int findMinStep(String board, String hand) {
        // 建立颜色到数量的映射表，以便统计手里的球
        Map<Character, Integer> handMap = new HashMap<>();
        for (int i = 0; i < hand.length(); i++) {
            char c = hand.charAt(i);
            handMap.put(c, handMap.getOrDefault(c, 0) + 1);
        }

        return dfs(board, handMap);
    }

    private int dfs(String board, Map<Character, Integer> handMap) {
        // 如果桌上没有球，表示已经清空，直接返回0
        if (board.length() == 0) {
            return 0;
        }

        int cnt = Integer.MAX_VALUE; // 表示需要的球的数量

        // 初始化变量
        int i = 0, j = 1; // i是开始位置，j是结束位置
        while (j <= board.length()) {
            // 如果当前位置和下一个位置颜色不同，或者已经到达最后一位
            if (j == board.length() || board.charAt(j) != board.charAt(i)) {
                // 当前颜色所需要的球的数量
                int need = 3 - (j - i);
                // 当前颜色的数量
                int colorCnt = 0;
                for (int k = i; k < j; k++) {
                    if (handMap.containsKey(board.charAt(k))) {
                        colorCnt++;
                    }
                }
                // 如果可以补足颜色数量，继续递归
                if (handMap.containsKey(board.charAt(i)) && handMap.get(board.charAt(i)) >= need) {
                    handMap.put(board.charAt(i), handMap.get(board.charAt(i)) - need);
                    int res = dfs(removeConsecutiveChars(board.substring(0, i) + board.substring(j)), handMap);
                    // res >= 0 表示可以移除后面的球
                    if (res >= 0) {
                        cnt = Math.min(cnt, res + need);
                    }
                    handMap.put(board.charAt(i), handMap.get(board.charAt(i)) + need);
                }

                i = j;
            }
            j++;
        }

        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }

    // 移除字符串中连续的字符，即球
    private String removeConsecutiveChars(String s) {
        int i = 0, j = 1;
        while (j <= s.length()) {
            if (j == s.length() || s.charAt(j) != s.charAt(i)) {
                if (j - i >= 3) {
                    s = s.substring(0, i) + s.substring(j);
                    i = 0;
                    j = 1;
                } else {
                    i = j;
                }
            } else {
                j++;
            }
        }
        return s;
    }
} 