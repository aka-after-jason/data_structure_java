package com.aj.interview.queue;

/**
 * @author aka_after_jason
 * @date 12/5/20
 */

import java.util.Stack;

/**
 * 使用栈来实现队列：
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * 准备两个栈： inStack, outStack
 * 入队时：push到inStack中
 * 出队时：
 *      如果outStack为空，将 inStack所有元素逐一弹出，push到outStack， outStack弹出栈顶元素
 *      如果outStack不为空，outStack弹出栈顶元素
 */
public class ImpQueueUsingStack {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public ImpQueueUsingStack() {// 初始化
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * 入队
     * @param x
     */
    public void enQueue(int x){
        inStack.push(x);
    }

    /**
     * 出队
     * @return
     */
    public int deQueue() {
        checkOutStack();
        return outStack.pop();
    }

    /**
     * 获取队头元素
     * @return
     */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * 判断 outStack 是否为空
     */
    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ImpQueueUsingStack queue = new ImpQueueUsingStack();
        queue.enQueue(1);
        queue.enQueue(2);
        System.out.println("队头元素：" + queue.peek());
        System.out.println("是否为空：" + queue.isEmpty());
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue()); // 1 2
        }
    }
}
