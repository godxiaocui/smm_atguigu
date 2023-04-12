package com.czh.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Order(1)
/**
 * 切面的优先级
 */
public class ValidateAspect {
    @Before("com.czh.spring.aop.annotation.LoggerAspect.logPointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect--> 前置通知");
    }
}
