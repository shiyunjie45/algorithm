package com.sky.algorithmleetcode;

/*
实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。 MyCalendar 有一个 book
(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end
), 实数 x 的范围为，  start 。 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。 每次调用 MyCalen
dar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。 请按照
以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, en
d)   示例： MyCalendar(); MyCalendar.book(10, 20); // returns true MyCalendar.book(
50, 60); // returns true MyCalendar.book(10, 40); // returns true MyCalendar.boo
k(5, 15); // returns false MyCalendar.book(5, 10); // returns true MyCalendar.bo
ok(25, 55); // returns true 解释： 前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。 第四个日程
安排活动（5,15）不能添加至日历中，因为它会导致三重预订。 第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。 第六个日程安排（
25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订； 时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双
重预订。    提示：  	每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。 	调用函数 MyCalendar.book(sta
rt, end)时， start 和 end 的取值范围为 [0, 10^9]。
*/

 java.util.*;

public class L731Solution {
    
    private TreeMap<Integer, Integer> calendar;

    public L731Solution() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
} 