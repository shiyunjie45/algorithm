package com.sky.algorithmleetcode;

/*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 锁的初始数字为 '0000' ，一个代表四
个拨轮的数字的字符串。 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 字符串 ta
rget 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。   示例 1:  输入：deadends = ["0201","01
01","0102","1212","2002"], target = "0202" 输出：6 解释： 可能的移动序列为 "0000" -> "1000" ->
 "1100" -> "1200" -> "1201" -> "1202" -> "0202"。 注意 "0000" -> "0001" -> "0002" -
> "0102" -> "0202" 这样的序列是不能解锁的， 因为当拨动到 "0102" 时这个锁就会被锁定。  示例 2:  输入: deadends = 
["8888"], target = "0009" 输出：1 解释： 把最后一位反向旋转一次即可 "0000" -> "0009"。  示例 3:  输入: d
eadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8
888" 输出：-1 解释： 无法旋转到目标数字且不被锁定。  示例 4:  输入: deadends = ["0000"], target = "8888" 
输出：-1    提示：  	死亡列表 deadends 的长度范围为 [1, 500]。 	目标数字 target 不会在 deadends 之中。 	每个 
deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
*/

 class L752Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (deadSet.contains(start)) {
            return -1;
        }
        if (target.equals(start)) {
            return 0;
        }
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (String next : getNext(curr)) {
                    if (visited.contains(next) || deadSet.contains(next)) {
                        continue;
                    }
                    if (next.equals(target)) {
                        return step;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    private List<String> getNext(String curr) {
        List<String> nextList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = curr.charAt(i);
            String s1 = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1);
            String s2 = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);
            nextList.add(s1);
            nextList.add(s2);
        }
        return nextList;
    }
} 