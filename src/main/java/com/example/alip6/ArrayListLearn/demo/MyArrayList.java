package com.example.alip6.ArrayListLearn.demo;

import java.util.Arrays;

/**
 * 简化的一个自定义ArrayList
 * @param <T>
 */
public class MyArrayList<T> {

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    // 初始化容量
    private static final int DEFAULT_CAPACITY = 10;
    // 数组
    transient Object[] elementData;

    /**
     * 当前数组存放元素的个数
     */
    private int size;

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public void  add(T t){
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            elementData=Arrays.copyOf(elementData,DEFAULT_CAPACITY);
        }
        // 扩容
        if ((size+1-elementData.length)>0){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            elementData = Arrays.copyOf(elementData, newCapacity);

        }
        elementData[size++] = t;
    }

    public T get(int i){
        return (T) elementData[i];
    }

    public static void main(String[] args) {
        MyArrayList<Object> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add("111");

        System.out.println(list.elementData.length);
    }
}
