package com.sky.algorithmleetcode;

/*
实现一个 MyCalendar 类来存放你的日程安排，你可以一直添加新的日程安排。 MyCalendar 有一个 book(int start, int end
)方法。它意味着在start到end时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start 。 
当 K 个日程安排有一些时间上的交叉时（例如K个日程安排都在同一时间内），就会产生 K 次预订。 每次调用 MyCalendar.book方法时，返回一个整数 
K ，表示最大的 K 次预订。 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCale
ndar.book(start, end) 示例 1:  MyCalendarThree(); MyCalendarThree.book(10, 20); //
 returns 1 MyCalendarThree.book(50, 60); // returns 1 MyCalendarThree.book(10, 4
0); // returns 2 MyCalendarThree.book(5, 15); // returns 3 MyCalendarThree.book(
5, 10); // returns 3 MyCalendarThree.book(25, 55); // returns 3 解释: 前两个日程安排可以预订并
且不相交，所以最大的K次预订是1。 第三个日程安排[10,40]与第一个日程安排相交，最高的K次预订为2。 其余的日程安排的最高K次预订仅为3。 请注意，最后一
次日程安排可能会导致局部最高K次预订为2，但答案仍然是3，原因是从开始到最后，时间[10,20]，[10,40]和[5,15]仍然会导致3次预订。  说明:  
	每个测试用例，调用 MyCalendar.book 函数最多不超过 400次。 	调用函数 MyCalendar.book(start, end)时， sta
rt 和 end 的取值范围为 [0, 10^9]。
*/

 java.util.ArrayList;
import java.util.List;

public class L732MyCalendarThree {
    List<int[]> calendar;

    public L732MyCalendarThree() {
        calendar = new ArrayList<>();
    }

    public int book(int start, int end) {
        calendar.add(new int[]{start, end-1});  // 注意存储数据时需要将右端点减1

        int K = 1;  // 最大的K次预订
        for (int i = 0; i < calendar.size(); i++) {
            int count = 1;  // 计算当前日程和其他日程的时间重合次数
            for (int j = i+1; j < calendar.size(); j++) {
                if (calendar.get(i)[0] < calendar.get(j)[1] && calendar.get(i)[1] > calendar.get(j)[0]) {
                    count++;
                }
            }
            K = Math.max(K, count);  // 更新最大的K次预订
        }

        return K;
    }
} 