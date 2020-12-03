package com.aj.array;

/**
 * @author aka_after_jason
 * @date 12/2/20
 */


/**
 * 动态数组的实现
 */
@SuppressWarnings("unckecked")
public class AJ_ArrayList<E> { // 使用泛型

    /**
     * 数组中元素的个数
     */
    private int size;
    /**
     * 数组所有元素，泛型数组
     */
    private E[] elements;
    /**
     * 数组默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    //  元素找不到的标识
    private static final int ELEMENT_NOT_FOUND = -1;

    // 构造器
    public AJ_ArrayList(int capacity) {
        // 如果传入的数组容量小于默认容量，则使用默认容量，否则使用传入的容量
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        // 初始化泛型数组
        elements = (E[]) new Object[capacity];
    }
    // 无参构造
    public AJ_ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**************以下是定义数组的api****************/
    /**
     * 清除数组中的所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 获取数组中元素的数量
     * @return
     */
    public int size() {
        return  size;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到数组的尾部
     * @param element
     */
    public void add(E element) {
        add(size,element);
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        return old;
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        for (int i = size; i > size; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size ++;
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 保证要有capacity的容量
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return; // 这里不需要扩容，直接返回

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 创建新的容量 为旧容量的1.5倍大小
        E[] newElements = (E[]) new Object[newCapacity]; // 创建一个新的数组，并且指定大小为newCapacity
        // 然后将旧数组的内容都拷贝到新数组中
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i]; // 数据搬移
        }
        elements = newElements; // 这里还是使用旧数组
        System.out.println(oldCapacity + "扩容为：" + newCapacity);
    }

    /**
     * 数组越界异常
     * @param index
     */
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("index:"+index + ",size:" + size);
    }

    /**
     * 校验数组越界
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /**
     * 重写toString()方法
     * @return
     */
    @Override
    public String toString() {
        // 格式：size=3,[99,88,77]
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
