package com.aj;

import com.aj.datastructrure.list.arraylist.AJ_ArrayList;
import com.aj.datastructrure.list.linkedlist.AJ_SingleLinkedList;
import com.aj.datastructrure.list.linkedlist.AJ_SingleLinkedListWithVituralHeadNode;
import com.aj.datastructrure.list.linkedlist.AJ_TwowayLinkedList;
import com.aj.datastructrure.list.linkedlist.circle.AJ_SingleCircleLinkedList;
import com.aj.datastructrure.list.linkedlist.circle.AJ_TwowayCircleLinkedList;
import com.aj.datastructrure.list.list.List;
import com.aj.datastructrure.queue.AJDeque;
import com.aj.datastructrure.queue.AJQueue;
import com.aj.datastructrure.queue.circle.AJCircleDeque;
import com.aj.datastructrure.queue.circle.AJCircleQueue;
import com.aj.datastructrure.stack.AJStack;

/**
 * 什么是数据结构？
 * 数据结构是计算机存储、组织数据的方式
 *
 * 线性结构：
 *          线性表：数组、链表、栈、队列、哈希表
 * 树形结构：
 *          二叉树：AVL树、红黑树、B树、堆、Trie、哈希曼树、并查集
 * 图形结构：
 *          邻接矩阵、邻接表
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("==============data_structure_java==============");


        /********************1.动态数组的测试************************/
        List<Object>  arrayList = new AJ_ArrayList();
        arrayList.add(0,1);
        arrayList.add(2);
        System.out.println("动态数组：" + arrayList.toString());

        /********************2.链表的测试************************/
        // 单向链表
        List<Object> linkedList = new AJ_SingleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println("单向链表：" + linkedList);
        // 虚拟节点单向链表的测试
        List<Object> vituralHeadLinkedList = new AJ_SingleLinkedListWithVituralHeadNode<>();
        vituralHeadLinkedList.add(1);
        vituralHeadLinkedList.add(2);
        System.out.println("虚拟节点单向链表：" + vituralHeadLinkedList);
        // 单向循环链表
        List<Object> singleCircleLinkedList = new AJ_SingleCircleLinkedList<>();
        singleCircleLinkedList.add(1);
        singleCircleLinkedList.add(2);
        singleCircleLinkedList.add(0,3);
        singleCircleLinkedList.add(singleCircleLinkedList.size(),10);// [3,1,2,10]
        singleCircleLinkedList.remove(0);//[1,2,10]
        System.out.println("单向循环链表：" + singleCircleLinkedList);
        // 双向链表
        List<Object> twowayLinkedList = new AJ_TwowayLinkedList<>();
        twowayLinkedList.add(1);
        twowayLinkedList.add(2);
        twowayLinkedList.add(0,10);
        twowayLinkedList.add(twowayLinkedList.size(),20);
        System.out.println("双向链表：" + twowayLinkedList);
        // 双向循环链表的使用
        List<Object> twowayCircleLinkedList = new AJ_TwowayCircleLinkedList<>();
        twowayCircleLinkedList.add(1);
        twowayCircleLinkedList.add(2);
        twowayCircleLinkedList.add(0,3);
        twowayCircleLinkedList.add(twowayCircleLinkedList.size(),20); // [3,1,2,20]
        twowayCircleLinkedList.remove(0);// [1,2,20]
        System.out.println("双向循环链表的使用:" + twowayCircleLinkedList);

        /********************3.栈的测试************************/
        AJStack<Integer> stack = new AJStack<>();
        stack.push(1);
        stack.push(2);
        while (stack.size() > 0) {
            System.out.println("栈的测试:" + stack.pop());
        }
        /********************4.队列的测试************************/
        // 普通队列
        AJQueue<Integer> queue = new AJQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        while (queue.size() > 0) {
            System.out.println("队列的测试:" + queue.deQueue());
        }
        // 双端队列
        AJDeque<Integer> deque = new AJDeque<>();
        deque.enQueueFront(1);
        deque.enQueueFront(2);
        deque.enQueueFront(5);
        deque.enQueueRear(3);
        deque.enQueueRear(4);
        System.out.println("从队头移除元素：" + deque.deQueueFront());
        System.out.println("从队尾移除元素：" + deque.deQueueRear());
        System.out.println("双端队列：" + deque);
        System.out.println("获取队头元素：" + deque.front());
        System.out.println("获取队尾元素：" + deque.rear());
        // 循环队列
        AJCircleQueue<Integer> circleQueue = new AJCircleQueue<>();
        circleQueue.enQueue(1);
        circleQueue.enQueue(2);
        circleQueue.deQueue();
        System.out.println("循环队列：" + circleQueue);
        // 循环双端队列
        AJCircleDeque<Integer> circleDeque = new AJCircleDeque<>();
        circleDeque.enQueueFront(1);
        circleDeque.enQueueFront(2);
        circleDeque.enQueueRear(3);
        circleDeque.enQueueRear(4);
        System.out.println("循环双端队列：" + circleDeque);
        System.out.println(circleDeque.deQueueFront());
        System.out.println(circleDeque.deQueueRear());
        System.out.println("循环双端队列：" + circleDeque);
    }
}

