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
 * 单向链表
 * @param <E>
 */
public class AJ_SingleLinkedList<E> extends AbstractList<E> {
    /**
     * 两个元素：
     * 1.链表的元素个数：size
     * 2.第一个节点 ： firstnode
     *
     * 注意点：在编写链表过程中，要注意边界测试，比如 index为0， size-0, size时
     */
    private Node<E> firstNode;

    // 提供一个静态内部类
    private static class Node<E> {
        E element;
        Node<E> nextNode;
        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
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
        // 需要遍历
        Node<E> node = firstNode; // 拿到第一个节点
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }
        return node;
    }

    /**
     * 清空节点
     */
    public void clear() {
        size = 0;
        firstNode = null;
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
        if (index == 0) { // 0位置
            firstNode = new Node<>(element,firstNode);
        }else { // 不是0位置
            // 获取上一个节点
            Node<E> prev = getNode(index - 1);
            Node<E> newNode = new Node<>(element,prev.nextNode);
            prev.nextNode = newNode;
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
        Node<E> node = firstNode;
        if (index == 0) {
            firstNode = firstNode.nextNode;
        }else {
            // 获取上一个node节点
            Node<E> prev = getNode(index);
            node = prev.nextNode; // 保存一下要删除的节点
            prev.nextNode = node.nextNode; // 要删除节点的上一个节点 指向 要删除节点的下一个节点
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
            stringBuilder.append(node.element);
            node = node.nextNode;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
