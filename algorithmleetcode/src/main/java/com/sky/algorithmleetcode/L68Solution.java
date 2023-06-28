package com.sky.algorithmleetcode;

/*
给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 你应该使用“贪心算法”来放置给
定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 要求尽可能均匀分配单词间的空格数量。如
果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 说明:  	单词是指由非空格字
符组成的字符序列。 	每个单词的长度大于 0，小于等于 maxWidth。 	输入单词数组 words 至少包含一个单词。  示例: 输入: words = [
"This", "is", "an", "example", "of", "text", "justification."] maxWidth = 16 输出:
 [    "This    is    an",    "example  of text",    "justification.  " ]  示例 2: 
输入: words = ["What","must","be","acknowledgment","shall","be"] maxWidth = 16 输出:
 [   "What   must   be",   "acknowledgment  ",   "shall be        " ] 解释: 注意最后一行
的格式应为 "shall be  " 而不是 "shall   be",    因为最后一行应为左对齐，而不是左右两端对齐。       第二行同样为左对齐，这
是因为这行只包含一个单词。  示例 3: 输入: words = ["Science","is","what","we","understand","well"
,"enough","to","explain",      "to","a","computer.","Art","is","everything","els
e","we","do"] maxWidth = 20 输出: [   "Science  is  what we",  "understand      we
ll",   "enough to explain to",   "a  computer.  Art is",   "everything  else  we
",   "do                  " ]
*/

 java.util.ArrayList;
import java.util.List;

public class L68Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        // 初始化左右指针 l、r
        int l = 0, r = -1;
        while (true) {
            // 找到下一行最后一个单词的位置
            int len = 0;
            while (r + 1 < n && len + words[r + 1].length() + r - l + 1 <= maxWidth) {
                r++;
                len += words[r].length();
            }
            // 判断是否为最后一行
            boolean isLastLine = r == n - 1;

            // 计算空格数量和插入位置
            int spaces = maxWidth - len;
            int gaps = r - l;
            // 当前行只有一个单词
            if (gaps == 0) {
                res.add(words[l] + " ".repeat(spaces));
            } else if (isLastLine) { // 最后一行左右对齐
                StringBuilder sb = new StringBuilder();
                for (int i = l; i <= r; i++) {
                    sb.append(words[i]);
                    if (i < r) sb.append(" ");
                }
                sb.append(" ".repeat(spaces - gaps));
                res.add(sb.toString());
            } else {
    // 普通行均匀分配空格
                int avgSpaces = spaces / gaps;
                int lefts = spaces % gaps;
                String spacesStr = " ".repeat(avgSpaces);
                StringBuilder sb = new StringBuilder();
                for (int i = l; i <= r; i++) {
                    sb.append(words[i]);
                    if (i < r) sb.append(spacesStr);
                    if (lefts > 0) {
                        sb.append(" ");
                        lefts--;
                    }
                }
                res.add(sb.toString());
            }

            // 更新左指针
            l = r + 1;
            if (l >= n) break;
        }
        return res;
    }
} 