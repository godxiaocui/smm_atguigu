package com.czh.spring.proxy.Impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        /**
         * ClassLoader loader, 类加载器 指定加载动态生态的代理类的类加载器
         *  引导类加载器，扩展类加载器 应用类加载器 自定义类加载器
         * Class<?>[] interfaces, 获取目标对象实现的所有接口的class对象的数组
         * 实现这个类的所有的接口的数组
         *  InvocationHandler h 设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke=null;
                try{
                    System.out.println("日志" +method.getName()+"参数"+ Arrays.toString(args));
                    // proxy表示代理的对象，method 代理对象的方法 args参数列表
                    invoke = method.invoke(target, args);
                    System.out.println("日志" +method.getName()+"参数"+ Arrays.toString(args));
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("方法执行完毕");
                }

                return invoke;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
