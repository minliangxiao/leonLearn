package com.example.alip6.design_pattern.singleton.v1;

import java.io.*;

/**
 * 序列化破解单例
 */
public class SingletonEH02 implements Serializable {
//    private static final long SerialVersionUID=1L;
    private static SingletonEH02 singletonEH01 = new SingletonEH02();

    private SingletonEH02() {

    }

    public static SingletonEH02 getInstance(){
        return singletonEH01;
    }

    public Object readResolve(){
        return singletonEH01;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        序列化将对象从内存存储到硬盘中
        SingletonEH02 instance = SingletonEH02.getInstance();
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/codersnake/test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(instance);

//        反序列化将对象从硬盘读取到内存中
        FileInputStream fileInputStream = new FileInputStream("/Users/codersnake/test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SingletonEH02 instance2 = (SingletonEH02) objectInputStream.readObject();
        System.out.println(instance == instance2);

    }
}
