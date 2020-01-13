package com.huang.aop.config;

import org.springframework.stereotype.Component;

/**
 * @author huang
 * @Classname Huangge
 * @Description TODO
 * @Date 2019/8/24 9:59
 * @Created by huang
 */
@Component
public class Huangge {
    public boolean ceshi(String str){
        System.out.println(str);
        return true;
    }
}
