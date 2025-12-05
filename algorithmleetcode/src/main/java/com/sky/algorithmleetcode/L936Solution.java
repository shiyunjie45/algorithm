package com.sky.algorithmleetcode;

/*
你想要用小写字母组成一个目标字符串 target。  开始的时候，序列由 target.length 个 '?' 记号组成。而你有一个小写字母印章 stamp。
 在每个回合，你可以将印章放在序列上，并将序列中的每个字母替换为印章上的相应字母。你最多可以进行 10 * target.length  个回合。 举个例子，如
果初始序列为 "?????"，而你的印章 stamp 是 "abc"，那么在第一回合，你可以得到 "abc??"、"?abc?"、"??abc"。（请注意，印章
必须完全包含在序列的边界内才能盖下去。） 如果可以印出序列，那么返回一个数组，该数组由每个回合中被印下的最左边字母的索引组成。如果不能印出序列，就返回一个空数组
。 例如，如果序列是 "ababc"，印章是 "abc"，那么我们就可以返回与操作 "?????" -> "abc??" -> "ababc" 相对应的答案 [
0, 2]； 另外，如果可以印出序列，那么需要保证可以在 10 * target.length 个回合内完成。任何超过此数字的答案将不被接受。   示例 1： 
输入：stamp = "abc", target = "ababc" 输出：[0,2] （[1,0,2] 以及其他一些可能的结果也将作为答案被接受）  示例 2
： 输入：stamp = "abca", target = "aabcaca" 输出：[3,0,1]    提示：  	1 	stamp 和 target 只包
含小写字母。
*/

 java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L936Solution {
    public int[] movesToStamp(String stamp, String target) {
        int stampLen = stamp.length();
        int targetLen = target.length();
        boolean[] visited = new boolean[targetLen];
        List<Integer> ans = new ArrayList<>();
        int stars = 0;
        while (stars < targetLen) {
            boolean find = false;
            for (int i = 0; i <= targetLen - stampLen; i++) {
                if (!visited[i] && canMatch(target, i, stamp)) {
                    find = true;
                    stars = doStamp(target, i, stampLen, stars);
                    visited[i] = true;
                    ans.add(i);
                    if (stars == targetLen) {
                        Collections.reverse(ans);
                        return ans.stream().mapToInt(Integer::intValue).toArray();
                    }
                }
            }
            if (!find) {
                return new int[0];
            }
        }
        return new int[0];
    }

    public boolean canMatch(String target, int i, String stamp) {
        for (int j = 0; j < stamp.length(); j++) {
            if (target.charAt(i + j) != '*' && target.charAt(i + j) != stamp.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public int doStamp(String target, int i, int stampLen, int stars) {
        for (int j = 0; j < stampLen; j++) {
            if (target.charAt(i + j) != '*') {
                target = target.substring(0, i + j) + '*' + target.substring(i + j + 1);
                stars++;
            }
        }
        return stars;
    }
} 