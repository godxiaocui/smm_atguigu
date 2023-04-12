package com.czh.ssm.spring.factory;

import com.czh.ssm.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean 是一个接口，创建一个类实现这个接口
 * 三个方法
 * getObject（）将一个对象提供给ioc管理
 * getObjectType() 设置提供对象的类型
 *isSingleton() 所提供的对象是否是单利
 * 将FactoryBean的实现类配置为Bean时，会将当前类中的getObject()返回的对象给ioc容器
 */
public class UserfactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
