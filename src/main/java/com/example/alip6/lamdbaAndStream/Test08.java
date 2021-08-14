package com.example.alip6.lamdbaAndStream;

import com.example.alip6.bean.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 综合案例
 */
public class Test08 {
    public static void main(String[] args) {
        ArrayList<User> list =new ArrayList<>();
        list.add(new User("hl",23));
        list.add(new User("aa",20));
        list.add(new User("jack",26));
        list.add(new User("snake",25));
        list.add(new User("lucy",27));
        list.add(new User("hl",33));
        list.add(new User("hl",27));
        list.add(new User("hl",99));
//        要求一： 降序排序 并过滤name为hl的元素 并取出前面两位
        list.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .filter(user -> "hl".equals(user.getName())).limit(2)
                .forEach(User::print);

    }
}
