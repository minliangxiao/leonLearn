package com.example.alip6.test.controller;

import static java.lang.Thread.sleep;

public class TestBean  implements Runnable{

    @Override
    public void run() {
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
