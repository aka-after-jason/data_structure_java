package com.aj.datastructrure.list.linkedlist;

/**
 * @author aka_after_jason
 * @date 12/3/20
 */

import com.aj.datastructrure.list.list.AbstractList;

/**
 * 链表(Linked List)
 * 动态数组有个明显的缺点：
 * 1.可能会造成内存空间的大量浪费
 *
 * 能否用到多少就申请多少内存呢？
 * 链表可以办到这一点
 *
 * 链表是一种链式存储的线性表，所有元素的内存地址不一定是连续的
 *
 */

/**
 * 双向链表的使用
 * @param <E>
 */
public class AJ_TwowayLinkedList<E> extends AbstractList<E> {
    /**
     * 两个元素：
     * 1.链表的元素个数：size
     * 2.第一个节点 ： firstnode
     *
     * 注意点：在编写链表过程中，要注意边界测试，比如 index为0， size-0, size时
     */
    private Node<E> firstNode; // 头结点
    private Node<E> lastNode; // 尾结点

    // 提供一个静态内部类
    private static class Node<E> { // 每一个结点包含：prev，element，next
        Node<E> prevNode;
        E element;
        Node<E> nextNode;
        public Node(Node<E> prevNode, E element, Node<E> nextNode) {
            this.prevNode = prevNode;
            this.element = element;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prevNode != null) {
                sb.append(prevNode.element);
            }else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (nextNode != null) {
                sb.append(nextNode.element);
            }else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    /******************链表api*****************/
    /**
     * 根据下标获取对应node节点(关键方法)
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        rangeCheck(index);

        if (index < (size >> 1)) { // 从链表的左边开始  size >> 1 相当于 size / 2
            Node<E> node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
            return node;
        }else { // 从链表的尾部开始
            Node<E> node = lastNode;
            for (int i = size - 1; i > index; i--) {
                node = node.prevNode;
            }
            return node;
        }
    }

    /**
     * 清空节点
     */
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
    }

    /**
     * 根据下标返回对应节点的元素
     * @param index
     * @return
     */
    public E get(int index) {
        // 根据下标 拿到对应的node节点
        Node<E> node = getNode(index);
        return node.element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 添加元素--------注意0位置
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size) { // 往最后面添加元素
            Node<E> oldLastNode = lastNode; // 获取最后一个结点
            lastNode = new Node<>(oldLastNode,element,null);
            if (oldLastNode == null) { // 这里表示链表添加第一个元素
                firstNode = lastNode;
            }else {
                oldLastNode.nextNode = lastNode;
            }
        }else {
            // 比如说 在2的位置插入一个新的节点
            Node<E> nextNode = getNode(index); // 获取index位置的节点,就相当于要插入节点的下一个节点
            // 获取index节点的上一个节点
            Node<E> prevNode = nextNode.prevNode;
            // 创建新的节点
            Node<E> newNode = new Node<>(prevNode,element,nextNode);
            /** 接线:两步
             *  1.下一个节点的prev指针指向新插入的节点
             *  2.上一个节点的next指针指向新的节点
             */
            nextNode.prevNode = newNode; // 下一个节点的prev指针指向新插入的节点
            if (prevNode == null) { // 表示在0位置插入新的节点
                firstNode = newNode;
            }else {
                prevNode.nextNode = newNode; // 上一个节点的next指针指向新的节点
            }
        }
        size ++;
    }

    /**
     * 删除一个元素-----注意0位置
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        // 获取index对应的节点
        Node<E> node = getNode(index);
        // 获取上一个节点
        Node<E> prev = node.prevNode;
        // 获取下一个节点
        Node<E> next = node.nextNode;
        // 接线：
        if (prev == null) { // 表示删除第一个节点
            firstNode = next;
        }else {
            prev.nextNode = next;
        }
        if (next == null) { // 删除最后一个节点
            lastNode = prev;
        }else {
            next.prevNode = prev;
        }
        size --;
        return node.element;
    }

    /**
     * 获取元素对应的下标
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = firstNode;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.nextNode;
            }
        }else {
            Node<E> node = firstNode;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.nextNode;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = firstNode;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(node);
            node = node.nextNode;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
