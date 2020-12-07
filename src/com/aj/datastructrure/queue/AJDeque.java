package com.aj.datastructrure.queue;

/**
 * @author aka_after_jason
 * @date 12/7/20
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 双端队列
 * 双端队列(Deque):
 *  * 双端队列是能在头尾两端添加、删除的队列
 *  * 应为deque是 double ended queue的简称
 *  *  * 接口设计：
 *  *  * int size()
 *  *  * boolean isEmpty()
 *  *  * void clear()
 *  *  * void enQueueRear(E element) // 从队尾入队
 *  *  * E deQueueFront() // 从队头出队
 *  *  * void enQueueFront(E element) // 从队头入队
 *  *  * E deQueueRear() // 从队尾出队
 *  *  * E fornt() // 获取队列的头元素
 *  *  * E rear() // 获取队列的尾元素
 */
public class AJDeque<E> { // 双端队列：    队尾 -> 1 2 3 4 5 ->  队头(下标为0)

    // 使用系统的双向链表实现
    private List<E> list = new LinkedList<>();

    /*********************api*****************/
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    /**
     * 从队尾入队
     * @param element
     */
    public void enQueueRear(E element) {
        list.add(element);
    }

    /**
     * 从队头入队
     * @param element
     */
    public void enQueueFront(E element) {
        list.add(0,element);
    }

    /**
     * 从队头出队
     * @return
     */
    public E deQueueFront() {
        return list.remove(0);
    }

    /**
     * 从队尾出队
     * @return
     */
    public E deQueueRear() {
        return list.remove(list.size()-1);
    }

    /**
     * 获取队头的元素
     * @return
     */
    public E front() {
        return list.get(0);
    }

    /**
     * 获取队尾的元素
     * @return
     */
    public E rear() {
        return list.get(list.size()-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(list.size()).append(", [");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(list.get(i));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
