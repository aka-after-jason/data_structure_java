package com.aj.datastructrure.queue.circle;

/**
 * @author aka_after_jason
 * @date 12/7/20
 */

/**
 * 循环双端队列
 */
public class AJCircleDeque<E> {
    // 指向队头
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public AJCircleDeque() {
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
     * 从尾部入队
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[getIndex(size)] = element;
        size++;
    }

    /**
     * 从头部入队
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = getIndex(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从头部出队
     * @return
     */
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = getIndex(1);
        size --;
        return frontElement;
    }

    /**
     * 从尾部出队
     * @return
     */
    public E deQueueRear() {
        int rearIndex = getIndex(size-1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size --;
        return rear;
    }

    /**
     * 获取队头元素
     * @return
     */
    public E front() {
        return elements[front];
    }

    /**
     * 获取队尾元素
     * @return
     */
    public E rear() {
        return elements[getIndex(size-1)];
    }

    /**
     * 封装索引（关键方法）
     * @param index
     * @return
     */
    private int getIndex(int index) {
        index += front;
        if (index < 0) {
            return index + elements.length;
        }
        return index - (index >= elements.length ? elements.length : 0);
    }

    /**
     * 扩容
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return; // 不需要扩容
        // 新容量为旧容量的1.5倍大小
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 创建新的数组
        E[] newElements = (E[]) new Object[newCapacity];
        // 将之前的数组的内容都拷贝到新数组中
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[getIndex(i)];
        }
        elements = newElements;
        // 重置front
        front = 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capcacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
