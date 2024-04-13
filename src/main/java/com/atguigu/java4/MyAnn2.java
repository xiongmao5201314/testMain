package com.atguigu.java4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//注意 ： 如果要通过反射获取注解上的信息，该注解的生命周期必须为RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnn2 {
	
}
