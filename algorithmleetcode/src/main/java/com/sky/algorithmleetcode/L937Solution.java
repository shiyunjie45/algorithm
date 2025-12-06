package com.sky.algorithmleetcode;

/*
你有一个日志数组 logs。每条日志都是以空格分隔的字串。 对于每条日志，其第一个字为字母数字标识符。然后，要么：  	标识符后面的每个字将仅由小写字母组成，或
； 	标识符后面的每个字将仅由数字组成。  我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。 将日志重新排序，使得所有字母日
志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。 返回日志的最终顺序。   示例 ： 输
入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"] 输出：["g1 a
ct car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]    提示：  	0 	3 	lo
gs[i] 保证有一个标识符，并且标识符后面有一个字。
*/

 java.util.Arrays;
import java.util.Comparator;

public class L937Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComparator = (String s1, String s2) -> {
            // 将非数字日志和数字日志分开处理
            String[] str1 = s1.split(" ", 2);
            String[] str2 = s2.split(" ", 2);

            boolean isNum1 = Character.isDigit(str1[1].charAt(0));
            boolean isNum2 = Character.isDigit(str2[1].charAt(0));

            // 都是数字日志，按原序返回
            if (isNum1 && isNum2) {
                return 0;
            }

            // s1是数字日志，s2是非数字日志，s2排在前面
            if (isNum1 && !isNum2) {
                return 1;
            }

            // s1是非数字日志，s2是数字日志，s1排在前面
            if (!isNum1 && isNum2) {
                return -1;
            }

            // s1和s2都是非数字日志，要按照题目要求排序
            int cmp = str1[1].compareTo(str2[1]);
            if (cmp != 0) {
                return cmp;
            }
            return str1[0].compareTo(str2[0]);
        };
        Arrays.sort(logs, myComparator);
        return logs;
    }

    public static void main(String[] args) {
        L937Solution sol = new L937Solution();
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] res = sol.reorderLogFiles(logs);
        System.out.println(Arrays.toString(res));
    }
} 