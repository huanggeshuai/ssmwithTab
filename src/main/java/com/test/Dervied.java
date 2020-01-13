package com.test;

/**
 * @author huang
 * @Classname Dervied
 * @Description TODO
 * @Date 2019/11/3 0:27
 * @Created by huang
 */
public class Dervied extends Base {

    private String name = "dervied";

    public Dervied() {
        tellName();
        printName();
    }

    @Override
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }

    @Override
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }

    public static void main(String[] args){

        new Dervied();
    }
}
