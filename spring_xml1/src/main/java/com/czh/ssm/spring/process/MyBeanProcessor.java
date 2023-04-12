package com.czh.ssm.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        //此方法在生命周期初始化之前执行
        System.out.println("☆☆☆" + beanName + " = " + bean);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //此方法在生命周期初始化之后执行
        System.out.println("☆☆☆" + beanName + " = " + bean);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
