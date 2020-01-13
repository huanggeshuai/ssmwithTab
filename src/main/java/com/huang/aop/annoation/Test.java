package com.huang.aop.annoation;

import java.lang.annotation.*;

/**
 * @author huang
 * @Classname Test
 * @Description TODO
 * @Date 2019/8/20 20:12
 * @Created by huang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Test {
    String value();
}
