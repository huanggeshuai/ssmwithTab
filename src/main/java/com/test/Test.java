package com.test;

/**
 * @author huang
 * @Classname Test
 * @Description TODO
 * @Date 2019/11/3 11:25
 * @Created by huang
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int num = 5;
        int[] ascArr = new int[num];
        for(int i = 0 ; i < num; i++){
            ascArr[i] = arr[i];
        }
        int[] descArr = new int[arr.length - num];
        for(int i = 0 ; i < descArr.length; i++){
            descArr[i] = arr[i+num];
        }

        System.out.println(descArr);
    }
}
