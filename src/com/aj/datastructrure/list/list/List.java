package com.aj.datastructrure.list.list;

/**
 * @author aka_after_jason
 * @date 12/3/20
 */

/**
 * 公共接口
 */
public interface List<E> {

    //  元素找不到的标识
    int ELEMENT_NOT_FOUND = -1;


    /**
     * 清空
     */
    void clear();

    /**
     * 获取size
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 在尾部添加一个元素
     * @param element
     */
    void add(E element);

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置指定位置的元素
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 在指定位置添加元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 返回元素的位置
     * @param element
     * @return
     */
    int indexOf(E element);

}
