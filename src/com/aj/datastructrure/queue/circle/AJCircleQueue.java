package com.aj.datastructrure.queue.circle;

/**
 * @author aka_after_jason
 * @date 12/7/20
 */

/**
 * 循环队列
 * 其实队列底层也可以使用动态数组实现，并且各项接口也可以优化到 O(1)的时间复杂度
 * 这个用数组实现并且优化之后的队列也叫做：循环队列
 */
public class AJCircleQueue<E> {
    // 指向队头
    private int front;
    private int size;
    // 泛型数组
    private E[] elements;
    // 默认数组的初始容量为10
    private static final int DEFAULT_CAPACITY = 10;

    public AJCircleQueue() { //  初始化数组
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**********循环队列的api*********/
    /**
     * 队列中元素的个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空队列
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[getIndex(i)] = null;
        }
        front = 0;
        size = 0;
    }

    /**
     * 入队
     * @param element
     */
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        elements[getIndex(size)] = element;
        size ++;
    }

    /**
     * 出队
     * @return
     */
    public E deQueue() {
        // 获取队头元素
        E frontElement = elements[front];
        elements[front] = null;
        front = getIndex(1);
        size --;
        return frontElement;
    }

    /**
     * 返回队头元素
     * @return
     */
    public E front() {
        return elements[front];
    }

    /**
     * 获取循环队列的索引（主要方法）
     * @param index
     * @return
     */
    private int getIndex(int index) {
        return (index + front) % elements.length;
    }

    /**
     * 扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return; // 不需要扩容
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 新容量为旧容量的1.5倍大小
        // 创建一个新数组，容量为newCapacity
        E[] newElements = (E[]) new Object[newCapacity];
        // 将elements中的元素都拷贝到新数组中
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[getIndex(i)];
        }
        elements = newElements;
        front = 0;// 扩容之后，队头重新设置为0
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("capacity=").append(elements.length).append(" size=").append(size)
                .append(" front=").append(front).append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
