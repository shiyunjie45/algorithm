package com.sky.algorithmleetcode;

/*
在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上
。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。) 返回 ExamRoom(int N) 类，它有两个
公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代
表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。   示例： 输入：["ExamRoom"
,"seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]] 输出：[null
,0,9,4,2,null,5] 解释： ExamRoom(10) -> null seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。 sea
t() -> 9，学生最后坐在 9 号座位上。 seat() -> 4，学生最后坐在 4 号座位上。 seat() -> 2，学生最后坐在 2 号座位上。 le
ave(4) -> null seat() -> 5，学生最后坐在 5 号座位上。    提示：  	1 	在所有的测试样例中 ExamRoom.seat() 
和 ExamRoom.leave() 最多被调用 10^4 次。 	保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
*/

 java.util.TreeSet;

class ExamRoom {
    // 按距离排序的座位集合
    TreeSet<Integer> seatSet;
    // 整个座位总数
    int N;

    public ExamRoom(int N) {
        this.N = N;
        seatSet = new TreeSet<>();
    }

    public int seat() {
        // 如果座位集合为空，那么学生就座在0号位置
        if (seatSet.isEmpty()) {
            seatSet.add(0);
            return 0;
        }
        // 记录两个相邻座位之间的最大距离
        int dist = seatSet.first();
        int prev = -1;
        for (int s : seatSet) {
            if (prev >= 0) {
                int d = (s - prev) / 2;
                if (d > dist) {
                    dist = d;
                    // 记录学生座位的位置
                    int seat = prev + d;
                    seatSet.add(seat);
                    return seat;
                }
            }
            prev = s;
        }
        // 如果只有一段连续的座位，那么学生坐在最后一个座位上
        if (N - 1 - seatSet.last() > dist) {
            int seat = N - 1;
            seatSet.add(seat);
            return seat;
        }
        // 如果没有合适的座位可以坐，返回-1
        return -1;
    }

    public void leave(int p) {
        seatSet.remove(p);
    }
} 