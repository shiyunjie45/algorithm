package com.sky.algorithmleetcode;

/*
我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 targe
t。 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回
 -1。   示例 1： 输入： ["with", "example", "science"], "thehat"  输出： 3  解释： 我们可以使用 2 个
 "with" 贴纸，和 1 个 "example" 贴纸。 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。 此外，这是形成目标字符串
所需的最小贴纸数量。  示例 2： 输入： ["notice", "possible"], "basicbasic"  输出： -1  解释： 我们不能通过剪切
给定贴纸的字母来形成目标“basicbasic”。    提示：  	stickers 长度范围是 [1, 50]。 	stickers 由小写英文单词组成（不
带撇号）。 	target 的长度在 [1, 15] 范围内，由小写字母组成。 	在所有的测试案例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选
取的，目标是两个随机单词的串联。 	时间限制可能比平时更具挑战性。预计 50 个贴纸的测试案例平均可在35ms内解决。
*/

 java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L691Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] cnt = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char ch : stickers[i].toCharArray()) {
                cnt[i][ch - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        return dfs(memo, cnt, target);
    }

    private int dfs(Map<String, Integer> memo, int[][] cnt, String target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int[] tarArr = new int[26];
        for (char ch : target.toCharArray()) {
            tarArr[ch - 'a']++;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tarArr[j] > 0) {
                    for (int k = 0; k < Math.max(0, tarArr[j] - cnt[i][j]); k++) {
                        sb.append((char) (j + 'a'));
                    }
                }
            }
            int tmp = dfs(memo, cnt, sb.toString());
            if (tmp != -1) {
                res = Math.min(res, 1 + tmp);
            }
        }

        res = res == Integer.MAX_VALUE ? -1 : res;
        memo.put(target, res);

        return res;
    }
} 