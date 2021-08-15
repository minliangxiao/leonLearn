package com.example.alip6.lamdbaAndStream;

import com.example.alip6.bean.User;

import java.util.Locale;
import java.util.Optional;

/**
 * 案例三
 */
public class OptionalDemo4 {
    public static void main(String[] args) {
        String userName = OptionalDemo4.getUserName();
        System.out.println(userName);
    }
    public static String getUserName() {
        User user = new User("growyb",22);
        return Optional.ofNullable(user).map(user1 -> user1.getName()).map(userName->userName.toUpperCase()).orElse(null);
    }
}
