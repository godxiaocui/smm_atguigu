package com.czh.ssm.spring.test;

import com.czh.ssm.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ioctest {
    @Test
    public void test() {
        // 获取ICC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ioc容器bean对象
        HelloWorld helloworld = ioc.getBean("helloworld", HelloWorld.class);
        helloworld.sayHello();

    }
}
