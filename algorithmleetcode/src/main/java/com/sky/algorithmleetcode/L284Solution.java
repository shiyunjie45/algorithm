package com.sky.algorithmleetcode;

/*
给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由
 next() 方法返回的元素 peek() 出来。 示例: 假设迭代器被初始化为列表 [1,2,3]。 调用 next() 返回 1，得到列表中的第一个元素。
 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。 最后一次调用 next() 返回 3，末尾元素。在此之后调用 has
Next() 应该返回 false。  进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
*/

import java.util.Iterator;

public class L284Solution implements Iterator<Integer> {
    private Integer next;    // 缓存下一个元素
    private Iterator<Integer> iterator;

    public L284Solution(Iterator<Integer> iterator) {
        // 构造函数中传入迭代器
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();     // 缓存第一个元素
        }
    }

    public Integer peek() {
        return next;    // 返回缓存的下一个元素
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer res = next;     // 返回缓存起来的下一个元素
        next = iterator.hasNext() ? iterator.next() : null;  // 缓存新的下一个元素
        return res;
    }
} 