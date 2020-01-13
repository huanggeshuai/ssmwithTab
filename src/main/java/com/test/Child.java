package com.test;

/**
 * @author huang
 * @Classname Child
 * @Description TODO
 * @Date 2019/11/3 0:23
 * @Created by huang
 */
public class Child extends Father {

    private Father father;

    public Child(){
        System.out.println(4);
    }

    public Child(String name){
        super();
        System.out.println("3");
        father = new Father(name);
    }

    public static void main(String[] args) {
        new Child("1111");
        boolean[] arr = new boolean[15];
        for (boolean b: arr) {
            System.out.println(b);
        }
    }
}
