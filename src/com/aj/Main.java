package com.aj;

import com.aj.array.AJ_ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("data_structure_java");


        /********************1.动态数组的测试************************/
        AJ_ArrayList<Object> aj_arrayList = new AJ_ArrayList();
        aj_arrayList.add(1);
        aj_arrayList.add(2);
        aj_arrayList.add("jason");
        aj_arrayList.add(0,"abc");
        aj_arrayList.remove(aj_arrayList.size()-1);
        System.out.println(aj_arrayList.toString());
    }
}

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