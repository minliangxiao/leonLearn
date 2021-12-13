package com.example.alip6.HashMapLearn.bean;

public class HashKey {
    private String name;
    private String id;

    public HashKey(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "HashKey{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
