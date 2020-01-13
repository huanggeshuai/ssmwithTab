package com.huang;

/**
 * @author huang
 * @Classname Test
 * @Description TODO
 * @Date 2019/4/24 22:23
 * @Created by huang
 */
public class Test {


    String str = "qwer";
    char[] er = {'a','b','c'};
    int a = 1;
    int[] intarr =  {2,3,4,5,6};
    public static void main(String[] args) {
        Test a = new Test();
        a.exchange(a.str, a.er,a.a, a.intarr);
        System.out.println(a.str);
        System.out.println(a.er);
        System.out.println(a.a);
        System.out.println(a.intarr);

    }

    public void  exchange(String str, char[] a, int b, int[] arr){
        str = "asdf";
        a[0] = 'q';
        b = 3;
        arr[0] = 100;
    }

}
