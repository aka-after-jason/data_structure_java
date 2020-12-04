package com.aj.datastructrure.stack;

/**
 * @author aka_after_jason
 * @date 12/4/20
 */

import com.aj.datastructrure.list.arraylist.AJ_ArrayList;
import com.aj.datastructrure.list.list.List;

/**
 * 栈(Stack)
 * 栈是一种特殊的线性表，只能在一端进行操作
 * 往栈中添加元素的操作，叫做push，入栈
 * 从栈中移除元素的操作，叫做pop，出栈(只能移除栈顶元素，也叫做：弹出栈顶元素)
 * 后进先出原则：Last In First Out, LIFO
 *
 *
 * 应用场景：
 * 1.浏览器的前进后退
 * 2.括号的匹配
 */
public class AJStack<E> {

    /*************接口设计**********/
    // 这里直接使用之前的AJ_ArrayList
    private List<E> list = new AJ_ArrayList<>();

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 获取栈里面元素的个数
     * @return
     */
    public int size() {
        return list.size();
    }

    /**
     * 添加元素
     * @param ellment
     */
    public void push(E ellment) {
        list.add(ellment);
    }

    /**
     * 移除栈顶元素
     * @return
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E top() {
        return list.get(list.size() - 1);
    }
}
