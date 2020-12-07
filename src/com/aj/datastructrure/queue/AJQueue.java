package com.aj.datastructrure.queue;

/**
 * @author aka_after_jason
 * @date 12/4/20
 */

import com.aj.datastructrure.list.linkedlist.AJ_TwowayLinkedList;

/**
 * 队列(Queue)
 * 队列是一种特殊的线性表，只能在头尾两端进行操作
 * 队尾(rear):只能从队尾添加元素，一般叫做enQueue,入队
 * 队头(front):只能从队头移除元素，一般叫做deQueue,出队
 *
 * 先进先出原则：First In First Out, FIFO
 *
 *
 *
 * 队列的内部实现是否可以直接利用以前学过的数据结构？
 * 动态数组、链表
 * 优先使用双向链表，因为队列主要是往头尾操作元素
 *
 * 队列的接口设计：
 * int size() // 元素的数量
 * boolean isEmpty() // 是否为空
 * void clear() // 清空
 * void enQueue(E element) // 入队
 * E deQueue() // 出队
 * E front() // 获取队列的头元素
 *
 *
 * 双端队列(Deque):
 * 双端队列是能在头尾两端添加、删除的队列
 * 应为deque是 double ended queue的简称
 *  * 接口设计：
 *  * int size()
 *  * boolean isEmpty()
 *  * void clear()
 *  * void enQueueRear(E element) // 从队尾入队
 *  * E deQueueFront() // 从队头出队
 *  * void enQueueFront(E element) // 从队头入队
 *  * E deQueueRear() // 从队尾出队
 *  * E fornt() // 获取队列的头元素
 *  * E rear() // 获取队列的尾元素
 *
 *
 *
 * 循环队列(Circle Queue)
 * 其实队列底层也可以使用动态数组实现，并且各项接口可以优化到 O(1) 的时间复杂度
 * 这个用数组实现并且优化之后的队列也叫做： 循环队列
 *
 * 循环双端队列：可以进行两端添加、删除操作的循环队列
 *
 */
public class AJQueue<E> {

    // 优先使用双向链表
    private AJ_TwowayLinkedList<E> linkedList = new AJ_TwowayLinkedList();

    /**
     * 获取元素的数量
     * @return
     */
    public int size() {
        return linkedList.size();
    }
    public void clear() {
        linkedList.clear();
    }
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * 入队
     * @param element
     */
    public void enQueue(E element) {
        linkedList.add(element);
    }

    /**
     * 出队
     */
    public E deQueue() {
        return linkedList.remove(0);
    }

    /**
     * 获取队头元素
     * @return
     */
    public E front() {
        return linkedList.get(0);
    }
}
