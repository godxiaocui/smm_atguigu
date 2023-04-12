package com.czh.spring;

import com.czh.spring.aop.annotation.Calculator;
import com.czh.spring.aop.annotation.LoggerAspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopTest {
    @Test
    public void testAOPTest(){
        /**
         * 最关键的点是Calculator bean = ioc.getBean(Calculator.class); 这个语句
         * CalculatorImpl.class 不是实利对象，也不是代理对象
         * 因为代理类实现了和目标类一样的接口所以可以用Calculator.class实现
         */
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        System.out.println(bean.add(1,2));
        System.out.println(bean.div(1,0));
    }
}
