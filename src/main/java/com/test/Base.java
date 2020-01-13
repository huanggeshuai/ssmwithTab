package com.test;

/**
 * @author huang
 * @Classname Base
 * @Description TODO
 * @Date 2019/11/3 0:27
 * @Created by huang
 */
class Base {

    private String name = "base";

    public Base() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println("Base tell name: " + name);
    }

    public void printName() {
        System.out.println("Base print name: " + name);
    }
}
